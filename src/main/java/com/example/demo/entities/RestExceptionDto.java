package com.example.demo.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestExceptionDto {
    private String message;
    private Throwable cause;
    private String localizedMessage;

    public RestExceptionDto(RuntimeException ex){
        this.message = ex.getMessage();
        this.cause = ex.getCause();
        this.localizedMessage = ex.getLocalizedMessage();
    }

}

