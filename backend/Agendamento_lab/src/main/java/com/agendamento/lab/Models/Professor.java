package com.agendamento.lab.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue
	private Integer matricula;
	private String nome;
	private String cadeira;

	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCadeira() {
		return cadeira;
	}
	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}
	
	
}
