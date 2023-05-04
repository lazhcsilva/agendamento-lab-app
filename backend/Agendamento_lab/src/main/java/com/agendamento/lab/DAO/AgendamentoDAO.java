package com.agendamento.lab.DAO;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendamento.lab.Models.Agendamento;

public interface AgendamentoDAO extends JpaRepository<Agendamento, Integer>{

    @Query("select ca from cad_agendamento ca where ca.data_agendamento = :data_agendamento and ca.turno = :turno")
    public Agendamento findScheduleDate(Date data_agendamento, String turno);
    
}
