package Entities;

public class Conta {
    private int NrConta;
    private double Saldo;
    private Pessoa Cliente;

    protected Conta(int nrConta, double saldo, Pessoa cliente) {
        NrConta = nrConta;
        Saldo = saldo;
        Cliente = cliente;
    }

    public Conta abrirConta(int nrConta, double saldo, Pessoa cliente){
        return new Conta(nrConta, saldo, cliente);
    }

    public Pessoa getCliente() {
        return Cliente;
    }

    public void setCliente(Pessoa cliente) {
        Cliente = cliente;
    }

    public int getNrConta() {
        return NrConta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public double sacar(double valor){
        if(debitar(valor)){
            return valor;
        }
        return 0;
    }

    private Boolean debitar(double valor){
        if(temSaldo(valor)){
            Saldo -= valor;
            return true;
        }
        else {
            System.out.println("Saldo Insuficiente");
            return false;
        }
    }

    protected boolean temSaldo(double valor){
        return Saldo > valor;
    }

    public void depositar(double valor){
        Saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if (debitar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizada com sucesso");
        }
    }
}




