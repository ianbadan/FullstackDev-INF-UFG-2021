package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hotel;
import br.ufg.inf.springbootfs2021.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBusiness {

    @Autowired
    HotelRepository repository;

    public List<Hotel> findAll(){
        return repository.findAll();
    }

    public Hotel findById(Integer id){
        Optional<Hotel> retorno= repository.findById(id);
        return retorno.get();
    }

    public Hotel insert(Hotel hotel){
       return repository.save(hotel);
    }


    public Hotel update(Hotel hotel){
        return repository.save(hotel);
    }

    public void delete(Integer id){
       repository.deleteById(id);
    }
}
