package com.agendamento.lab.response;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter @Setter
public class Response {
    private int status;
    private String message;

    public Response() {
        
    }
   
    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
