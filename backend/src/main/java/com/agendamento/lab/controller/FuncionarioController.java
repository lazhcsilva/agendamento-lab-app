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

    @PostMapping("/cadfunc")
    public Response cadastarFuncionario(@Valid @RequestBody Funcionario funcionario){  

        //variavel que pegar de uma query para fazer a validação de funcionario existente      
        String email_banco = funcionarioDAO.findemail(funcionario.getEmail());
        System.out.println("Email cadastro no banco: " + email_banco );
        
        //verificação para funcionario existente
        if(email_banco == null){
            // chamada do save para salvar no banco
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

    @GetMapping("/exibirfuncionario")
    public ResponseFuncionarioGet exibirnomefuncionario(@Valid @RequestBody Funcionario funcionario){
        //variavel que pega de uma query e exibir o nome do funcionario
        String nome = funcionarioDAO.findnameandchair(funcionario.getNome(),funcionario.getCadeira());
        System.out.println("nome lista query  " + nome);
        
        return new ResponseFuncionarioGet(nome);
    }
    // metodo que editar o cadastro do funcionario
    @PatchMapping("/edit_func")
    public ResponseEntity<?> editarFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioService.updateFuncionario(funcionario, "update");
    }

    @DeleteMapping("/delet_func/{matricula}")
    public Response deleteFuncionario(@PathVariable Long matricula, Funcionario funcionario){
        //variavel que pegar de uma query para fazer a validação de funcionario existente para deletar 
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
                //chamada de metodo para deletar agendamentos massivo antes do delete do funcionario
                agendamentoDAO.deleteById(id);
                System.out.println("Deleção de ID de agendamento: " + id);
            }
            //chamada de metodo para deletar funcionario
            funcionarioService.deletefunc(matricula);
            int status = 200;
            String message = "Funcionario deletado com sucesso";
            return new Response(status, message);
        }
    }
}
