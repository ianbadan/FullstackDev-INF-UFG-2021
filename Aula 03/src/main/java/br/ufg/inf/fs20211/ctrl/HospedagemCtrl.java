package br.ufg.inf.fs20211.ctrl;



import br.ufg.inf.fs20211.business.HospedagemBusiness;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.exceptions.HospedagemException;

import java.util.ArrayList;
import java.util.List;

public class HospedagemCtrl {
    HospedagemBusiness business = new HospedagemBusiness();

    public List<Hospedagem> findAll(){
        return business.findAll();
    }

    public Hospedagem findById(Integer id) {
        return business.findById(id);
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        try {
            hospedagem = business.insert(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) {
        try {
            hospedagem = business.update(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
        return hospedagem;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
    }


}
