package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.business.HotelBusiness;
import br.ufg.inf.springbootfs2021.entities.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hoteis")
public class HotelCtrl {

    @Autowired
    private HotelBusiness business;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll(){
        List<Hotel> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Integer id) {
        Hotel retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Hotel> insert(@RequestBody Hotel hotel) {
        Hotel retorno = business.insert(hotel);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity<Hotel> update(@RequestBody Hotel hotel) {
        Hotel retorno = business.insert(hotel);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        business.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
