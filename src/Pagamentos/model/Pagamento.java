package Pagamentos.model;

import funcionarios.model.Funcionario;
import vendas.model.Venda;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class Pagamento {
    Funcionario funcionario;
    YearMonth mesAno;
    BigDecimal salario;
    BigDecimal beneficio;

    public Pagamento(Funcionario funcionario, YearMonth mesAno, List<Venda> vendas) {
        this.funcionario = funcionario;

        // Verifica se o funcionário já estava contratado, se não o salário vai ser 0
        YearMonth dataContratacaoYM = YearMonth.from(funcionario.getDataContratacao());
        if (mesAno.isBefore(dataContratacaoYM)) {
            salario = BigDecimal.ZERO;
            beneficio = BigDecimal.ZERO;
            return;
        }

        int anosDeServico = funcionario.anosDeServico(mesAno);

        // Esse bloco switch calcula o valor do benefício conforme o cargo do Funcionário
        switch (funcionario.getCargo()) {
            case SECRETARIO -> {
                salario = funcionario.getSalarioBase().add(BigDecimal.valueOf(1000L * anosDeServico));
                beneficio = salario.multiply(BigDecimal.valueOf(0.2));
            }
            case VENDEDOR -> {
                salario = funcionario.getSalarioBase().add(BigDecimal.valueOf(1800L * anosDeServico));
                BigDecimal totalVendido = vendas.stream()
                        .filter(v -> v.getMesAno().equals(mesAno) && v.getVendedor().equals(funcionario))
                        .map(Venda::getValor)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                beneficio = totalVendido.multiply(BigDecimal.valueOf(0.3));
            }
            case GERENTE -> {
                salario = funcionario.getSalarioBase().add(BigDecimal.valueOf(3000L * anosDeServico));
                beneficio = BigDecimal.valueOf(0);
            }
        }
    }

    public BigDecimal getTotal() {
        return salario.add(beneficio);
    }

    public BigDecimal getBeneficio() {
        return beneficio;
    }
}