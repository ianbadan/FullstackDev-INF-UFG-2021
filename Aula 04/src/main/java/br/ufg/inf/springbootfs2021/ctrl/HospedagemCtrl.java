package br.ufg.inf.springbootfs2021.ctrl;



import br.ufg.inf.springbootfs2021.business.HospedagemBusiness;
import br.ufg.inf.springbootfs2021.entities.Hospedagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hospedagens")
public class HospedagemCtrl {
    @Autowired
    HospedagemBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll(){
        List<Hospedagem> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        Hospedagem retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        Hospedagem retorno = business.insert(hospedagem);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
        Hospedagem retorno = business.insert(hospedagem);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        business.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
