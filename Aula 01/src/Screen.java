import Model.Entities.Conta;
import Model.Entities.PessoaFisica;
import Model.Entities.PessoaJuridica;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.Instant;

public class Screen {

    private void showMenuPrincipal() {
        System.out.println("-------------------------");
        System.out.println("---Selecione Uma Opção---");
        System.out.println("-------------------------");
        System.out.println("1 – Abrir Nova Conta");
        System.out.println("2 – Selecionar Conta");
        System.out.println("3 – Cadastrar Cliente");
        System.out.println("4 – Relatórios");
        System.out.println("5 – Sair");
        System.out.println("-------------------------");
    }

    public void menuPrincipal(Scanner sc) {
        Integer escolha = 1;
        Conta conta;
        do {
            this.showMenuPrincipal();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Implentar Abrir Nova Conta");
                        break;

                    case 2:
                        conta = this.buscarConta(sc);
                        this.menuConta(sc, conta);
                        break;

                    case 3:
                        this.cadatrarCliente(sc);
                        break;

                    case 4:
                        System.out.println("Implentar Relatórios");
                        break;

                    case 5:
                        System.out.println("5 – Sair");
                        break;

                    default:
                        System.out.println("Opção Incorreta");
                }
            } catch (Exception e) {
                System.out.println("Opção Incorreta, sair.");
                escolha = 5;
            }
        } while (escolha != 5);

    }


    private void cadatrarCliente(Scanner sc) {

        System.out.println("--- Novo Cliente-----");
        System.out.println("Selecione o tipo de Pessoa");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");

        Integer tipo = sc.nextInt();


        System.out.println("--- Informe o ID -----");
        Integer id = sc.nextInt();

        System.out.println("--- Informe o Nome -----");
        String nome = sc.nextLine();

        System.out.println("--- Informe o Endereço -----");
        String endereco = sc.nextLine();

        if(tipo == 1) {
            System.out.println("--- Informe o CPF -----");
            String cpf = sc.nextLine();

            System.out.println("--- Informe a Data de Nascimento -----");
            String[] dtAux = sc.next().trim().split("/");

            LocalDate dtNascimento = LocalDate.from(Instant.parse(dtAux[2]+"-"+dtAux[2]+"-"+dtAux[0]+"T00:00:00Z"));

            System.out.println("--- Informe o Genero (M/F) -----");
            String genero = sc.next();

            main.clientes.add(new PessoaFisica(id, nome, endereco, cpf, dtNascimento, genero));

        }else {
            System.out.println("--- Informe o Nome -----");
            String cnpj = sc.nextLine();

            System.out.println("--- Informe o Endereço -----");
            String atividade = sc.nextLine();

            main.clientes.add(new PessoaJuridica(id, nome, endereco, cnpj, atividade));
        }

    }
    private void showMenuConta(Conta conta) {
        System.out.println("-------------------------");
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Nr Conta: " + conta.getNrConta());
        System.out.println("-------------------------");
        System.out.println("---Selecione Uma Opção---");
        System.out.println("-------------------------");
        System.out.println("1 – Alterar Conta");
        System.out.println("2 – Deposito");
        System.out.println("3 – Saque");
        System.out.println("4 – Transferência");
        System.out.println("5 – Saldo");
        System.out.println("6 – Sair");
        System.out.println("-------------------------");
    }


    private void menuConta(Scanner sc, Conta conta) {

        Integer escolha = 1;
        do {
            this.showMenuConta(conta);
            try {
                escolha = sc.nextInt();
                Double vr;
                switch (escolha) {
                    case 1:
                        this.showMenuAlterarConta(conta);
                        vr = sc.nextDouble();
                        break;
                    case 2:
                        System.out.println("Informe o Valor do Depósito");
                        vr = sc.nextDouble();
                        conta.depositar(vr);
                        break;
                    case 3:
                        System.out.println("Informe o Valor para Saque");
                        vr = sc.nextDouble();
                        conta.sacar(vr);

                        break;
                    case 4:
                        System.out.println("-------------------------");
                        System.out.println("---- Transferência ------");
                        Conta dest = this.buscarConta(sc);
                        System.out.println("Informe o Valor para Transferência");
                        vr = sc.nextDouble();
                        conta.transferir(vr, dest);
                        break;
                    case 5:
                        System.out.println("-------------------------");
                        System.out.println("--- SALDO: R$ "+conta.getSaldo());
                        System.out.println("-------------------------");

                        break;
                }

            }  catch (Exception e) {
                System.out.println("Opção Incorreta, sair.");
                escolha = 6;
            }
        }while (escolha != 6);
    }

    private void showMenuAlterarConta(Conta conta){
        System.out.println("-------------------------");
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Nr Conta: " + conta.getNrConta());
        System.out.println("-------------------------");
        System.out.println("---Selecione o que deseja alterar---");
        System.out.println("-------------------------");
        System.out.println("1 – Nome");
        System.out.println("2 – Endereço");
        if(conta.getCliente() instanceof PessoaFisica){
            System.out.println("3 – CPF");
            System.out.println("4 – Data Nascimento");
            System.out.println("5 – Genero");

        } else if (conta.getCliente() instanceof  PessoaJuridica){
            System.out.println("3 – CNPJ");
            System.out.println("4 – Atividade");
        }
        System.out.println("-------------------------");
    }


    public Conta buscarConta(Scanner sc) {

        Conta conta = null;
        do {
            System.out.println("------------------------------");
            System.out.println("---Digite o número da Conta---");
            System.out.println("------------------------------");
            Integer escolha = sc.nextInt();
            for (Conta c : main.contas) {

                if (c.getNrConta() == escolha) {
                    conta = c;
                    break;
                }
            }
            if (conta == null) {
                System.out.println("------------------------------");
                System.out.println("-----Conta Não Encontrada-----");
                System.out.println("------------------------------");
            }

        } while (conta == null);

        return conta;
    }
}
