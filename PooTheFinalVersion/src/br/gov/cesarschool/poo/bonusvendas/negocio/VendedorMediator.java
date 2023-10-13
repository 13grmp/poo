package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;

public class VendedorMediator {
    private VendedorDAO repositorioVendedor;
    private AcumuloResgateMediator caixaDeBonusMediator;

    private static VendedorMediator instance;

    private VendedorMediator() {
        repositorioVendedor = new VendedorDAO();
        caixaDeBonusMediator = CaixaDeBonusMediator.getInstance();
    }

    public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }

    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
        String validacao = validar(vendedor);
        if (validacao != null) {
            return new ResultadoInclusaoVendedor(0, validacao);
        }

        repositorioVendedor.incluir(vendedor);

        int numeroCaixaBonus = caixaDeBonusMediator.gerarNumeroCaixaBonus();

        return new ResultadoInclusaoVendedor(numeroCaixaBonus, null);
    }

    public String alterar(Vendedor vendedor) {
        String validacao = validar(vendedor);
        if (validacao != null) {
            return validacao;
        }

        repositorioVendedor.alterar(vendedor);

        return null;
    }

    private String validar(Vendedor vendedor) {
        if (vendedor.getCpf() == null || vendedor.getCpf().isEmpty()) {
            return "CPF nao informado";
        }

        if (!ValidadorCPF.validarCPF(vendedor.getCpf())) {
            return "CPF invalido";
        }
    
        if (vendedor.getNomeCompleto() == null || vendedor.getNomeCompleto().isEmpty()) {
            return "Nome completo nao informado";
        }
    
        if (vendedor.getSexo() == null || vendedor.getSexo().isEmpty()) {
            return "Sexo nao informado";
        }
    
        if (vendedor.getDataNascimento() == null) {
            return "Data de nascimento nao informada";
        }
    
        LocalDate dataLimite = LocalDate.now().minusYears(17);
        if (vendedor.getDataNascimento().isAfter(dataLimite)) {
            return "Data de nascimento invalida";
        }
    
        if (vendedor.getRenda() < 0) {
            return "Renda menor que zero";
        }
    
        if (vendedor.getEndereco() == null) {
            return "Endereco nao informado";
        }
    
        if (vendedor.getEndereco().getLogradouro() == null || vendedor.getEndereco().getLogradouro().isEmpty()) {
            return "Logradouro nao informado";
        }
    
        if (vendedor.getEndereco().getLogradouro().length() < 4) {
            return "Logradouro tem menos de 04 caracteres";
        }
    
        if (vendedor.getEndereco().getNumero() < 0) {
            return "Numero menor que zero";
        }
    
        if (vendedor.getEndereco().getCidade() == null || vendedor.getEndereco().getCidade().isEmpty()) {
            return "Cidade nao informada";
        }
    
        if (vendedor.getEndereco().getEstado() == null || vendedor.getEndereco().getEstado().isEmpty()) {
            return "Estado nao informado";
        }
    
        if (vendedor.getEndereco().getPais() == null || vendedor.getEndereco().getPais().isEmpty()) {
            return "Pais nao informado";
        }
    
        return null; 
    }
    
    public Vendedor buscar(String cpf) {
        return repositorioVendedor.buscar(cpf);
    }
}
