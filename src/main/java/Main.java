import br.com.programa.dao.ProgramaDAO;
import br.com.programa.exe.entidades.Endereco;
import br.com.programa.exe.entidades.Pessoa;
import br.com.programa.exe.entidades.Servico;
import br.com.programa.service.ViaCepClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgramaDAO executar = new ProgramaDAO();
        Pessoa paciente = new Pessoa();
        Servico servico = new Servico();

        System.out.println("====== BEM-VINDO AO SISTEMA UNIVERSAL DE SAÚDE ======");
        System.out.println("\n==========================\n");
        System.out.println("O que você deseja fazer?\n");
        System.out.println("1 - Cadastrar Paciente");
        System.out.println("2 - Atualizar Cadastro de Paciente");
        System.out.println("3 - Excluir Cadastro de Paciente");
        System.out.println("4 - Acessar Banco de Pacientes Cadastrados");
        System.out.println("5 - Deletar todos os dados");
        System.out.println("0 - Sair do programa");
        System.out.println("\n==========================\n");
        int escolha1 = scanner.nextInt();
        scanner.nextLine();
        switch (escolha1) {
            case 1:
                try {
                    System.out.print("\nNome do paciente: ");
                    paciente.setNome(scanner.nextLine());
                    System.out.print("Telefone do paciente (com DDD): ");
                    paciente.setTelefone(scanner.nextLine());
                    System.out.print("CEP do paciente (sem pontuação): ");
                    paciente.setCep(scanner.nextLine());
                    System.out.print("Especialista Consulta: ");
                    servico.setDescricao(scanner.nextLine());
                    System.out.print("Valor da Consulta: ");
                    servico.setPreco(scanner.nextFloat());
                    scanner.nextLine();
                    System.out.print("Data da Consulta (DIA, MÊS, ANO (sem pontuação)): ");
                    servico.setDataservico(scanner.nextLine());
                    executar.save(paciente, servico);
                } catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.print("\nID do paciente que deseja atualizar: ");
                    paciente.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("--------------------");
                    System.out.print("\nNome do paciente: ");
                    paciente.setNome(scanner.nextLine());
                    System.out.print("Telefone do paciente (com DDD): ");
                    paciente.setTelefone(scanner.nextLine());
                    System.out.print("CEP do paciente (sem pontuação): ");
                    paciente.setCep(scanner.nextLine());
                    System.out.print("Especialista Consulta: ");
                    servico.setDescricao(scanner.nextLine());
                    System.out.print("Valor da Consulta: ");
                    servico.setPreco(scanner.nextFloat());
                    scanner.nextLine();
                    System.out.print("Data da Consulta (DIA, MÊS, ANO (sem pontuação)): ");
                    servico.setDataservico(scanner.nextLine());
                    executar.update(paciente, servico);
                } catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 3:
                try {
                    System.out.print("\nID do paciente: ");
                    executar.delete(scanner.nextInt());
                    scanner.nextLine();
                } catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    if (executar.informacoesPaciente().size() != 0) {
                        for (Pessoa p : executar.informacoesPaciente()) {
                            System.out.println("\n====================");
                            System.out.println("Nome: " + p.getNome() + " | ID: " + p.getId());
                            System.out.println("Telefone: " + p.getTelefone());
                            System.out.println("CEP: " + p.getCep());
                            System.out.println("\n--------------------------");
                            for (Servico s : executar.informacoesServico(p.getId())) {
                                System.out.println("\nConsulta: " + s.getDescricao());
                                System.out.printf("%nPreço: R$ %.2f%n", s.getPreco());
                                System.out.println("Data da Consulta: " + s.getDataservico());
                            }
                            System.out.println("\n--------------------------");
                            try {
                                Endereco end1 = new Endereco(p.getCep());
                                Endereco endereco = ViaCepClient.buscarCep(end1.getCep());
                                if (endereco.getCep() != null) {
                                    System.out.println("\nCEP: " + endereco.getCep());
                                    System.out.println("Estado: " + endereco.getEstado());
                                    System.out.println("Cidade: " + endereco.getCidade());
                                    System.out.println("Bairro: " + endereco.getBairro());
                                    System.out.println("Rua: " + endereco.getRua());
                                } else {
                                    System.out.println("Endereço não encontrado!");
                                }
                                System.out.println("====================");
                            } catch (Exception e) {
                                System.out.println("Erro, tente novamente mais tarde!");
                            }
                        }
                    } else {
                        System.out.println("\nTabela sem dados");
                    }
                } catch (Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 5:
                executar.deleteTable();
            default:
                System.out.println("Volte sempre, Deus abençoe!");
                break;
        }
    }
}