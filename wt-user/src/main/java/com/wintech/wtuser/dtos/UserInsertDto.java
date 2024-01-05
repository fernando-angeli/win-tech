package com.wintech.wtuser.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserInsertDto extends UserDto{

    private String password;
    private List<RoleDto> roles;

}
