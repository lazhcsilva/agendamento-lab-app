package com.agendamento.lab.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.lab.dao.AgendamentoDAO;
import com.agendamento.lab.model.Agendamento;
import com.agendamento.lab.model.Funcionario;
import com.agendamento.lab.response.Response;
import com.agendamento.lab.response.ResponseAgendamentoGet;
import com.agendamento.lab.service.AgendamentoService;

@RestController
@RequestMapping("/api/v1")
public class AgendamentoController {

    @Autowired
	private AgendamentoDAO agendamentoDAO;

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/cad_agend")
    public Response cadastaragendamento(@Valid @RequestBody Agendamento agendamento){

        // variavel que pega a query para fazer a validação de turno de agendamento
        String turno_agendamento_banco = agendamentoDAO.findturnoagendamento(agendamento.getTurno(),agendamento.getData_agendamento());
        System.out.println("Turno agendamento banco: " + turno_agendamento_banco );

        // variavel que pega a query para fazer a validação de data de agendamento
        LocalDate data_agendamento_banco = agendamentoDAO.findDataAgendamento(agendamento.getTurno(),agendamento.getData_agendamento());
        System.out.println("Data agendamento banco: " + data_agendamento_banco );


        if((turno_agendamento_banco == null && data_agendamento_banco == null) || (turno_agendamento_banco == null && data_agendamento_banco == agendamento.getData_agendamento()) || (turno_agendamento_banco == agendamento.getTurno() && data_agendamento_banco == agendamento.getData_agendamento()) || (turno_agendamento_banco == agendamento.getTurno() && data_agendamento_banco == null)){
            // chamada de metodo de salvar o agendamento
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
    public List<ResponseAgendamentoGet> exibirnomefuncionario(@Valid @RequestBody Agendamento agendamento){
        // converte de objeto para Long
        Funcionario funcionario = agendamento.getFuncionario();
        Long convertInteger = funcionario.getMatricula();

        List<LocalDate> datasAgendamento = agendamentoDAO.findDataAgendamentoFunc(convertInteger);
        System.out.println("datasAgendamento: " + datasAgendamento);

        List<String> turnos = agendamentoDAO.findTurnoAgendamentoFunc(convertInteger);
        System.out.println("turnos: " + turnos);

        List<ResponseAgendamentoGet> responseList = new ArrayList<>();
        for (int i = 0; i < datasAgendamento.size(); i++) {
            ResponseAgendamentoGet response = new ResponseAgendamentoGet(turnos.get(i), datasAgendamento.get(i));
            responseList.add(response);
        }
        return responseList;
    }

    @DeleteMapping("/delet_agend/{idAgendamento}")
    public Response deleteFuncionario(@PathVariable Long idAgendamento, Agendamento agendamento){
        // variavel que pega a query para fazer a validação do id do agendamento
        Long id_agendamento_banco = agendamentoDAO.findAgendamento(agendamento.getIdAgendamento());
        System.out.println("Matricula delete no banco: " + id_agendamento_banco);
        if(id_agendamento_banco == null){
            int status = 409;
            String message = "Agendamento não encontrado";
            return new Response(status, message);
        }else{
            // chamanda do metodo de deletar agedamento
            agendamentoService.deleteagend(idAgendamento);
            int status = 200;
            String message = "Agendamento deletado com sucesso";
            return new Response(status, message);
        }
    }
}
