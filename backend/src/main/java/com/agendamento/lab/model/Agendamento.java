package com.agendamento.lab.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tab_agendamento")
@Getter @Setter
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgendamento;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate data_agendamento;
	@NotBlank
	private String turno;
	@NotBlank
	private String disciplina;
	@ManyToOne
	private Funcionario funcionario;
	
}
