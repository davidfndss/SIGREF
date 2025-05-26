# SIGREF 

> Sistema de Gestão de Remunerações - Financeiro - Java - Orientação a Objetos

<br>

# Desafio proposto:

Uma empresa possui três tipos de cargos com seus respectivos salários e benefícios:

| Cargo      | Salário Base                                   | Benefício                               |
|-------------|-----------------------------------------------|-------------------------------------------|
| Secretário | R$ 7.000,00 + R$ 1.000,00 por ano de serviço | 20% sobre o salário                      |
| Vendedor   | R$ 12.000,00 + R$ 1.800,00 por ano de serviço| 30% sobre o valor vendido                |
| Gerente    | R$ 20.000,00 + R$ 3.000,00 por ano de serviço| Não tem benefícios                       |

## Quadro de Funcionários

| Nome            | Cargo      | Mês/Ano da Contratação |
|-----------------|------------|-------------------------|
| Jorge Carvalho  | Secretário | 01/2018                 |
| Maria Souza     | Secretário | 12/2015                 |
| Ana Silva       | Vendedor   | 12/2021                 |
| João Mendes     | Vendedor   | 12/2021                 |
| Juliana Alves   | Gerente    | 07/2017                 |
| Bento Albino    | Gerente    | 03/2014                 |

## Registro de Vendas

| Vendedor    | 12/2021 | 01/2022 | 02/2022 | 03/2022 | 04/2022 |
|--------------|---------|---------|---------|---------|---------|
| Ana Silva    | R$ 5.200,00 | R$ 4.000,00 | R$ 4.200,00 | R$ 5.850,00 | R$ 7.000,00 |
| João Mendes  | R$ 3.400,00 | R$ 7.700,00 | R$ 5.000,00 | R$ 5.900,00 | R$ 6.500,00 |

## Requisitos de Implementação (Java - Orientação a Objetos)

Utilizando os conceitos de Orientação a Objetos, implemente em Java:

- ✅ Um método que receba uma lista de funcionários, mês e ano, e retorne o **valor total pago (salário e benefício)** a esses funcionários no mês.
- ✅ Um método que receba uma lista de funcionários, mês e ano, e retorne o **total pago somente em salários** no mês.
- ✅ Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano, e retorne o **total pago em benefícios** no mês.
- ✅ Um método que receba uma lista de funcionários, mês e ano, e retorne o **funcionário que recebeu o valor mais alto no mês**.
- ✅ Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano, e retorne o **nome do funcionário que recebeu o valor mais alto em benefícios no mês**.
- ✅ Um método que receba uma lista de vendedores, mês e ano, e retorne **o que mais vendeu no mês**.
