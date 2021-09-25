package br.ufg.inf.springbootfs2021.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospedagem")
    private Integer idHospedagem;

    @OneToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @OneToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;

    @Column(name = "data_checkin")
    private LocalDate dtCheckin;

    @Column(name = "data_checkout")
    private LocalDate dtCheckout;

    public Hospedagem() {
    }

    public Hospedagem(Integer idHospedagem, Quarto idQuarto, Hospede idHospede, LocalDate dtCheckin, LocalDate dtCheckout) {
        this.idHospedagem = idHospedagem;
        this.quarto = idQuarto;
        this.hospede = idHospede;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    public Integer getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Integer idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setIdQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public LocalDate getDtCheckin() {
        return dtCheckin;
    }

    public void setDtCheckin(LocalDate dtCheckin) {
        this.dtCheckin = dtCheckin;
    }

    public LocalDate getDtCheckout() {
        return dtCheckout;
    }

    public void setDtCheckout(LocalDate dtCheckout) {
        this.dtCheckout = dtCheckout;
    }

    @Override
    public String toString() {
        return "Hospedagem{" +
                "idHospedagem=" + idHospedagem +
                ", idQuarto=" + quarto +
                ", idHospede=" + hospede +
                ", dtCheckin=" + dtCheckin +
                ", dtCheckout=" + dtCheckout +
                '}';
    }
}
