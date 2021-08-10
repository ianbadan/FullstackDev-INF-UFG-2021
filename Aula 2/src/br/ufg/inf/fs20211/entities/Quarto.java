package br.ufg.inf.fs20211.entities;

import br.ufg.inf.fs20211.enums.CategoriaQuarto;

public class Quarto {
    private Integer idQuarto;
    private Hotel hotel;
    private CategoriaQuarto categoriaQuarto;
    private Integer qtdLeito;
    private Integer nrQuarto;
    private Double prDiaria;

    public Quarto() {

    }

    public Quarto(Integer idQuarto, Hotel hotel, CategoriaQuarto categoriaQuarto, Integer qtdLeito, Integer nrQuarto, Double prDiaria) {
        this.idQuarto = idQuarto;
        this.hotel = hotel;
        this.categoriaQuarto = categoriaQuarto;
        this.qtdLeito = qtdLeito;
        this.nrQuarto = nrQuarto;
        this.prDiaria = prDiaria;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setIdHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public CategoriaQuarto getCategoriaQuarto() {
        return categoriaQuarto;
    }

    public void setCategoriaQuarto(CategoriaQuarto categoriaQuarto) {
        this.categoriaQuarto = categoriaQuarto;
    }

    public Integer getQtdLeito() {
        return qtdLeito;
    }

    public void setQtdLeito(Integer qtdLeito) {
        this.qtdLeito = qtdLeito;
    }

    public Integer getNrQuarto() {
        return nrQuarto;
    }

    public void setNrQuarto(Integer nrQuarto) {
        this.nrQuarto = nrQuarto;
    }

    public Double getPrDiaria() {
        return prDiaria;
    }

    public void setPrDiaria(Double prDiaria) {
        this.prDiaria = prDiaria;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "idQuarto=" + idQuarto +
                ", hotel=" + hotel +
                ", categoriaQuarto=" + categoriaQuarto +
                ", qtdLeito=" + qtdLeito +
                ", nrQuarto=" + nrQuarto +
                ", prDiaria=" + prDiaria +
                '}';
    }
}
