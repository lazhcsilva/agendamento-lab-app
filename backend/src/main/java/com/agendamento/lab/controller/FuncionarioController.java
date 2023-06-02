package com.agendamento.lab.controller;

import java.util.List;

import javax.validation.Valid;

import com.agendamento.lab.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agendamento.lab.model.Funcionario;

import com.agendamento.lab.response.Response;
import com.agendamento.lab.response.ResponseFuncionarioGet;
import com.agendamento.lab.dao.AgendamentoDAO;
import com.agendamento.lab.dao.FuncionarioDAO;
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
	private FuncionarioDAO funcionarioDAO;

    @Autowired
    private FuncionarioService funcionarioService;
    
    @Autowired
    private AgendamentoDAO agendamentoDAO;

    @PostMapping("/cad_func")
    public Response cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){        
        String email_banco = funcionarioDAO.findemail(funcionario.getEmail());
        System.out.println("Email cadastro no banco: " + email_banco );
        

        if(email_banco == null){
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

    @GetMapping("/exibir_funcionario")
    public ResponseFuncionarioGet exibirnomefuncionario(@Valid @RequestBody Funcionario funcionario){
        String nome = funcionarioDAO.findnameandchair(funcionario.getNome(),funcionario.getCadeira());
        System.out.println("nome lista query  " + nome);
        
        return new ResponseFuncionarioGet(nome);
    }

    @PatchMapping("/edit_func")
    public ResponseEntity<?> editarFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioService.updateFuncionario(funcionario, "update");
    }
    @DeleteMapping("/delet_func/{matricula}")
    public Response deleteFuncionario(@PathVariable Long matricula, Funcionario funcionario){
        Long matricula_banco = funcionarioDAO.findMatricula(funcionario.getMatricula());
        System.out.println("ID de Matricula delete no banco: " + matricula_banco);
        if(matricula_banco == null){
            int status = 409;
            String message = "Funcionario não encontrado";
            return new Response(status, message);
        }else{
            List<Long> id_agendamentos_relacionados_func = funcionarioDAO.findDeletarFuncAgend(funcionario.getMatricula());
            for (int i = 0; i < id_agendamentos_relacionados_func.size(); i++) {
                Long id = id_agendamentos_relacionados_func.get(i);
                agendamentoDAO.deleteById(id);
                System.out.println("Deleção de ID de agendamento: " + id);
            }
            funcionarioService.deletefunc(matricula);
            int status = 200;
            String message = "Funcionario deletado com sucesso";
            return new Response(status, message);
        }
    }
}
