package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;


import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;


public class VendedorDAO {
	private static final String BRANCO = "";
	private CadastroObjetos vendedorCad = new CadastroObjetos(Vendedor.class); 
	
	public boolean incluir(Vendedor cpf) {
		Vendedor vendedorBusc = buscar(cpf.getCpf());
		if (vendedorBusc != null) { 
			return false;
		} else {
			vendedorCad.incluir(cpf, BRANCO + cpf.getCpf());
			return true;
		}		 
	}
	public boolean alterar(Vendedor cpf) {
		Vendedor vendedorBusc = buscar(cpf.getCpf());
		if (vendedorBusc == null) {
			return false;
		} else {
			vendedorCad.alterar(cpf, BRANCO + cpf.getCpf());
			return true;
		}		
	}
	public Vendedor buscar(String cpf) {
		return (Vendedor)vendedorCad.buscar(BRANCO + cpf);
	}
	public Vendedor[] buscarTodos() {
		Serializable[] rets = vendedorCad.buscarTodos(Vendedor.class);
		Vendedor[] cds = new Vendedor[rets.length];
		for(int i=0; i<rets.length; i++) {
			cds[i] = (Vendedor)rets[i];
		}
		return cds;
	} 
}
