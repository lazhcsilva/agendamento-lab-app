package com.agendamento.lab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="tab_funcionario")
@Getter @Setter
public class Funcionario {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idProfessor;

	@Id
	private Long matricula;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	
	private String senha;
	@NotBlank
	private String cadeira;
	
}
