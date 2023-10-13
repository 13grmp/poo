package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDao;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class AcumuloResgateMediator {
	
	private static AcumuloResgateMediator instance;
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDao repositorioLancamento;
	
	private AcumuloResgateMediator() {
		  repositorioCaixaDeBonus = new CaixaDeBonusDAO();
	      repositorioLancamento = new LancamentoBonusDao();
	}
	
	public static AcumuloResgateMediator getInstance() { if (instance == null) {
		instance = new AcumuloResgateMediator(); } return instance; 
	} 

    public long gerarCaixaDeBonus(Vendedor vendedor) {

        if (repositorioCaixaDeBonus == null) {
            return 0;
        }


        LocalDateTime dataAtual = LocalDateTime.now();
        
        DateTimeFormatter formatoAno = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd");
        
        String ano = dataAtual.format(formatoAno);
        String mes = dataAtual.format(formatoMes);
        String dia = dataAtual.format(formatoDia);

        
        String numeroCaixa = vendedor.getCpf() + ano + mes + dia;

       
        CaixaDeBonus caixaDeBonus = new CaixaDeBonus(Long.parseLong(numeroCaixa));

        if (caixaDeBonus != null) {
            return Long.parseLong(numeroCaixa);
        } else {
            return 0;
        }
    }
    
    public String acumularBonus(long numeroCaixaDeBonus, double valor) {


        return null;
    }
}
