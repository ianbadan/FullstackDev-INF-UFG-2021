package br.ufg.inf.springbootfs2021;

import br.ufg.inf.springbootfs2021.entities.Hospedagem;
import br.ufg.inf.springbootfs2021.entities.Hospede;
import br.ufg.inf.springbootfs2021.entities.Hotel;
import br.ufg.inf.springbootfs2021.entities.Quarto;
import br.ufg.inf.springbootfs2021.enums.CategoriaQuarto;
import br.ufg.inf.springbootfs2021.repository.HospedagemRepository;
import br.ufg.inf.springbootfs2021.repository.HospedeRepository;
import br.ufg.inf.springbootfs2021.repository.HotelRepository;
import br.ufg.inf.springbootfs2021.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")

public class Config implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
    private HospedeRepository hospedeRepository;
    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Override
    public void run(String... args) throws Exception {
        /*
        * INSERIR DADOS INICIAS NO BANCO DE DADOS
        * */

        Hotel ht1 = new Hotel(null, "Castros Park Hotel","Av. República do Líbano, 1520 - St. Oeste, Goiânia - GO, 74115-030",5);
        Hotel ht2 = new Hotel(null,"Hotel Aldeia Cerrado Pousada","R. 1122, 220 - Quadra 220, Lote 04 - St. Marista, Goiânia - GO, 74175-110",4);
        Hotel ht3 = new Hotel(null, "Sun Square Suítes Hotel bytb_quartotb_hotel","R. 9, 1053 - St. Oeste, Goiânia - GO, 74120-010",3);

        hotelRepository.save(ht1);
        hotelRepository.save(ht2);
        hotelRepository.save(ht3);


        Quarto q1 = new Quarto(null,hotelRepository.findById(1).get(), CategoriaQuarto.get(2),3,120,240.00);
        Quarto q2 = new Quarto(null,hotelRepository.findById(1).get(),CategoriaQuarto.get(3),2,401,500.00);
        Quarto q3 = new Quarto(null,hotelRepository.findById(1).get(),CategoriaQuarto.get(1),1,205,100.00);

        quartoRepository.save(q1);
        quartoRepository.save(q2);
        quartoRepository.save(q3);


        Hospede hp1 = new Hospede(null, "Aline Cardoso", LocalDate.of(1998,6,13), "485.442.198-37");
        Hospede hp2 = new Hospede(null, "Ana Julia Alves", LocalDate.of(2001,6,7), "525.019.828-78");
        Hospede hp3 = new Hospede(null, "Eduardo Florindo dos santos", LocalDate.of(1992,5,19), "371.150.688-79");
        Hospede hp4 = new Hospede(null, "André Demeter" , LocalDate.of(1995,5,31), "360.298.538-56");

        hospedeRepository.save(hp1);
        hospedeRepository.save(hp2);
        hospedeRepository.save(hp3);
        hospedeRepository.save(hp4);

        Hospedagem h1 = new Hospedagem(null, quartoRepository.findById(2).get(), hospedeRepository.findById(1).get(), LocalDate.of(2020,8,01), LocalDate.of(2020,8,07));
        Hospedagem h2 = new Hospedagem(null, quartoRepository.findById(1).get(), hospedeRepository.findById(3).get(), LocalDate.of(2020,8,01), LocalDate.of(2020,8,07));
        Hospedagem h3 = new Hospedagem(null, quartoRepository.findById(3).get(), hospedeRepository.findById(2).get(), LocalDate.of(2020,8,01), LocalDate.of(2020,8,07));

        hospedagemRepository.save(h1);
        hospedagemRepository.save(h2);
        hospedagemRepository.save(h3);
    }
}
