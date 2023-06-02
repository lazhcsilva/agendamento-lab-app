package com.agendamento.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.lab.dao.AgendamentoDAO;
import com.agendamento.lab.response.Response;

@Service
public class AgendamentoService {

    @Autowired
	private AgendamentoDAO agendamentoDAO;

    public Response deleteagend(Long idAgendamento){
        agendamentoDAO.deleteById(idAgendamento);
        int status = 200;
        String message = "Agendamento deletado com sucesso.";
        return new Response(status, message);
    }
    public String deleteagendfunc(Long idAgendamento){
        agendamentoDAO.deleteById(idAgendamento);
        return "Agendamento Deletado";
    }
}
