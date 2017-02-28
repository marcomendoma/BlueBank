package com.operations.bluebank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity(name="conta")
public class Conta {
	
	//-- Postgress/Oracle
	//--@Id
	//--@SequenceGenerator(name = "contas_id", sequenceName = "contas_seq", allocationSize = 1)
	//--@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "convidados_id")

	//-- H2 / Sql Server/ MySql
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	@Size(max=14, message="CPF do cliente: informe no máximo 14 caracteres.")
	@NotNull(message="CPF do cliente: campo obrigatório.")
	@NotEmpty(message="CPF do cliente: campo obrigatório.")
	@Column(name="cpf", nullable = false, length=14)
	private String Cpf;
	
	@NotNull(message="Agência: campo obrigatório.")
	@NotEmpty(message="Agência: campo obrigatório.")
	@Column(name="agencia")
	private long Agencia;
	
	@NotNull(message="Conta: campo obrigatório.")
	@NotEmpty(message="Conta: campo obrigatório.")
	@Column(name="conta")
	private long Conta;
	
	@NumberFormat(pattern="#,##0.00")
	@Column(name="saldo")
	private BigDecimal Saldo;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public long getAgencia() {
		return Agencia;
	}

	public void setAgencia(long agencia) {
		Agencia = agencia;
	}

	public long getConta() {
		return Conta;
	}

	public void setConta(long conta) {
		Conta = conta;
	}

	public BigDecimal getSaldo() {
		return Saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		Saldo = saldo;
	}
}
