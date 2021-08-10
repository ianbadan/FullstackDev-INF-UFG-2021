package Model.Entities;

public class PessoaJuridica extends Pessoa{
    private String CNPJ;
    private String Atividade;

    public PessoaJuridica(int id, String nome, String endereco, String CNPJ, String atividade) {
        super(id, nome, endereco);
        this.CNPJ = CNPJ;
        Atividade = atividade;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getAtividade() {
        return Atividade;
    }

    public void setAtividade(String atividade) {
        Atividade = atividade;
    }

    @Override
    public String toString() {
        return "Pessoa Juridica [ Nome = " + getNome() + ", CPF = " + CNPJ + ", Atividade = " + Atividade + ", Endereco = " + getEndereco() +"]";
    }
}
