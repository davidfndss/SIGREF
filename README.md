# SIGREF

> Sistema de Gestão de Remunerações - Financeiro - Java - Orientação a Objetos


## Pré-requisitos

Antes de rodar o projeto, você precisará de:

- [Git](https://git-scm.com/downloads)
- [Java](https://www.java.com/pt-BR/download/)

## Como Rodar o Projeto:

### 1. Clone o projeto:
   Em um terminal execute:
```
git clone https://github.com/davidfndss/SIGREF
```
### 2. Acesse o diretório do projeto:
```
cd SIGREF/src
```
### 3. Compile o projeto:
  Execute o seguinte comando para compilar o arquivo principal:
```
javac Main.java
```
### 4. Execute o projeto:
  Rode o programa com:
```
java Main
```
  pronto! seu clone do SIGREF estará rodando no terminal, como segue o exemplo da imagem abaixo ↓
 <br>

#### Exemplo de uso:
![image](https://github.com/user-attachments/assets/88a5f95b-358d-43b8-ab5a-5ca07ec0d189)
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

<br>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-crimson.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
