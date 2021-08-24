package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.business.HospedeBusiness;
import br.ufg.inf.springbootfs2021.entities.Hospede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hospedes")
public class HospedeCtrl {

    @Autowired
    HospedeBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll(){
        List<Hospede> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        Hospede retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede) {
        Hospede retorno = business.insert(hospede);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede hospede) {
        Hospede retorno = business.insert(hospede);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        business.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
