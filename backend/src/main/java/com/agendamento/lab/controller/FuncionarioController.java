package com.agendamento.lab.controller;

import javax.validation.Valid;

import com.agendamento.lab.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agendamento.lab.model.Funcionario;

import com.agendamento.lab.response.ResponseFuncionario;
import com.agendamento.lab.response.ResponseFuncionarioGet;
import com.agendamento.lab.dao.FuncionarioDAO;
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
	private FuncionarioDAO funcionarioDAO;

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cad_func")
    public ResponseFuncionario cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){
        
       Integer matricula_banco = funcionarioDAO.findMatricula(funcionario.getMatricula());
       System.out.println("matricula banco: " + matricula_banco );
        if( matricula_banco == null ){
            this.funcionarioDAO.save(funcionario);
            int status = 200;
            String message = "Funcionario cadastrado com sucesso.";
            return new ResponseFuncionario(status, message);
        } else {
            int status = 409;
            String message = "Funcionario já está cadastrado.";
            return new ResponseFuncionario(status, message);
        }
    }

    @GetMapping("/exibir_funcionario")
    public ResponseFuncionarioGet exibirnomefuncionario(@Valid @RequestBody Funcionario funcionario){
        String nome = funcionarioDAO.findnameandchair(funcionario.getNome(),funcionario.getCadeira());
        System.out.println("nome lista query  " + nome);
        
        return new ResponseFuncionarioGet(nome);
    }

    @PatchMapping("/edit_func")
    public ResponseEntity<?> editarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.updateFuncionario(funcionario, "update");
    }
}
