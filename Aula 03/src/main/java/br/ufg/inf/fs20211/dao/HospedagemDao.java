package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.exceptions.HospedagemException;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDao {
    EntityManager em = null;

    public HospedagemDao( EntityManager em) {
        this.em = em;
    }

    public List<Hospedagem> findAll(){
        return em.createQuery("From Hospedagem", Hospedagem.class).getResultList();
    }

    public Hospedagem findById(Integer id){
        return em.find(Hospedagem.class, id);
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException{
        try{
            em.getTransaction().begin();
            em.persist(hospedagem);
            em.getTransaction().commit();
        } catch (Exception e){
            throw new HospedagemException("Erro no banco de dados (tb_hospedagem Insert): " + e.getMessage());
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException{
        try{
            em.getTransaction().begin();
            em.persist(hospedagem);
            em.getTransaction().commit();
        } catch (Exception e){
            throw new HospedagemException("Erro no banco de dados (tb_hospedagem Update): " + e.getMessage());
        }
        return hospedagem;
    }

    public void delete(Hospedagem hospedagem) throws HospedagemException{
        if(hospedagem != null){
            try{
                em.getTransaction().begin();
                em.remove(hospedagem);
                em.getTransaction().commit();
            } catch (Exception e){
                throw new HospedagemException("Erro no banco de dados (tb_hospedagem Delete): " + e.getMessage());
            }
        }
    }
}

