package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;
import br.ufg.inf.fs20211.exceptions.HotelException;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDao {
    EntityManager em = null;

    public HospedeDao(EntityManager em) {
        this.em = em;
    }

    public List<Hospede> findAll(){
        return em.createQuery("From Hospede", Hospede.class).getResultList();
    }

    public Hospede findById(Integer id){
        return em.find(Hospede.class, id);
    }

    public Hospede insert(Hospede hospede) throws HospedeException{
        try{
            em.getTransaction().begin();
            em.persist(hospede);
            em.getTransaction().commit();

        } catch (Exception e){
            throw new HospedeException("Erro no banco de dados (tb_hospede Insert):" + e.getMessage());
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) throws HospedeException{
        try{
            em.getTransaction().begin();
            em.persist(hospede);
            em.getTransaction().commit();

        } catch (Exception e){
            throw new HospedeException("Erro no banco de dados (tb_hospede Update):" + e.getMessage());
        }
        return hospede;
    }

    public void delete(Hospede hospede) throws HospedeException{
       if(hospede != null) {
           try {
               em.getTransaction().begin();
               em.remove(hospede);
               em.getTransaction().commit();
           } catch (Exception e) {
               throw new HospedeException("Erro no banco de dados (tb_hospede Delete):" + e.getMessage());
           }
       }

    }
}
