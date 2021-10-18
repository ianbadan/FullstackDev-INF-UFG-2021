package br.ufg.inf.springbootfs2021.business;


import br.ufg.inf.springbootfs2021.entities.Hotel;
import br.ufg.inf.springbootfs2021.entities.Quarto;

import br.ufg.inf.springbootfs2021.enums.CategoriaQuarto;
import br.ufg.inf.springbootfs2021.exceptions.QuartoException;
import br.ufg.inf.springbootfs2021.repository.HotelRepository;
import br.ufg.inf.springbootfs2021.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoBusiness {

    @Autowired
    QuartoRepository repository;

    @Autowired
    HotelRepository hotelRepository;

    public List<Quarto> findAll(){
        return repository.findAll();
    }

    public Page<Quarto> paginator(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Quarto findById(Integer id){
        Optional<Quarto> retorno= repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    public Quarto insert(Quarto quarto) throws QuartoException {
        this.validaQuarto(quarto);
        System.out.println(quarto);
        return repository.save(quarto);
    }


    public Quarto update(Quarto quarto) throws QuartoException {
        this.validaQuarto(quarto);
        return repository.save(quarto);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<Quarto> findByCategoriaQuarto(CategoriaQuarto categoriaQuarto){
        return repository.findByCategoriaQuarto(categoriaQuarto);
    }

    public List<Quarto> findByQtdLeito(Integer qtd){
        return repository.findByQtdLeito(qtd);
    }

    public List<Quarto> findByNumeroQuarto(Integer nrQuarto){
        return repository.findByNumeroQuarto(nrQuarto);
    }

    public List<Quarto> findByPrecoDiaria(Double precoDiaria){
        return repository.findByPrecoDiaria(precoDiaria);
    }

    public List<Quarto> findByIntervaloPrecoDiaria(Double precoMinimo, Double precoMaximo){
        return repository.findByIntervaloPrecoDiaria(precoMinimo, precoMaximo);
    }

    public List<Quarto> findByHotel(Hotel hotel){
        return repository.findByHotel(hotel);
    }

    public void validaQuarto(Quarto quarto) throws QuartoException{
        if(quarto.getHotel() == null){
            throw new QuartoException("0208");
        }
        if(quarto.getCategoriaQuarto() == null){
            throw new QuartoException("0209");
        }
        if(quarto.getQtdLeito() == null || quarto.getQtdLeito() <= 0){
            throw new QuartoException("0210");
        }

        if(quarto.getNrQuarto() == null || quarto.getNrQuarto() <= 0){
            throw new QuartoException("0211");
        }

        if(quarto.getPrDiaria() == null || quarto.getPrDiaria() <= 0){
            throw new QuartoException("0212");
        }
    }

}
