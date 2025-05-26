package vendas.model;

import funcionarios.model.Funcionario;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Venda {
    Funcionario vendedor;
    YearMonth mesAno;
    BigDecimal valor;

    public Venda(Funcionario vendedor, YearMonth mesAno, BigDecimal valor) {
        this.vendedor = vendedor;
        this.mesAno = mesAno;
        this.valor = valor;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public YearMonth getMesAno() {
        return mesAno;
    }

    public BigDecimal getValor() {
        return valor;
    }
}