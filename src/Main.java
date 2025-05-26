import funcionarios.FuncionarioService;
import funcionarios.model.Funcionario;
import vendas.VendaService;
import vendas.model.Venda;
import enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class Main {

    // Injeta os Services que serão usados
    private static final FuncionarioService funcionarioService = new FuncionarioService();
    private static final VendaService vendaService = new VendaService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("Seja bem vindo ao SIGREF");
        System.out.println("( Sistema de Gestao de Remuneracoes e Financeiro )");
        System.out.println("----------------------------------------------------");

        int ano = 0;
        int mes = 0;

        // Solicita informações de mês e ano para consulta
        while (true) {
            System.out.print("Digite o ano para consulta (ex: 2022): ");
            if (scanner.hasNextInt()) {
                ano = scanner.nextInt();
                if (ano >= 1900 && ano <= 2100) {
                    break;
                } else {
                    System.out.println("Ano invalido! Digite um ano entre 1900 e 2100.");
                }
            } else {
                System.out.println("Entrada invalida! Digite um numero inteiro.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Digite o mes para consulta (1 a 12): ");
            if (scanner.hasNextInt()) {
                mes = scanner.nextInt();
                if (mes >= 1 && mes <= 12) {
                    break;
                } else {
                    System.out.println("Mes invalido! Digite um numero entre 1 e 12.");
                }
            } else {
                System.out.println("Entrada invalida! Digite um numero inteiro.");
                scanner.next();
            }
        }

        YearMonth mesAno = YearMonth.of(ano, mes);

        // Cria os registros de funcionários
        Funcionario jorge = new Funcionario("Jorge Carvalho", Cargo.SECRETARIO, LocalDate.of(2018, 1, 1));
        Funcionario maria = new Funcionario("Maria Souza", Cargo.SECRETARIO, LocalDate.of(2015, 12, 1));
        Funcionario ana = new Funcionario("Ana Silva", Cargo.VENDEDOR, LocalDate.of(2021, 12, 1));
        Funcionario joao = new Funcionario("Joao Mendes", Cargo.VENDEDOR, LocalDate.of(2021, 12, 1));
        Funcionario juliana = new Funcionario("Juliana Alves", Cargo.GERENTE, LocalDate.of(2017, 7, 1));
        Funcionario bento = new Funcionario("Bento Albino", Cargo.GERENTE, LocalDate.of(2014, 3, 1));

        // Cria uma Lista para cada caso diferente de consideração
        List<Funcionario> funcionarios = List.of(jorge, maria, ana, joao, juliana, bento);
        List<Funcionario> comBeneficios = List.of(jorge, maria, ana, joao);
        List<Funcionario> vendedores = List.of(ana, joao);

        // Cria Lista de registros de vendas
        List<Venda> vendas = List.of(
                new Venda(ana, YearMonth.of(2021, 12), BigDecimal.valueOf(5200)),
                new Venda(ana, YearMonth.of(2022, 1), BigDecimal.valueOf(4000)),
                new Venda(ana, YearMonth.of(2022, 2), BigDecimal.valueOf(4200)),
                new Venda(ana, YearMonth.of(2022, 3), BigDecimal.valueOf(5850)),
                new Venda(ana, YearMonth.of(2022, 4), BigDecimal.valueOf(7000)),
                new Venda(joao, YearMonth.of(2021, 12), BigDecimal.valueOf(3400)),
                new Venda(joao, YearMonth.of(2022, 1), BigDecimal.valueOf(7700)),
                new Venda(joao, YearMonth.of(2022, 2), BigDecimal.valueOf(5000)),
                new Venda(joao, YearMonth.of(2022, 3), BigDecimal.valueOf(5900)),
                new Venda(joao, YearMonth.of(2022, 4), BigDecimal.valueOf(6500))
        );

        // Chama os métodos dos respectivos Services de cálculos e imprime os resultados no console
        BigDecimal totalPago = funcionarioService.totalPago(funcionarios, mesAno, vendas);
        BigDecimal totalSalarios = funcionarioService.totalSalarios(funcionarios, mesAno);
        BigDecimal totalBeneficios = funcionarioService.totalBeneficios(comBeneficios, mesAno, vendas);
        String maiorRecebedor = funcionarioService.quemRecebeuMais(funcionarios, mesAno, vendas);
        String maiorBeneficiario = funcionarioService.quemRecebeuMaisBeneficios(comBeneficios, mesAno, vendas);
        String maiorVendedor = vendaService.quemMaisVendeu(vendedores, mesAno, vendas);

        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Resultados para " + mesAno + ":");
        System.out.println("----------------------------------------------------");

        System.out.println("Valor Total pago no mes: " + totalPago);
        System.out.println("Total pago em salarios no mes: " + totalSalarios);
        System.out.println("Total pago em benefícios no mes: " + totalBeneficios);
        System.out.println("Funcionario que recebeu mais no mes: " + maiorRecebedor);
        System.out.println("Funcionario que recebeu mais beneficios: " + maiorBeneficiario);
        System.out.println("Vendedor que mais vendeu no mes: " + maiorVendedor);

        System.out.println();
    }
}
