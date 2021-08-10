package Model.Entities;

public class Pessoa {
    private int Id;
    private String Nome;
    private String Endereco;

    protected Pessoa(int id, String nome, String endereco) {
        Id = id;
        Nome = nome;
        Endereco = endereco;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
}
