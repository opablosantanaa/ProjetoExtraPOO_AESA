# 🏥 Sistema Universal de Saúde

Sistema de cadastro de pacientes via terminal, feito em Java com banco de dados MySQL. Permite cadastrar, atualizar, consultar e excluir pacientes e suas consultas médicas. Também busca o endereço automaticamente a partir do CEP usando a API do ViaCEP.

---

## O que o sistema faz

- Cadastrar um paciente com nome, telefone, CEP e dados da consulta
- Atualizar os dados de um paciente já cadastrado
- Excluir um paciente pelo ID
- Listar todos os pacientes com suas consultas e endereços
- Apagar todos os dados da tabela

---

## Tecnologias usadas

- Java 21
- Maven
- MySQL
- [ViaCEP](https://viacep.com.br/) (busca de endereço por CEP)
- OkHttp + Gson (requisições HTTP)
- dotenv-java (variáveis de ambiente)

---

## Pré-requisitos

Antes de rodar, você precisa ter instalado:

- Java 21+
- Maven
- MySQL

---

## Como configurar

**1. Clone ou extraia o projeto**

**2. Crie o banco de dados**

Execute o script SQL que está em `src/main/resources/script.sql`:

```sql
create database if not exists infos;
use infos;
create table paciente(
  id int unique not null auto_increment,
  nome varchar(50) not null,
  telefone varchar(15),
  cep varchar(12) not null,
  descricao varchar(25) not null,
  preco double not null,
  dataservico varchar(12) not null,
  primary key (id)
);
```

Se usar o MySQL Workbench execute o comando pressionando Ctrl+Shift+Enter ou o script não vai funcionar!

**3. Configure as variáveis de ambiente**

Copie o arquivo `.env.example` para `.env` e preencha com os seus dados:

```env
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
DB_HOST=localhost
DB_PORT=3306
DB_NAME=infos
```

**4. Instale as dependências e compile**

```bash
mvn install
```

**5. Rode o programa**

```bash
mvn exec:java -Dexec.mainClass="Main"
```

Ou execute diretamente pela sua IDE (IntelliJ, Eclipse, etc.).

---

## Como usar

Ao abrir o programa, um menu aparece no terminal:

```
====== BEM-VINDO AO SISTEMA UNIVERSAL DE SAÚDE ======

1 - Cadastrar Paciente
2 - Atualizar Cadastro de Paciente
3 - Excluir Cadastro de Paciente
4 - Acessar Banco de Pacientes Cadastrados
5 - Deletar todos os dados
0 - Sair do programa
```

Basta digitar o número da opção desejada e seguir as instruções.

> ⚠️ A opção **5** apaga todos os dados da tabela sem confirmação. Use com cuidado.

---

## Estrutura do projeto

```
src/
└── main/
    ├── java/
    │   ├── Main.java                  → ponto de entrada, menu principal
    │   └── br/com/programa/
    │       ├── connection/
    │       │   └── Conexao.java       → conexão com o banco de dados
    │       ├── dao/
    │       │   └── ProgramaDAO.java   → operações no banco (CRUD)
    │       ├── exe/entidades/
    │       │   ├── Base.java          → classe base (id, nome, cep)
    │       │   ├── Pessoa.java        → dados do paciente
    │       │   ├── Servico.java       → dados da consulta
    │       │   ├── Endereco.java      → dados do endereço (ViaCEP)
    │       │   └── Status.java        → enum de status
    │       └── service/
    │           └── ViaCepClient.java  → busca de endereço por CEP
    └── resources/
        └── script.sql                 → script para criar o banco
```

---

## Observações

- O telefone deve ser informado **com DDD**, sem espaços ou pontuação (ex: `81999998888`)
- O CEP deve ser informado **sem pontuação** (ex: `01310100`)
- A data da consulta deve ser no formato **DDMMAAAA** (ex: `22052026`)