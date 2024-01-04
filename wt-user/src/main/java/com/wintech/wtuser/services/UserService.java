package com.wintech.wtuser.services;

import com.wintech.wtuser.domains.User;
import com.wintech.wtuser.dtos.UserDto;
import com.wintech.wtuser.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    public UserDto insert(UserDto userDto){
        User user = convertDtoToEntity(userDto);
        repository.save(user);
        return convertEntityToDto(user);
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }

    private User convertDtoToEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        return user;
    }

}
