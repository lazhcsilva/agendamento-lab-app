package com.agendamento.lab.response;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter @Setter
public class ResponseFuncionario {
    private int status;
    private String message;

    public ResponseFuncionario() {
        
    }
   
    public ResponseFuncionario(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
