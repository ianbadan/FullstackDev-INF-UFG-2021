package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hospede;

import br.ufg.inf.springbootfs2021.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeBusiness {
    @Autowired
    HospedeRepository repository;

    public List<Hospede> findAll(){
        return repository.findAll();
    }

    public Hospede findById(Integer id){
        Optional<Hospede> retorno= repository.findById(id);
        return retorno.get();
    }

    public Hospede insert(Hospede hospede){
        return repository.save(hospede);
    }


    public Hospede update(Hospede hospede){
        return repository.save(hospede);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
