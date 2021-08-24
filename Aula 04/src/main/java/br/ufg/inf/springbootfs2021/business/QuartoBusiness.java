package br.ufg.inf.springbootfs2021.business;


import br.ufg.inf.springbootfs2021.entities.Quarto;

import br.ufg.inf.springbootfs2021.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoBusiness {

    @Autowired
    QuartoRepository repository;

    public List<Quarto> findAll(){
        return repository.findAll();
    }

    public Quarto findById(Integer id){
        Optional<Quarto> retorno= repository.findById(id);
        return retorno.get();
    }

    public Quarto insert(Quarto quarto){
        return repository.save(quarto);
    }


    public Quarto update(Quarto quarto){
        return repository.save(quarto);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
