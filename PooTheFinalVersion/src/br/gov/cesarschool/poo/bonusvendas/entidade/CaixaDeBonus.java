package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;



public class CaixaDeBonus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao;
	
	
	public CaixaDeBonus(long numero){
		this.numero = numero;
	}
	
	public long getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	private void setSaldo(double valor) {
		this.saldo = valor;
	}

	public LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void creditar(double valor) {
		 setSaldo(getSaldo() + valor);
		this.dataHoraAtualizacao = LocalDateTime.now();	
	}
	
	public void debitar (double valor) {
		this.saldo -= valor;
		this.dataHoraAtualizacao = LocalDateTime.now();
	}
	
	
}
