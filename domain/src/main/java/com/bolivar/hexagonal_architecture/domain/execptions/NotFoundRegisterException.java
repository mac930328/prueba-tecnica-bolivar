package com.bolivar.hexagonal_architecture.domain.execptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundRegisterException extends RuntimeException {

    private Integer status;

    public NotFoundRegisterException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public NotFoundRegisterException(String message) {
        super(message);
    }

}
