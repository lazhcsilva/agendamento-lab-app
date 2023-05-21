package com.agendamento.lab.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseFuncionario {
    private int status;
    private String message;
   
    public ResponseFuncionario(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
