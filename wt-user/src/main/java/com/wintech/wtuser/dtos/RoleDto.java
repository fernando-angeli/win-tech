package com.wintech.wtuser.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class RoleDto {

    private Long id;
    private String roleName;

}
