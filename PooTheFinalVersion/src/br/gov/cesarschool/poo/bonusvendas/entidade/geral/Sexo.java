package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	 	FEMININO(1, "F"),
	    MASCULINO(2, "M");

	    private int codigo;
	    private String descricao;

	    Sexo(int codigo, String descricao) {
	        this.codigo = codigo;
	        this.descricao = descricao;
	    }

	}
		