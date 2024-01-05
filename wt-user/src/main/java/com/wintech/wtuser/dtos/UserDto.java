package com.wintech.wtuser.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private List<RoleDto> roles;

}
