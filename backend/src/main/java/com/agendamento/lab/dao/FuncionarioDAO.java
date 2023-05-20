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

    @Query("select fc.nome from Funcionario fc where fc.nome =:nome and fc.cadeira =:cadeira")
    public String findnameandchair(String nome, String cadeira);

    @Query("select fc.nome from Funcionario fc WHERE fc.matricula =:matricula")
    public String atualizarnomedocadastrofuncionario(String matricula);

    @Query("select fc.email from Funcionario fc WHERE fc.matricula =:matricula")
    public String atualizaremaildocadastrofuncionario(String matricula);
    
    @Query("select  fc.cadeira from Funcionario fc WHERE fc.matricula =:matricula")
    public String atualizarcadeiradocadastrofuncionario(String matricula);

    @Query("update Funcionario fc SET fc.nome =:nome, fc.cadeira =:cadeira, fc.email =:email WHERE fc.matricula =:matricula")
    public String atualizarcadastrofuncionario(String matricula,String nome, String email, String cadeira);

}
