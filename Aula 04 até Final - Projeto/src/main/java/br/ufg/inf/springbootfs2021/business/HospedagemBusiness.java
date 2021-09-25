package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hospedagem;

import br.ufg.inf.springbootfs2021.entities.Hospede;
import br.ufg.inf.springbootfs2021.entities.Quarto;
import br.ufg.inf.springbootfs2021.exceptions.HospedagemException;
import br.ufg.inf.springbootfs2021.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HospedagemBusiness {
    @Autowired
    HospedagemRepository repository;

    public List<Hospedagem> findAll(){
        return repository.findAll();
    }

    public Page<Hospedagem> paginator(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Hospedagem findById(Integer id){
        Optional<Hospedagem> retorno= repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
        this.validaHospedagem(hospedagem);
        return repository.save(hospedagem);
    }


    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        this.validaHospedagem(hospedagem);
        return repository.save(hospedagem);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<Hospedagem> findByIdQuarto(Quarto quarto) {
        return repository.findByIdQuarto(quarto);

    }

    public List<Hospedagem> findByIdHospede( Hospede hospede) {
        return repository.findByIdHospede(hospede);
    }

    public List<Hospedagem> findByDataCheckin(LocalDate date) {
        return repository.findByDataCheckin(date);
    }

    public List<Hospedagem> findByDataCheckout(LocalDate date) {
        return repository.findByDataCheckout(date);
    }

    private void validaHospedagem(Hospedagem hospedagem) throws HospedagemException{
        if(hospedagem.getHospede() == null){
            throw new HospedagemException("0409");
        }

        if(hospedagem.getQuarto() == null){
            throw new HospedagemException("0408");
        }

        if(hospedagem.getDtCheckin() == null){
            throw new HospedagemException("0410");
        }

        if(hospedagem.getDtCheckout() == null){
            throw new HospedagemException("0411");
        }

        if(hospedagem.getDtCheckout().isBefore(hospedagem.getDtCheckin())){
            throw new HospedagemException("0412");
        }

        if(hospedagem.getDtCheckin().isBefore(LocalDate.now())){
            throw new HospedagemException("0413");
        }

        if(hospedagem.getDtCheckout().isBefore(LocalDate.now())){
            throw new HospedagemException("0414");
        }
    }
}
