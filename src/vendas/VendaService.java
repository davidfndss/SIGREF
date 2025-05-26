package vendas;

import funcionarios.model.Funcionario;
import vendas.model.Venda;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VendaService {
    public String quemMaisVendeu(List<Funcionario> vendedores, YearMonth mesAno, List<Venda> vendas) {
        Map<Funcionario, BigDecimal> totalPorVendedor = new HashMap<>();
        BigDecimal total = null;
        for (Funcionario v : vendedores) {
            total = vendas.stream()
                    .filter(ven -> ven.getMesAno().equals(mesAno) && ven.getVendedor().equals(v))
                    .map(Venda::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            totalPorVendedor.put(v, total);
        }
        Funcionario funcionarioQueMaisVendeu = totalPorVendedor.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        // Verifica se não houve um usuário que mais vendeu OU se o total de vendas alto for igual a 0
        if (funcionarioQueMaisVendeu == null || Objects.equals(total, BigDecimal.valueOf(0))) {
            return "Nenhum";
        }
        
        return funcionarioQueMaisVendeu.getNome() + " (" + total  + ")";
    }
}