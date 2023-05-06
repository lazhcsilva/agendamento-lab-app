package com.agendamento.lab.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="tab_agendamento")
@Getter @Setter
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgendamento;
	@NotBlank
	private Date data_agendamento;
	@NotBlank
	private String turno;
	@NotBlank
	private String disciplina;
	
}
