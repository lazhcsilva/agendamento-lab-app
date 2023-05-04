package com.agendamento.lab.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="cad_agendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private Date data_agendamento;
	@NotBlank
	private String turno;
	@NotBlank
	private String disciplina;
	
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
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}
