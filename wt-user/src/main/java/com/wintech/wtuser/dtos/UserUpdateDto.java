package com.wintech.wtuser.dtos;

import com.wintech.wtuser.services.validation.UserUpdateValid;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@UserUpdateValid
@Data
public class UserUpdateDto extends UserDto {

}
