import Entities.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<Conta>(); // Array com as contas do banco

        System.out.println("Criação da Conta pessoa Fisica de Carlos");
        PessoaFisica carlos = new PessoaFisica(1,"João","Rua 3, Setor Central", "00000000000", LocalDate.of(1998, 11, 24),"Masculino");
        System.out.println(carlos.toString());
        System.out.println("------------------------------------------");

        System.out.println("Criação da Conta pessoa Juridica da Marcenaria");
        PessoaJuridica marcenaria = new PessoaJuridica(2,"Marcenaria De qualidade","Rua 4, centro", "12345678900","Produção de peças de marcenaria");
        System.out.println(marcenaria.toString());
        System.out.println("------------------------------------------");


        System.out.println("Criação de uma conta poupança para Carlos");
        ContaPoupanca contaCarlos = new ContaPoupanca(1, 0, carlos, 0.3);

        System.out.println("Deposito de 2 mil reais");
        contaCarlos.depositar(2000);
        System.out.println(contaCarlos.toString());

        System.out.println("Saque de 800 reais");
        contaCarlos.sacar(800);
        System.out.println(contaCarlos.toString());

        System.out.println("Atualização do rendimento da conta 2 vezes;");
        contaCarlos.atualizaSaldoRendimento();
        contaCarlos.atualizaSaldoRendimento();
        System.out.println(contaCarlos.toString());
        System.out.println("------------------------------------------");

        System.out.println("Criação de uma conta especial para a Marcenaria");
        ContaEspecial contaMarcenaria = new ContaEspecial(2,0, marcenaria,10000);

        System.out.println("Deposito de 10 mil");
        contaMarcenaria.depositar(10000);
        System.out.println(contaMarcenaria.toString());

        System.out.println("Saque de 22000 mas sem saldo;");
        contaMarcenaria.sacar(22000);
        System.out.println(contaMarcenaria.toString());

        System.out.println("Saque de 15 mil;");
        contaMarcenaria.sacar(15000);
        System.out.println(contaMarcenaria.toString());
        System.out.println("------------------------------------------");

        System.out.println("Transferencia de 500 reais de Carlos para Marcenaria como pagamento de serviço");
        contaCarlos.transferir(500, contaMarcenaria);
        contas.add(contaCarlos);
        contas.add(contaMarcenaria);

        System.out.println("------------------------------------------");
        System.out.println("Dados Finais da Contas");
        for (Conta contaCliente: contas) { // itera entre as contas do banco, da print nas informações e soma o saldo para se ter um saldo total do Banco
            System.out.println(contaCliente.toString());

        }
    }

}