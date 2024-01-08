package com.wintech.wtuser.dtos;

import lombok.*;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String login;
    private String email;
    private List<RoleDto> roles;

}
