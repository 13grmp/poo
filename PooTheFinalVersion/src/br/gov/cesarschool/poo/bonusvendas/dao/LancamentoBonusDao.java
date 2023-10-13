package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;


public class LancamentoBonusDao {
	private static final String BRANCO = "";
	private CadastroObjetos caixaBonus = new CadastroObjetos(LancamentoBonus.class); 
	
	public LancamentoBonusDao(){
		
	}
	
	
	public boolean incluir(LancamentoBonus numeroCaixa) {
		
		
		LancamentoBonus caixabusc = buscar(numeroCaixa.getNumeroCaixaDeBonus());
		System.out.println(buscar(numeroCaixa.getNumeroCaixaDeBonus()));
		if (caixabusc != null) { 
			return false;
		} else {
			caixaBonus.incluir(numeroCaixa, BRANCO + numeroCaixa.getNumeroCaixaDeBonus());
			return true;
		}		 
	}
	public boolean alterar(LancamentoBonus numeroCaixa) {
		
		LancamentoBonus caixabusc = buscar(numeroCaixa.getNumeroCaixaDeBonus());
		if (caixabusc == null) {
			return false;
		} else {
			caixaBonus.alterar(numeroCaixa, BRANCO + numeroCaixa.getNumeroCaixaDeBonus());
			return true;
		}		
	}
	public LancamentoBonus buscar(int numero) {
		return (LancamentoBonus)caixaBonus.buscar(BRANCO + numero);
	}
	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = caixaBonus.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] cxBonus = new LancamentoBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			cxBonus[i] = (LancamentoBonus)rets[i];
		}
		return cxBonus;
	} 
}
