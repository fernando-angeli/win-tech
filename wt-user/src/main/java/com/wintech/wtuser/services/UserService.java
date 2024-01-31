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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.wintech.wtuser.mapper.EntityMapper.convertToDto;
import static com.wintech.wtuser.mapper.EntityMapper.convertToEntity;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public UserDto insert(UserInsertDto userInsertDto){
        User user = convertToEntity(userInsertDto, User.class);
        setRolesToUser(userInsertDto, user);
        user.setPassword(passwordEncoder.encode(userInsertDto.getPassword()));
        repository.save(user);
        return convertToDto(user, UserDto.class);
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = repository.findById(id);
        UserDto userDto = convertToDto(user.orElseThrow(() -> new ResourceNotFoundException("Id ["+id+"] não localizado.")), UserDto.class);
        return Optional.of(userDto);
    }
    @Transactional(readOnly = true)
    public Optional<UserDto> findByUsername(String username) {
        Optional<User> user = repository.findByEmailOrLogin(username, username);
        UserDto userDto = convertToDto(user.orElseThrow(() -> new ResourceNotFoundException("User " + username + " não localizado.")), UserDto.class);
        return Optional.of(userDto);
    }

    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return users.map(user -> convertToDto(user, UserDto.class));
    }

    @Transactional
    public UserDto update(Long id, UserUpdateDto dto) {
        verifyExistsId(id);
        User user = repository.getReferenceById(id);
        convertToEntity(dto, user);
        setRolesToUser(dto, user);
        user = repository.save(user);
        return convertToDto(user, UserDto.class);
    }

    @Transactional
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não foi possível excluir este registro por violação de integridade do Banco de Dados.");
        }
    }

    private void setRolesToUser(UserDto dto, User user){
        user.getRoles().clear();
        for(RoleDto roleDto : dto.getRoles()){
            Role role = roleRepository.getReferenceById(roleDto.getId());
            user.getRoles().add(role);
        }
    }

    private void verifyExistsId(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Id [" + id + "] não localizado.");
        }
    }

}
