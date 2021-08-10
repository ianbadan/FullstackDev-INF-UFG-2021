package Model.Entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PessoaFisica extends Pessoa{

    private String CPF;
    private LocalDate DtNascimento;
    private String Genero;

    public PessoaFisica(int id, String nome, String endereco, String CPF, LocalDate dtNascimento, String genero) {
        super(id, nome, endereco);
        this.CPF = CPF;
        DtNascimento = dtNascimento;
        Genero = genero;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getDtNascimento() {
        return DtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        DtNascimento = dtNascimento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getIdade(){
        LocalDate now = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(DtNascimento, now);
    }

    @Override
    public String toString() {
        return "Pessoa Fisica [ Nome = " + getNome() + ", CPF = " + CPF + ", Genero = " + Genero + ", Idade = " + getIdade() + ", Endereco = " + getEndereco() +"]";
    }
}
