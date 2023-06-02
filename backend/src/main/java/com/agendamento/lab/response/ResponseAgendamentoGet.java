package com.agendamento.lab.response;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ResponseAgendamentoGet{
    public String turno;
    public LocalDate data_agendamento;

    public ResponseAgendamentoGet() {
        
    }

    public ResponseAgendamentoGet(String turno, LocalDate data_agendamento) {
        this.turno = turno;
        this.data_agendamento = data_agendamento;
    }

    public class Reponse{
        int status;
        String message;

        public void Response(int status, String message){
            this.status = status;
            this.message = message;
        }
    }
}