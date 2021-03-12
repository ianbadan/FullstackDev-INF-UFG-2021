package Entities;

public class ContaPoupanca extends Conta{

    private double TxCorrecao;

    public ContaPoupanca(int nrConta, double saldo, Pessoa cliente, double txCorrecao) {
        super(nrConta, saldo, cliente);
        TxCorrecao = txCorrecao;
    }

    public double getTxCorrecao() {
        return TxCorrecao;
    }

    public void setTxCorrecao(double txCorrecao) {
        TxCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento(){
        this.depositar(getSaldo() * TxCorrecao);
    }

    @Override
    public String toString() {
        return "Conta Poupança [cliente = " + getCliente().getNome() + ", nrConta = " + getNrConta() + ", saldo = " + getSaldo() + ", Taxa de correção = " + TxCorrecao + "]";
    }
}
