package br.ufg.inf.fs20211.entities;

import java.time.LocalDate;

public class Hospedagem {
    private Integer idHospedagem;
    private Quarto quarto;
    private Hospede hospede;
    private LocalDate dtCheckin;
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
        return "Hospede{" +
                "idHospedagem=" + idHospedagem +
                ", idQuarto=" + quarto +
                ", idHospede=" + hospede +
                ", dtCheckin=" + dtCheckin +
                ", dtCheckout=" + dtCheckout +
                '}';
    }
}
