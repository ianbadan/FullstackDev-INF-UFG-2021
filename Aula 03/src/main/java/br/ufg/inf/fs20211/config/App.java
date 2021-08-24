package br.ufg.inf.fs20211.config;

import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;

import java.sql.Connection;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        testeJpaHotel();
        testeJpaQuarto();
        testeJpaHospede();
        testeJpaHospedagem();

        DaoFactory.closeConnection();
    }


    public static void testeJpaHotel() {
        HotelCtrl ctrl = new HotelCtrl();
        System.out.println("*********** HOTEL *************");

        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar pelo #ID 1");
        Hotel hotel = ctrl.findById(1);
        System.out.println(hotel);

        System.out.println("Cadastrar novo Hotel");

        Hotel h1 ;
        h1 = ctrl.insert(new Hotel(null, "Hotel Goiânia", "Goiânia", 3));
        System.out.println(h1);

        Hotel h2 = ctrl.findById(1);
        if(h2 != null){
            System.out.println("UPDATE");
            System.out.println("#ID original: " + h2);
            h2.setNmHotel(h2.getNmHotel() + " ALTERADO");
            h2 = ctrl.update(h2);
            System.out.println("#ID alterado: " + h2);
        }

        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 2");
        ctrl.delete(2);

        System.out.println("Lista de Hoteis Atualizado");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("_________________________________________________________________________");
    }

    public static void testeJpaQuarto() {
        System.out.println("*********** QUARTO *************");

        QuartoCtrl ctrl = new QuartoCtrl();

        HotelCtrl hotelCtrl = new HotelCtrl();

        System.out.println("Lista de Quartos Cadastrados");
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println("Buscar pelo #ID 1");
        Quarto quarto = ctrl.findById(1);
        System.out.println(quarto);

        System.out.println("Cadastrar novo Quarto");

        Quarto q1;
        q1 = ctrl.insert(new Quarto(null,
                hotelCtrl.findById(1),
                CategoriaQuarto.APARTAMENTO,
                3,
                120,
                240.0));
        System.out.println(q1);

        Quarto q2 = ctrl.findById(1);
        System.out.println("UPDATE");
        if(q2 != null){
            System.out.println("#ID original: " + q2);
            q2.setPrDiaria(q2.getPrDiaria() + 20);
            q2 = ctrl.update(q2);
            System.out.println("#ID alterado: " + q2);
        }

        System.out.println("Lista de Quartos Cadastrados");
        for (Quarto h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 2");
        ctrl.delete(2);

        System.out.println("Lista de Quartos Atualizado");
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println("_________________________________________________________________________");
    }

    public static void testeJpaHospede(){
        System.out.println("*********** HOSPEDE *************");
        HospedeCtrl ctrl = new HospedeCtrl();

        System.out.println("Lista de Hospedes Cadastrados");
        for (Hospede q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println("Buscar pelo #ID 1");
        Hospede hospede = ctrl.findById(1);
        System.out.println(hospede);

        System.out.println("Cadastrar novo hospede");
        Hospede h1 = ctrl.insert( new Hospede(null, "Carlos Alberto", LocalDate.of(1987, 5, 6),"000.000.000-00"));
        System.out.println(h1);


        System.out.println("UPDATE");
        Hospede h2 = ctrl.findById(1);
        if(h2 != null){
            System.out.println("#ID original: " + h2);
            h2.setNomeHospede(h2.getNomeHospede() + " Alterado");
            h2 = ctrl.update(h2);
            System.out.println("#ID alterado: " + h2);
        }

        System.out.println("Lista de Hospedes Cadastrados");
        for (Hospede h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 2");
        ctrl.delete(2);

        System.out.println("Lista de hospedes Atualizado");
        for (Hospede h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("_________________________________________________________________________");

    }

    public static void testeJpaHospedagem(){
        System.out.println("*********** HOSPEDAGEM *************");
        HospedagemCtrl ctrl = new HospedagemCtrl();
        QuartoCtrl quartoCtrl = new QuartoCtrl();
        HospedeCtrl hospedeCtrl = new HospedeCtrl();

        System.out.println("Lista de Hospedagem Cadastrados");
        for (Hospedagem h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar pelo #ID 1");
        Hospedagem hospedagem = ctrl.findById(1);
        System.out.println(hospedagem);

        System.out.println("Cadastrar nova hospedagem");
        Hospedagem h1;
        h1 = ctrl.insert(new Hospedagem(null, quartoCtrl.findById(1), hospedeCtrl.findById(1), LocalDate.of(2021, 8, 9), LocalDate.of(2021, 8, 18)));
        System.out.println(h1);

        System.out.println("UPDATE");
        Hospedagem h2 = ctrl.findById(1);
        if(h2 != null){
            System.out.println("#ID original: " + h2);
            h2.setDtCheckout(h2.getDtCheckout().plusDays(2));
            h2 = ctrl.update(h2);
            System.out.println("#ID alterado: " + h2);
        }


        System.out.println("Lista de Hospedagem Cadastrados");
        for (Hospedagem h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Deletar #ID 2");
        ctrl.delete(2);


        System.out.println("Lista de hospedagens Atualizado");
        for (Hospedagem h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("_________________________________________________________________________");

    }


}

