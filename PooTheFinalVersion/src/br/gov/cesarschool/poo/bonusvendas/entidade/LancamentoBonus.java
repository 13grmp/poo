package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LancamentoBonus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int numeroCaixaDeBonus;
	private double valor;
	private LocalDateTime dataHoraLancamento;
	
	public LancamentoBonus() {
		
	}
	public LancamentoBonus(int numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento ){
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}
	
	public int getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}	
	
}
