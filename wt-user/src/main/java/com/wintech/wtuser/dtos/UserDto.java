package com.wintech.wtuser.dtos;

import com.wintech.wtuser.controllers.UserController;
import lombok.*;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;

}
