package com.agendamento.lab.dao;


import com.agendamento.lab.model.Agendamento;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgendamentoDAO extends JpaRepository<Agendamento, Long> {

//    @Query("select ca from cad_agendamento ca where ca.data_agendamento = :data_agendamento and ca.turno = :turno")
//    public Agendamento findScheduleDate(Date data_agendamento, String turno);
    @Query("select fc.turno from Agendamento fc where fc.turno =:turno")
    public String findturnoagendamento(String turno);

    @Query("select fc.data_agendamento from Agendamento fc where fc.data_agendamento =:data_agendamento")
    public LocalDate findDataAgendamento(LocalDate data_agendamento);
}
