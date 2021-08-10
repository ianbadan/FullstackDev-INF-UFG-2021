package br.ufg.inf.fs20211.entities;

public class Hotel {
    private Integer idHotel;
    private String nmHotel;
    private String enderecoHotel;
    private Integer qtdEstrelas;

    public Hotel() {

    }

    public Hotel(Integer idHotel, String nmHotel, String enderecoHotel, Integer qtdEstrelas) {
        this.idHotel = idHotel;
        this.nmHotel = nmHotel;
        this.enderecoHotel = enderecoHotel;
        this.qtdEstrelas = qtdEstrelas;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNmHotel() {
        return nmHotel;
    }

    public void setNmHotel(String nmHotel) {
        this.nmHotel = nmHotel;
    }

    public String getEnderecoHotel() {
        return enderecoHotel;
    }

    public void setEnderecoHotel(String enderecoHotel) {
        this.enderecoHotel = enderecoHotel;
    }

    public Integer getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(Integer qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", nmHotel='" + nmHotel + '\'' +
                ", enderecoHotel='" + enderecoHotel + '\'' +
                ", qtdEstrelas=" + qtdEstrelas +
                '}';
    }
}
