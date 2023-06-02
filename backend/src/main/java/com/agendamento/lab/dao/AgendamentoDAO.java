package com.agendamento.lab.dao;


import com.agendamento.lab.model.Agendamento;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgendamentoDAO extends JpaRepository<Agendamento, Long> {

//    @Query("select ca from cad_agendamento ca where ca.data_agendamento = :data_agendamento and ca.turno = :turno")
//    public Agendamento findScheduleDate(Date data_agendamento, String turno);
    @Query("select fc.turno from Agendamento fc where fc.turno =:turno and fc.data_agendamento =:data_agendamento")
    public String findturnoagendamento(String turno, LocalDate data_agendamento);

    @Query("select fc.data_agendamento from Agendamento fc where fc.turno =:turno and fc.data_agendamento =:data_agendamento")
    public LocalDate findDataAgendamento(String turno, LocalDate data_agendamento);
    
    @Query("select fc.data_agendamento from Agendamento fc where fc.funcionario in (select fx.matricula from Funcionario fx where fx.matricula =:matricula)")
    public List<LocalDate> findDataAgendamentoFunc(Long matricula);

    @Query("select fc.turno from Agendamento fc where fc.funcionario in (select fx.matricula from Funcionario fx where fx.matricula =:matricula)")
    public List<String> findTurnoAgendamentoFunc(Long matricula);

    @Query("select fc.idAgendamento from Agendamento fc where fc.idAgendamento =:idagendamento")
    public Long findAgendamento(Long idagendamento);
}
