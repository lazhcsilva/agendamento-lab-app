package com.agendamento.lab.Models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date data_agendamento;
	private Time horario_agendamento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_agendamento() {
		return data_agendamento;
	}
	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}
	public Time getHorario_agendamento() {
		return horario_agendamento;
	}
	public void setHorario_agendamento(Time horario_agendamento) {
		this.horario_agendamento = horario_agendamento;
	}
	
}
