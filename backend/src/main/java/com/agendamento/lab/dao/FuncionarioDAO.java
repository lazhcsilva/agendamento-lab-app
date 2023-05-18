package com.agendamento.lab.dao;


import com.agendamento.lab.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Long> {

//    @Query("select cp from cad_professor cp where cp.email = :email")
//    public Professor findProfessorByEmail(String email);
//
//    @Query("select cps from cad_professor cps where cps.senha = :senha")
//    public Professor findProfessorBysenha(String senha);

    @Query("select fc.matricula from Funcionario fc where fc.matricula =:matricula")
    public String findmatricula(String matricula);

}