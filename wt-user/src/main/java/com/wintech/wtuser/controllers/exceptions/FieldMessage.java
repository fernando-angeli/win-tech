package com.wintech.wtuser.controllers.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage {

    private String fieldName;
    private String message;

}
