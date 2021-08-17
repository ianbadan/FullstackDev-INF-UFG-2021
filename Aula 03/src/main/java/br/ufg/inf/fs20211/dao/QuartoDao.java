package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.exceptions.HotelException;
import br.ufg.inf.fs20211.exceptions.QuartoException;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoDao {
    EntityManager em = null;

    public QuartoDao(EntityManager em){
        this.em = em;
    }

    public List<Quarto> findAll(){
        return em.createQuery("from Quarto", Quarto.class).getResultList();
    }

    public Quarto findById( Integer id){
        return this.em.find(Quarto.class, id);
    }

    public Quarto insert(Quarto quarto) throws QuartoException{
        try{
            this.em.getTransaction().begin();
            this.em.persist(quarto);
            this.em.getTransaction().commit();
        } catch (Exception e){
            throw new QuartoException("Erro no banco de dados (tb_quarto Insert):" + e.getMessage());
        }
        return quarto;
    }

    public  Quarto update(Quarto quarto) throws  QuartoException{
        try{
            this.em.getTransaction().begin();
            this.em.persist(quarto);
            this.em.getTransaction().commit();
        } catch (Exception e){
            throw new QuartoException("Erro no banco de dados (tb_quarto Update):" + e.getMessage());
        }
        return quarto;
    }

    public void delete(Quarto quarto) throws QuartoException{
        if(quarto != null) {
            try {
                this.em.getTransaction().begin();
                this.em.remove(quarto);
                this.em.getTransaction().commit();
            } catch (Exception e) {
                throw new QuartoException("Erro no banco de dados (tb_quarto Delete):" + e.getMessage());
            }
        }
    }
}

