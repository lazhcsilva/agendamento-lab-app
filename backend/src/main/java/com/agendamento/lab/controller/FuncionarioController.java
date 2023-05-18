package com.agendamento.lab.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.lab.model.Funcionario;

import com.agendamento.lab.dao.FuncionarioDAO;
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

     @Autowired
	private FuncionarioDAO funcionarioDAO;

    @PostMapping("/cad_func")
    public Funcionario cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){
       String matricula_banco = funcionarioDAO.findmatricula(funcionario.getMatricula());
       System.out.println("matricula banco: "+ matricula_banco );
        if( matricula_banco == null ){
            return this.funcionarioDAO.save(funcionario);
        }else{
            System.out.println("Funcionario ja existente");
            return null;
        }
    }
}
