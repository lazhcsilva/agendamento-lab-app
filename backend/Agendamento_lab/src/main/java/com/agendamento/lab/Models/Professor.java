package com.agendamento.lab.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cad_professor")
public class Professor {
	
	@Id
	@GeneratedValue
	private Integer matricula;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	@NotBlank
	private String confirma_senha;
	@NotBlank
	private String cadeira;

	@OneToMany
  	private List<Agendamento> list_agendamento;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfime_senha() {
		return confirma_senha;
	}
	public void setConfime_senha(String confirma_senha) {
		this.confirma_senha = confirma_senha;
	}
	public String getCadeira() {
		return cadeira;
	}
	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}
	public List<Agendamento> getList_agendamento() {
		return list_agendamento;
	}
	public void setList_agendamento(List<Agendamento> list_agendamento) {
		this.list_agendamento = list_agendamento;
	}
	
	
}
