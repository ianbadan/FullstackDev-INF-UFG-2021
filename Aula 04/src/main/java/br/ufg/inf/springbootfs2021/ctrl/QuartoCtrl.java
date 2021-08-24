package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.business.QuartoBusiness;
import br.ufg.inf.springbootfs2021.entities.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "quartos")
public class QuartoCtrl {
    @Autowired
    QuartoBusiness business;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        List<Quarto> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Integer id) {
        Quarto retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Quarto> insert(@RequestBody Quarto quarto) {
        Quarto retorno = business.insert(quarto);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity<Quarto> update(@RequestBody Quarto quarto) {
        Quarto retorno = business.insert(quarto);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        business.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
