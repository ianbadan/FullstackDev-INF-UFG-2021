package util;

import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.dao.DB;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;

import java.sql.Connection;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        testeConexao();
        testeCrudHotel();
        testeCrudQuarto();
        testeCrudHospede();
        testeCrudHospedagem();
    }

    public static void testeConexao() {
        Connection conn = DB.getConnection();
        if(conn != null){
            System.out.println("\nConexão Funcionou\n\n");
        } else{
            System.out.println("\nFalha na conexão\n\n");
        }
    }

    public static void testeCrudHotel() {
        System.out.println("*********** HOTEL *************");
        HotelCtrl ctrl = new HotelCtrl();

        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("Buscar pelo #ID 1");
        Hotel hotel = ctrl.findById(1);
        System.out.println(hotel);

        System.out.println("Cadastrar novo Hotel");

        Hotel h1 = new Hotel(null, "Hotel Goiânia", "Goiânia", 3);
        h1 = ctrl.insert(h1);
        System.out.println(h1);

        Hotel h2 = ctrl.findById(3);
        System.out.println("UPDATE");
        System.out.println("#ID original: " + h2);
        h2.setNmHotel(h2.getNmHotel() + " ALTERADO");
        h2 = ctrl.update(h2);
        System.out.println("#ID alterado: " + h2);


        System.out.println("Lista de Hoteis Cadastrados");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }
        System.out.println("Deletar #ID 4");
        ctrl.delete(4);

        System.out.println("Lista de Hoteis Atualizado");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println("_________________________________________________________________________");
    }

    public static void testeCrudQuarto() {
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

        Quarto q1 = new Quarto(null,
                hotelCtrl.findById(1),
                CategoriaQuarto.APARTAMENTO,
                3,
                120,
                240.0);
        q1 = ctrl.insert(q1);
        System.out.println(q1);

        Quarto q2 = ctrl.findById(3);
        System.out.println("UPDATE");
        System.out.println("#ID original: " + q2);
        q2.setPrDiaria(q2.getPrDiaria() + 20);
        q2 = ctrl.update(q2);
        System.out.println("#ID alterado: " + q2);


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

    public static void testeCrudHospede(){
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
        Hospede h1 = new Hospede(null, "Carlos Alberto", LocalDate.of(1987, 5, 6),"000.000.000-00");
        h1 = ctrl.insert(h1);
        System.out.println(h1);


        System.out.println("UPDATE");
        Hospede h2 = ctrl.findById(3);
        System.out.println("#ID original: " + h2);
        h2.setNomeHospede(h2.getNomeHospede() + "Alterado");
        h2 = ctrl.update(h2);
        System.out.println("#ID alterado: " + h2);

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

    public static void testeCrudHospedagem(){
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
        Hospedagem h1 = new Hospedagem(null, quartoCtrl.findById(2), hospedeCtrl.findById(3), LocalDate.of(2021, 8, 9), LocalDate.of(2021, 8, 18));
        h1 = ctrl.insert(h1);
        System.out.println(h1);

        System.out.println("UPDATE");
        Hospedagem h2 = ctrl.findById(4);
        System.out.println("#ID original: " + h2);
        h2.setDtCheckout(LocalDate.of(h2.getDtCheckout().getYear(), h2.getDtCheckout().getMonth(), (h2.getDtCheckout().getDayOfMonth()+3)));
        h2 = ctrl.update(h2);
        System.out.println("#ID alterado: " + h2);


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

