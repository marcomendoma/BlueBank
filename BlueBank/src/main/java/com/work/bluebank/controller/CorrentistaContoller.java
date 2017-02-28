package com.work.bluebank.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity(name="correntista")
public class CorrentistaContoller {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@CPF
	private String Cpf;
	
	@NotBlank(message="Nome do correntista: campo obrigatório")
	@Column(name="nome")
	private String Nome;
	
	@Column(name="conta")
	private long Conta;
	
	@Column(name="agencia")
	private long Agencia;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public long getConta() {
		return Conta;
	}

	public void setConta(long conta) {
		Conta = conta;
	}

	public long getAgencia() {
		return Agencia;
	}

	public void setAgencia(long agencia) {
		Agencia = agencia;
	}
}
