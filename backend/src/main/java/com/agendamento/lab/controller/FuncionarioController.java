package com.agendamento.lab.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.lab.model.Funcionario;
import com.agendamento.lab.Response.Response;
import com.agendamento.lab.dao.FuncionarioDAO;
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
	private FuncionarioDAO funcionarioDAO;

    @PostMapping("/cad_func")
    public Response cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){
        
       String matricula_banco = funcionarioDAO.findmatricula(funcionario.getMatricula());
       System.out.println("matricula banco: "+ matricula_banco );
        if( matricula_banco == null ){
            this.funcionarioDAO.save(funcionario);
            int status = 200;
            String message = "Funcionario cadastrado com sucesso.";
            return new Response(status, message);
        }else{
            int status = 409;
            String message = "Funcionario já está cadastrado.";
            return new Response(status, message);
        }
    }
}
