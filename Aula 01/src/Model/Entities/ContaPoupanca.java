package Model.Entities;

import Model.Enums.TipoContas;

public class ContaPoupanca extends Conta{

    private double TxCorrecao;

    public ContaPoupanca(int nrConta, double saldo, Pessoa cliente, TipoContas tipo, double txCorrecao) {
        super(nrConta, saldo, cliente, tipo);
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
