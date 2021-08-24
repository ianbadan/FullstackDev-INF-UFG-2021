package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hospedagem;

import br.ufg.inf.springbootfs2021.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedagemBusiness {
    @Autowired
    HospedagemRepository repository;

    public List<Hospedagem> findAll(){
        return repository.findAll();
    }

    public Hospedagem findById(Integer id){
        Optional<Hospedagem> retorno= repository.findById(id);
        return retorno.get();
    }

    public Hospedagem insert(Hospedagem hospedagem){
        return repository.save(hospedagem);
    }


    public Hospedagem update(Hospedagem hospedagem){
        return repository.save(hospedagem);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
