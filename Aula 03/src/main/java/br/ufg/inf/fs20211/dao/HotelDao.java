package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

    EntityManager em;

    public HotelDao(EntityManager em) {
        this.em = em;
    }

    public List<Hotel> findAll(){
        TypedQuery<Hotel> result = em.createQuery("from Hotel", Hotel.class);
        return result.getResultList();
    }

    public Hotel findById(Integer id){
        return this.em.find(Hotel.class, id);
    }

    public Hotel insert(Hotel hotel) throws HotelException{
        try{
            this.em.getTransaction().begin();
            this.em.persist(hotel);
            this.em.getTransaction().commit();

        } catch (Exception e){
            throw new HotelException("Erro no banco de dados (tb_hotel Insert):" + e.getMessage());
        }
        return hotel;
    }

    public Hotel update(Hotel hotel) throws HotelException{
        try{
            this.em.getTransaction().begin();
            this.em.persist(hotel);
            this.em.getTransaction().commit();
        } catch (Exception e){
            throw new HotelException("Erro no banco de dados (tb_hotel Update):" + e.getMessage());
        }
        return hotel;
    }

    public void delete(Hotel hotel) throws HotelException{
        if(hotel != null){
            try{
                this.em.getTransaction().begin();
                this.em.remove(hotel);
                this.em.getTransaction().commit();

            } catch (Exception e){
                throw new HotelException("Erro no banco de dados (tb_hotel Delete):" + e.getMessage());
            }
        }
    }
}
