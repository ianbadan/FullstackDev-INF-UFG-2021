package br.ufg.inf.fs20211.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id_hospede")
    private Integer idHospede;

    @Column(name = "nome_hospede")
    private String nomeHospede;

    @Column(name = "data_nascimento")
    private LocalDate dtNascimento;

    private String cpf;

    public Hospede() {
    }

    public Hospede(Integer idHospede, String nomeHospede, LocalDate dtNascimento, String cpf) {
        this.idHospede = idHospede;
        this.nomeHospede = nomeHospede;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }


    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "idHospede=" + idHospede +
                ", nomeHospede='" + nomeHospede + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
