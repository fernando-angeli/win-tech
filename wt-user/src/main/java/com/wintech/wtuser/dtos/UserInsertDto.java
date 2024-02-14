package com.wintech.wtuser.dtos;

import com.wintech.wtuser.services.validation.UserInsertValid;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@UserInsertValid
@Data
public class
UserInsertDto extends UserDto{

    private String password;

}
