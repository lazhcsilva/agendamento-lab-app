package com.agendamento.lab.response;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ResponseFuncionarioGet{
    public String nome;

    public ResponseFuncionarioGet() {
        
    }

    public ResponseFuncionarioGet(String nome) {
        this.nome = nome;
    }
}