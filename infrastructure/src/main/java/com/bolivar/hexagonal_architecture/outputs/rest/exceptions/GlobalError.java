package com.bolivar.hexagonal_architecture.outputs.rest.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GlobalError {

    private Integer status;
    private String message;

}
