package com.agendamento.lab.dao;


import com.agendamento.lab.model.Funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Long> {

//    @Query("select cp from cad_professor cp where cp.email = :email")
//    public Professor findProfessorByEmail(String email);
//
//    @Query("select cps from cad_professor cps where cps.senha = :senha")
//    public Professor findProfessorBysenha(String senha);

    @Query("select fc.matricula from Funcionario fc where fc.matricula =:matricula")
    public Long findMatricula(Long matricula);

    @Query("select fc.nome from Funcionario fc where fc.nome =:nome and fc.cadeira =:cadeira")
    public String findnameandchair(String nome, String cadeira);

    @Query("select fc.email from Funcionario fc where fc.email =:email")
    public String findemail(String email);

    @Query("select fc.idAgendamento from Agendamento fc where fc.funcionario in (select fx.matricula from Funcionario fx where fx.matricula =:matricula)")
    public List<Long> findDeletarFuncAgend(Long matricula);
}