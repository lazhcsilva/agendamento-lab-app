package com.agendamento.lab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.lab.model.Funcionario;

import com.agendamento.lab.Response.ResponseFuncionario;
import com.agendamento.lab.Response.ResponseFuncionarioGet;
import com.agendamento.lab.dao.FuncionarioDAO;
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
	private FuncionarioDAO funcionarioDAO;

    @PostMapping("/cad_func")
    public ResponseFuncionario cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){
        
       String matricula_banco = funcionarioDAO.findmatricula(funcionario.getMatricula());
       System.out.println("matricula banco: "+ matricula_banco );
        if( matricula_banco == null ){
            this.funcionarioDAO.save(funcionario);
            int status = 200;
            String message = "Funcionario cadastrado com sucesso.";
            return new ResponseFuncionario(status, message);
        }else{
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

    @PostMapping("/edit_func")
    public ResponseFuncionario editarfuncionario(@Valid @RequestBody Funcionario funcionario){

        
        // //savando valor novo na variavel Request
        // String request_nome = funcionario.getNome();
        // String request_email = funcionario.getEmail();
        // String request_cadeira = funcionario.getCadeira();

        // //pegando valor antigo do banco
        // String query_separado_nome = funcionarioDAO.atualizarnomedocadastrofuncionario(funcionario.getMatricula());
        // System.out.println("query_separado_nome --> "+ query_separado_nome);
        // String query_separado_email = funcionarioDAO.atualizaremaildocadastrofuncionario(funcionario.getMatricula());
        // System.out.println("query_separado_email --> "+ query_separado_email);
        // String query_separado_cadeira = funcionarioDAO.atualizarcadeiradocadastrofuncionario(funcionario.getMatricula());
        // System.out.println("query_separado_cadeira --> "+ query_separado_cadeira);
        // System.out.println("matricula --> "+ funcionario.getMatricula());
        // query_separado_nome = request_nome;
        // query_separado_email = request_email;
        // query_separado_cadeira = request_cadeira;

        // //Setando o valor no novo objeto
        // Funcionario fc1 = new Funcionario();
        // fc1.setNome(query_separado_nome);
        // fc1.setEmail(query_separado_email);
        // fc1.setCadeira(query_separado_cadeira);

        // this.funcionarioDAO.save(fc1);

        String query = funcionarioDAO.atualizarcadastrofuncionario(funcionario.getMatricula(),funcionario.getNome(),funcionario.getEmail(),funcionario.getCadeira());

        
        int status = 200;
        String message = "Funcionario editado com sucesso.";
        return new ResponseFuncionario(status, message);
       
        // int status = 409;
        // String message = "Funcionario já está cadastrado.";
        // return new ResponseFuncionario(status, message);
    
    }
}
