package com.wintech.wtuser.services;

import com.wintech.wtuser.domains.Role;
import com.wintech.wtuser.domains.User;
import com.wintech.wtuser.dtos.RoleDto;
import com.wintech.wtuser.dtos.UserDto;
import com.wintech.wtuser.dtos.UserInsertDto;
import com.wintech.wtuser.repositories.RoleRepository;
import com.wintech.wtuser.repositories.UserRepository;
import com.wintech.wtuser.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService() {
    }

    public UserDto insert(UserInsertDto userInsertDto){
        User user = convertDtoToEntity(userInsertDto);
        user.setPassword(passwordEncoder.encode(userInsertDto.getPassword()));
        for(RoleDto roleDto : userInsertDto.getRoles()){
            user.getRoles().add(roleRepository.getReferenceById(roleDto.getId()));
        }
        repository.save(user);
        return convertEntityToDto(user);
    }

    public Optional<UserDto> findById(Long id) {
        Optional<User> user = repository.findById(id);
        UserDto userDto = mapper.map(user.orElseThrow(() -> new ResourceNotFoundException("Id ["+id+"] não localizado.")), UserDto.class);
        return Optional.of(userDto);
    }

    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return users.map(this::convertEntityToDto);
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);
        userDto.getRoles().clear();
        for(Role role : user.getRoles()){
            userDto.getRoles().add(convertEntityToDto(role));
        }
        return userDto;
    }

    private User convertDtoToEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        user.getRoles().clear();
        return user;
    }

    private RoleDto convertEntityToDto(Role role){
        RoleDto roleSimpleDto = mapper.map(role, RoleDto.class);
        return roleSimpleDto;
    }

    private void verifyExistsId(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        }
    }

}
