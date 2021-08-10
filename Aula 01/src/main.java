import Model.Enums.TipoContas;
import Model.Entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class main {

    static List<Conta> contas = new ArrayList<Conta>();
    static List<Pessoa> clientes = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PessoaFisica carlos = new PessoaFisica(1,"Carlos","Rua 3, Setor Central", "00000000000", LocalDate.of(1998, 11, 24),"Masculino");
        PessoaJuridica marcenaria = new PessoaJuridica(2,"Marcenaria De qualidade","Rua 4, centro", "12345678900","Produção de peças de marcenaria");

        ContaPoupanca contaCarlos = new ContaPoupanca(1, 50000, carlos, TipoContas.SIMPLES, 0.03);
        ContaEspecial contaMarcenaria = new ContaEspecial(2,1000000, marcenaria,TipoContas.EXECUTIVA,10000);

        contas.add(contaCarlos);
        contas.add(contaMarcenaria);

        Screen menu = new Screen();
        System.out.println("-------------------------");
        System.out.println("---- Seja Bem Vindo!-----");
        System.out.println("-------------------------");
        menu.menuPrincipal(sc);
        System.out.println("-------------------------");
        System.out.println("-- Programa encerrado!---");
        System.out.println("------- Até Mais!--------");
        System.out.println("-------------------------");

        sc.close();
    }

}