

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDao;
import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;

public class Main {
	
	 
	public static void main(String [] args) {
		
//		//teste CaixaBonus
//		
//		CaixaDeBonus teste = new CaixaDeBonus(100);
//		teste.creditar(1000);
//		CaixaDeBonusDAO testinho = new CaixaDeBonusDAO();
//		testinho.incluir(teste);
//		CaixaDeBonus a = testinho.buscar(teste.getNumero());
//		
//		System.out.println(a.getSaldo() +" -> " + "a");
//		System.out.println(a.getNumero() +" -> " + "a");
//		System.out.println(a.getDataHoraAtualizacao() +" -> " + "a");		
//		
//		System.out.println(teste.getSaldo() +" -> " + "teste");
//		System.out.println(teste.getNumero() +" -> " + "teste");
//		System.out.println(teste.getDataHoraAtualizacao() +" -> " + "teste");
//		
//		System.out.println(testinho.buscarTodos());
		
		
		Vendedor testevender = new Vendedor();
		
		AcumuloResgateMediator resgate = AcumuloResgateMediator.getInstance();
		System.out.println(resgate.gerarCaixaDeBonus(testevender));
		
	}
}
