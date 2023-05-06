package com.agendamento.lab.dao;


import com.agendamento.lab.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoDAO extends JpaRepository<Agendamento, Long> {

//    @Query("select ca from cad_agendamento ca where ca.data_agendamento = :data_agendamento and ca.turno = :turno")
//    public Agendamento findScheduleDate(Date data_agendamento, String turno);

}
