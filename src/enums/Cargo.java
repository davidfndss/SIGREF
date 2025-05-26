package enums;

import java.math.BigDecimal;

public enum Cargo {
    SECRETARIO(BigDecimal.valueOf(7000)),
    VENDEDOR(BigDecimal.valueOf(12000)),
    GERENTE(BigDecimal.valueOf(20000));

    final BigDecimal salarioBase;

    Cargo(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }
}