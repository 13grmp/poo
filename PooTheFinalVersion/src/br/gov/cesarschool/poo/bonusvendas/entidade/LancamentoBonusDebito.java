package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus {
	
	private TipoResgate resgate;
	
	public LancamentoBonusDebito(int numeroCaixaDeBonus,double valor,  LocalDateTime dataHoraLancamento,TipoResgate resgate) {
		super(numeroCaixaDeBonus,valor,dataHoraLancamento );
		this.resgate = resgate;
	}

	public TipoResgate getResgate() {
		return resgate;
	}	

}
