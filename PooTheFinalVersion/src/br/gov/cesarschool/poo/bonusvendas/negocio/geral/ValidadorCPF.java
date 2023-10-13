package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {
	
	private ValidadorCPF() {
		
	};
	
	 public static boolean ehCpfValido(String cpf) {

	        cpf = cpf.replaceAll("[^0-9]", "");
	        if (cpf.length() != 11) {
	            return false;
	        }


	        boolean todosDigitosIguais = true;
	        for (int i = 1; i < cpf.length(); i++) {
	            if (cpf.charAt(i) != cpf.charAt(0)) {
	                todosDigitosIguais = false;
	                break;
	            }
	        }
	        if (todosDigitosIguais) {
	            return false;
	        }

	        int soma = 0;
	        for (int i = 0; i < 9; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	        }
	        int primeiroDigitoVerificador = 11 - (soma % 11);
	        if (primeiroDigitoVerificador > 9) {
	            primeiroDigitoVerificador = 0;
	        }

	        if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
	            return false;
	        }


	        soma = 0;
	        for (int i = 0; i < 10; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	        }
	        int segundoDigitoVerificador = 11 - (soma % 11);
	        if (segundoDigitoVerificador > 9) {
	            segundoDigitoVerificador = 0;
	        }

	        return Character.getNumericValue(cpf.charAt(10)) == segundoDigitoVerificador;
	    };
	
}
