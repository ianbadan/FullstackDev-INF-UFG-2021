package br.ufg.inf.fs20211.business;

import br.ufg.inf.fs20211.dao.DB;
import br.ufg.inf.fs20211.dao.HospedeDao;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

import java.util.List;

public class HospedeBusiness {

    HospedeDao dao = new HospedeDao(DB.getConnection());

    public List<Hospede> findAll() throws HospedeException{
        return dao.findAll();
    }

    public Hospede findById(Integer id) throws HospedeException{
        return dao.findById(id);
    }

    public Hospede insert(Hospede hospede) throws HospedeException{
        return dao.insert(hospede);
    }

    public Hospede update(Hospede hospede) throws HospedeException{
        return dao.update(hospede);
    }

    public void delete(Integer id) throws HospedeException{
        dao.delete(id);
    }
}
