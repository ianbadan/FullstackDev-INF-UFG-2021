package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hospede;

import br.ufg.inf.springbootfs2021.exceptions.HospedeException;
import br.ufg.inf.springbootfs2021.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeBusiness {
    @Autowired
    HospedeRepository repository;

    public List<Hospede> findAll(){
        return repository.findAll();
    }

    public Page<Hospede> paginator(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Hospede findById(Integer id){
        Optional<Hospede> retorno= repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    public Hospede insert(Hospede hospede) throws HospedeException {
        this.validaHospede(hospede);
        return repository.save(hospede);
    }


    public Hospede update(Hospede hospede) throws HospedeException {
        this.validaHospede(hospede);
        return repository.save(hospede);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<Hospede> findByNomeHospede( String nomeHospede){
        return repository.findByNomeHospede(nomeHospede);
    }

    public List<Hospede> findByDtNascimento(LocalDate date){
        return repository.findByDtNascimento(date);
    }

    public List<Hospede> findByCPF(String cpf){
        return repository.findByCPF(cpf);
    }

    private void validaHospede(Hospede hospede) throws HospedeException{
        if(hospede.getNomeHospede() == null || hospede.getNomeHospede().length() ==0){
            throw new HospedeException("0308");
        }

        if(hospede.getDtNascimento() == null){
            throw new HospedeException("0309");
        }

        if(hospede.getCpf() == null){
            throw new HospedeException("0310");
        }
    }


}
