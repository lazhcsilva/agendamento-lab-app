package com.agendamento.lab.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.lab.dao.AgendamentoDAO;
import com.agendamento.lab.model.Agendamento;
import com.agendamento.lab.model.Funcionario;
import com.agendamento.lab.response.Response;
import com.agendamento.lab.response.ResponseAgendamentoGet;

@RestController
@RequestMapping("/api/v1")
public class AgendamentoController {

    @Autowired
	private AgendamentoDAO agendamentoDAO;

    @PostMapping("/cad_agend")
    public Response cadastaragendamento(@Valid @RequestBody Agendamento agendamento){
        
        String turno_agendamento_banco = agendamentoDAO.findturnoagendamento(agendamento.getTurno());
        System.out.println("Turno agendamento banco: " + turno_agendamento_banco );

        LocalDate data_agendamento_banco = agendamentoDAO.findDataAgendamento(agendamento.getData_agendamento());
        System.out.println("Data agendamento banco: " + data_agendamento_banco );
        Integer n1 = 1;
        System.out.println("findDataAgendamentoFunc: " + agendamentoDAO.findDataAgendamentoFunc(n1));
        System.out.println("findDataAgendamentoFunc: " + agendamentoDAO.findTurnoAgendamentoFunc(n1));


        if(turno_agendamento_banco == null && data_agendamento_banco == null){
            this.agendamentoDAO.save(agendamento);
            int status = 200;
            String message = "Agendamento cadastrado com sucesso.";
            return new Response(status, message);
        }else{
            int status = 409;
            String message = "Agendamento já cadastrado.";
            return new Response(status, message);
        }
    }


    @PostMapping("/exibir_agendamento")
    public ResponseAgendamentoGet exibirnomefuncionario(@Valid @RequestBody Agendamento agendamento){
        Funcionario funcionario = agendamento.getFuncionario();
        Integer convertInteger = new Integer(funcionario.getMatricula());
        
        LocalDate data_agendamento = agendamentoDAO.findDataAgendamentoFunc(convertInteger);
        System.out.println("data_agendamento  " + data_agendamento);
        String turno = agendamentoDAO.findTurnoAgendamentoFunc(convertInteger);
        System.out.println("turno  " + turno);
        
        return new ResponseAgendamentoGet(turno,data_agendamento);
    }
}
