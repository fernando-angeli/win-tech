package com.wintech.wtuser.services;

import com.wintech.wtuser.domains.Role;
import com.wintech.wtuser.domains.User;
import com.wintech.wtuser.dtos.RoleDto;
import com.wintech.wtuser.dtos.UserDto;
import com.wintech.wtuser.dtos.UserInsertDto;
import com.wintech.wtuser.dtos.UserUpdateDto;
import com.wintech.wtuser.repositories.RoleRepository;
import com.wintech.wtuser.repositories.UserRepository;
import com.wintech.wtuser.services.exceptions.DatabaseException;
import com.wintech.wtuser.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserDto insert(UserInsertDto userInsertDto){
        User user = convertUserInsertDtoToUser(userInsertDto);
        user.setPassword(passwordEncoder.encode(userInsertDto.getPassword()));
        setRolesToUser(user, userInsertDto);
        repository.save(user);
        return convertUserToUserDto(user);
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = repository.findById(id);
        UserDto userDto = mapper.map(user.orElseThrow(() -> new ResourceNotFoundException("Id ["+id+"] não localizado.")), UserDto.class);
        return Optional.of(userDto);
    }

    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return users.map(this::convertUserToUserDto);
    }

    @Transactional
    public UserDto update(Long id, UserUpdateDto userDto) {
        verifyExistsId(id);
        User user = repository.getReferenceById(id);
        convertUserDtoToUser(userDto, user);
        user = repository.save(user);
        return convertUserToUserDto(user);
    }

    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não foi possível excluir este registro por violação de integridade do Banco de Dados.");
        }
    }

    private User convertUserInsertDtoToUser(UserInsertDto userInsertDto){
        User user = new User();
        user = mapper.map(userInsertDto, User.class);
        user.getRoles().clear();
        setRolesToUser(user, userInsertDto);
        return user;
    }

    private void convertUserDtoToUser(UserDto userDto, User user){
        mapper.map(user, userDto);
        user.getRoles().clear();
        setRolesToUser(user, userDto);
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);
        userDto.getRoles().clear();
        setRolesToUserDto(userDto, user);
        return userDto;
    }

    private RoleDto convertRoleToRoleDto(Role role){
        return mapper.map(role, RoleDto.class);
    }

    private void setRolesToUser(User user, UserDto userDto){
        user.getRoles().clear();
        for(RoleDto roleDto : userDto.getRoles()){
            Role role = roleRepository.getReferenceById(roleDto.getId());
            user.getRoles().add(role);
        }
    }

    private void setRolesToUserDto(UserDto userDto, User user) {
        userDto.getRoles().clear();
        for(Role r : user.getRoles()){
            Role role = roleRepository.getReferenceById(r.getId());
            userDto.getRoles().add(convertRoleToRoleDto(role));
        }
    }

    private void verifyExistsId(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        }
    }

}
