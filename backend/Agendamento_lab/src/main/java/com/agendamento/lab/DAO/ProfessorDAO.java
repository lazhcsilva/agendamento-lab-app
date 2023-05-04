package com.agendamento.lab.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendamento.lab.Models.Professor;

public interface ProfessorDAO extends JpaRepository<Professor, Integer>{
    
    @Query("select cp from cad_professor cp where cp.email = :email")
    public Professor findProfessorByEmail(String email);

}
