package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.Messages;
import br.ufg.inf.springbootfs2021.business.HospedeBusiness;
import br.ufg.inf.springbootfs2021.entities.Hospede;
import br.ufg.inf.springbootfs2021.exceptions.HospedeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "hospedes")
public class HospedeCtrl {

    @Autowired
    HospedeBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospede> list = new ArrayList<Hospede>();
        try{
           list = business.findAll();
           if(list.size() == 0){
               headers.add("message", Messages.get("0307"));
           }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Hospede>>(list, headers, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;


        Hospede retorno = new Hospede();
        try{
            retorno = business.findById(id);
            if(retorno == null){
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Hospede>(retorno, headers, status);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;


        Hospede retorno = new Hospede();
        try {
            retorno = business.insert(hospede);
            headers.add("message", Messages.get("0301"));
        } catch (HospedeException e){
            headers.add("message", Messages.get(e.getMessage()));
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0302"));
        }
        return new ResponseEntity<Hospede>(retorno, headers, status);
    }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede hospede) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Hospede retorno = new Hospede();
        try {
            retorno = business.update(hospede);
            headers.add("message", Messages.get("0303"));
        } catch (HospedeException e){
            headers.add("message", Messages.get(e.getMessage()));
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0304"));
        }

        return new ResponseEntity<Hospede>(retorno, headers, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try{
            business.delete(id);
            headers.add("message", Messages.get("0305"));
        } catch (Exception e) {
            headers.add("message", Messages.get("0306"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<Void>(headers, status);
    }

    @GetMapping("/nome/{nomeHospede}")
    public ResponseEntity<List<Hospede>> findByNomeHospede(@PathVariable String nomeHospede){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospede> list = new ArrayList<Hospede>();
        try{
            list = business.findByNomeHospede(nomeHospede);
            if(list.size() == 0){
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Hospede>>(list, headers, status);
    }

    @GetMapping("/dtnascimento/{str}")
    public ResponseEntity<List<Hospede>> findByDtNascimento(@PathVariable String str){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospede> list = new ArrayList<Hospede>();
        try{
            System.out.println("Começando:"  + LocalDate.parse(str));
            list = business.findByDtNascimento(LocalDate.parse(str));
            if(list.size() == 0){
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Hospede>>(list, headers, status);
    }

    @GetMapping("/cpf/{str}")
    public ResponseEntity<List<Hospede>> findByCPF(@PathVariable String str){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospede> list = new ArrayList<Hospede>();
        try{
            list = business.findByCPF(str);
            if(list.size() == 0){
                headers.add("message", Messages.get("0307"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Hospede>>(list, headers, status);
    }

}
