package funcionarios;

import funcionarios.model.Funcionario;
import Pagamentos.model.Pagamento;
import vendas.model.Venda;
import enums.Cargo;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;

public class FuncionarioService {
    public BigDecimal totalPago(List<Funcionario> funcionarios, YearMonth mesAno, List<Venda> vendas) {
        return funcionarios.stream()
                .map(f -> new Pagamento(f, mesAno, vendas).getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalSalarios(List<Funcionario> funcionarios, YearMonth mesAno) {
        return funcionarios.stream()
                .map(f -> {

                    // Verifica se o usuário já foi contratado antes de considerar o salário
                    YearMonth dataContratacaoYM = YearMonth.from(f.getDataContratacao());
                    if (mesAno.isBefore(dataContratacaoYM)) {
                        return BigDecimal.ZERO;
                    }

                    int anos = f.anosDeServico(mesAno);
                    return switch (f.getCargo()) {
                        case SECRETARIO -> f.getSalarioBase().add(BigDecimal.valueOf(1000L * anos));
                        case VENDEDOR -> f.getSalarioBase().add(BigDecimal.valueOf(1800L * anos));
                        case GERENTE -> f.getSalarioBase().add(BigDecimal.valueOf(3000L * anos));
                    };
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalBeneficios(List<Funcionario> funcionarios, YearMonth mesAno, List<Venda> vendas) {
        return funcionarios.stream()
                .filter(f -> f.getCargo() == Cargo.SECRETARIO || f.getCargo() == Cargo.VENDEDOR)
                .map(f -> new Pagamento(f, mesAno, vendas).getBeneficio())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String quemRecebeuMais(List<Funcionario> funcionarios, YearMonth mesAno, List<Venda> vendas) {
        Funcionario funcionario =  funcionarios.stream()
                .max(Comparator.comparing(f -> new Pagamento(f, mesAno, vendas).getTotal()))
                .orElse(null);
        BigDecimal valor = funcionarios.stream()
                .max(Comparator.comparing(f -> new Pagamento(f, mesAno, vendas).getTotal()))
                .map(f -> new Pagamento(f, mesAno, vendas).getTotal())
                .orElse(null);

        if (funcionario == null) {
            return "Nenhum";
        }

        return funcionario.getNome() + " (" + valor + ")";
    }

    public String quemRecebeuMaisBeneficios(List<Funcionario> funcionarios, YearMonth mesAno, List<Venda> vendas) {
        String nomeFuncionario = funcionarios.stream()
                .filter(f -> f.getCargo() == Cargo.SECRETARIO || f.getCargo() == Cargo.VENDEDOR)
                .max(Comparator.comparing(f -> new Pagamento(f, mesAno, vendas).getBeneficio()))
                .map(Funcionario::getNome)
                .orElse(null);
        BigDecimal valor = funcionarios.stream()
                .filter(f -> f.getCargo() == Cargo.SECRETARIO || f.getCargo() == Cargo.VENDEDOR)
                .max(Comparator.comparing(f -> new Pagamento(f, mesAno, vendas).getBeneficio()))
                .map(f -> new Pagamento(f, mesAno, vendas).getBeneficio())
                .orElse(null);

        return nomeFuncionario + " (" + valor + ")" ;
    }
}