package br.ufg.inf.fs20211.ctrl;





import br.ufg.inf.fs20211.business.HospedeBusiness;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

import java.util.ArrayList;
import java.util.List;

public class HospedeCtrl {
    HospedeBusiness business = new HospedeBusiness();

    public List<Hospede> findAll(){
        List<Hospede> retorno = new ArrayList<Hospede>();

        try {
            retorno = business.findAll();
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospede findById(Integer id) {
        Hospede retorno = new Hospede();

        try {
            retorno = business.findById(id);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospede insert(Hospede hospede) {
        try {
            hospede = business.insert(hospede);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) {
        try {
            hospede = business.update(hospede);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }
        return hospede;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }
    }
}
