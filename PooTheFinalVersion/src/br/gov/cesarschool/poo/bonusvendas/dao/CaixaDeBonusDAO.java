package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class CaixaDeBonusDAO {
	
	private static final String BRANCO = "";
	private CadastroObjetos caixinha = new CadastroObjetos(CaixaDeBonus.class); 
	
	public boolean incluir(CaixaDeBonus numero) {
		CaixaDeBonus caixinhaBusca = buscar(numero.getNumero());
		if (caixinhaBusca != null) { 
			return false;
		} else {
			caixinha.incluir(numero, BRANCO + numero.getNumero());
			return true;
		}		 
	}
	public boolean alterar(CaixaDeBonus numero) {
		CaixaDeBonus caixinhaBusca = buscar(numero.getNumero());
		if (caixinhaBusca == null) {
			return false;
		} else {
			caixinha.alterar(numero, BRANCO + numero.getNumero());
			return true;
		}		
	}
	public CaixaDeBonus buscar(long numero) {
		return (CaixaDeBonus)caixinha.buscar(BRANCO + numero);
	}
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = caixinha.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] caixa = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			caixa[i] = (CaixaDeBonus)rets[i];
		}
		return caixa;
	} 

}
