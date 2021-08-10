package Model.Entities;

import Model.Enums.TipoContas;

public class ContaEspecial extends Conta {

    private double Limite;

    public ContaEspecial(int nrConta, double saldo, Pessoa cliente, TipoContas tipo, double limite) {
        super(nrConta, saldo,cliente, tipo);
        Limite = limite;
    }

    public double getLimite() {
        return Limite;
    }

    public void setLimite(double limite) {
        Limite = limite;
    }

    protected boolean temSaldo(double valor){
        return  (getSaldo()+Limite) >= valor;
    }

    @Override
    public String toString() {
        return "Conta Especial [cliente = " + getCliente().getNome() + ", nrConta = " + getNrConta() + ", saldo = " + getSaldo() + ", limite = " + Limite + "]";
    }
}
