package funcionarios.model;

import enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Funcionario {
    String nome;
    Cargo cargo;
    LocalDate dataContratacao;

    public Funcionario(String nome, Cargo cargo, LocalDate dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    // Calcula os anos de serviço do Funcionário
    public int anosDeServico(YearMonth anoMes) {
        int anos = anoMes.getYear() - dataContratacao.getYear(); // Subtrai o ano
        if (anoMes.getMonthValue() < dataContratacao.getMonthValue()) anos--; // Ajusta pelo mês
        return Math.max(0, anos); // Se o valor for negativo, retorna 0.
    }

    public BigDecimal getSalarioBase() {
        return cargo.getSalarioBase();
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
}