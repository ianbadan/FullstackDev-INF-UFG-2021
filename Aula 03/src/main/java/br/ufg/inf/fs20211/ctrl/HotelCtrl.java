package br.ufg.inf.fs20211.ctrl;

import br.ufg.inf.fs20211.business.HotelBusiness;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;

import java.util.ArrayList;
import java.util.List;

public class HotelCtrl {

    HotelBusiness business = new HotelBusiness();

    public List<Hotel> findAll(){
        return business.findAll();
    }

    public Hotel findById(Integer id) {
        return business.findById(id);
    }

    public Hotel insert(Hotel hotel) {
        try {
            hotel = business.insert(hotel);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }
        return hotel;
    }

    public Hotel update(Hotel hotel) {
        try {
            hotel = business.update(hotel);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }
        return hotel;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }
    }


}
