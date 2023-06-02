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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	
	private String senha;
	@NotBlank
	private String cadeira;

	public Funcionario() {
		
	}

	public Funcionario(Long matricula) {
		this.matricula = matricula;
	}

	public Funcionario(Long matricula, String nome, String email, String senha, String cadeira) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cadeira = cadeira;
	}
	
}
