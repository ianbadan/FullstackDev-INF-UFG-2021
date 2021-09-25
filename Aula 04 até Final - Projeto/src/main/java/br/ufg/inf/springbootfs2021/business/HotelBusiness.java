package br.ufg.inf.springbootfs2021.business;

import br.ufg.inf.springbootfs2021.entities.Hotel;
import br.ufg.inf.springbootfs2021.exceptions.HotelException;
import br.ufg.inf.springbootfs2021.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBusiness {

    @Autowired
    HotelRepository repository;

    public List<Hotel> findByNome(String str){
        return repository.findByNomeHotel(str);
    }

    public List<Hotel> findByQtdEstrelas(Integer qtd){
        return repository.findByQtdEstrelas(qtd);
    }

    public List<Hotel> findByEndereco(String endereco){
        return repository.findByEnderecoHotel(endereco);
    }

    public List<Hotel> findAll(){
        return repository.findAll();
    }

    public Page<Hotel> paginator(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Hotel findById(Integer id){
        Optional<Hotel> retorno= repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    public Hotel insert(Hotel hotel) throws HotelException{
        this.validaHotel(hotel);
        return repository.save(hotel);
    }

    public Hotel update(Hotel hotel) throws HotelException{
        this.validaHotel(hotel);
        return repository.save(hotel);
    }

    public void delete(Integer id){
       repository.deleteById(id);
    }

    private void validaHotel(Hotel hotel) throws HotelException{
        if(hotel.getNmHotel() == null || hotel.getNmHotel().length() == 0){
            throw new HotelException("0109");
        }

        if(hotel.getQtdEstrelas() < 1 || hotel.getQtdEstrelas() > 6){
            throw new HotelException("0108");
        }

        if(hotel.getEnderecoHotel() == null || hotel.getEnderecoHotel().length() == 0){
            throw new HotelException("0110");
        }
    }
}
