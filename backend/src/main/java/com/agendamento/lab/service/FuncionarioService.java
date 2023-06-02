package com.agendamento.lab.service;

import com.agendamento.lab.dao.FuncionarioDAO;
import com.agendamento.lab.model.Funcionario;
import com.agendamento.lab.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    public ResponseEntity<?> updateFuncionario(Funcionario funcionario, String action){
        return new ResponseEntity<Funcionario>(funcionarioDAO.save(funcionario), HttpStatus.CREATED);
    }

    public Response deletefunc(Long matricula){
        funcionarioDAO.deleteById(matricula);
        int status = 200;
        String message = "Funcionario deletado com sucesso.";
        return new Response(status, message);
    }
}
