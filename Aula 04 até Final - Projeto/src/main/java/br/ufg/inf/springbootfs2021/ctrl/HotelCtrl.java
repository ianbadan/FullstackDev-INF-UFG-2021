package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.business.HotelBusiness;
import br.ufg.inf.springbootfs2021.entities.Hotel;

import br.ufg.inf.springbootfs2021.exceptions.HotelException;
import br.ufg.inf.springbootfs2021.fs.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "hoteis")
public class HotelCtrl {

    @Autowired
    private HotelBusiness business;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hotel> list = new ArrayList<Hotel>();
        try{
            list = business.findAll();
            if(list.size() == 0){
                headers.add("message", Messages.get("0107"));
            }

        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hotel>>(list, headers, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Integer id) {
        Hotel retorno = new Hotel();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try {
            retorno = business.findById(id);
            if(retorno == null) {
                headers.add("message", Messages.get("0107"));
            }
        }catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Hotel>(retorno, headers, status);
    }

    @PostMapping
    public ResponseEntity<Hotel> insert(@RequestBody Hotel hotel) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;

        try {
            hotel = business.insert(hotel);
            headers.add("message", Messages.get("0101"));
        } catch (HotelException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0102"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hotel>(hotel, headers, status);
    }

    @PutMapping
    public ResponseEntity<Hotel> update(@RequestBody Hotel hotel) {

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try {
            hotel = business.update(hotel);
            headers.add("message", Messages.get("0103"));
        } catch (HotelException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0104"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hotel>(hotel, headers, status);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try {
            business.delete(id);
            headers.add("message", Messages.get("0105"));
        } catch (Exception e) {
            headers.add("message", Messages.get("0106"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Void>(headers, status);
    }

    @GetMapping("/nome/{str}")
    public ResponseEntity<List<Hotel>> findByNome(@PathVariable String str){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hotel> list = new ArrayList<Hotel>();
        try{
            list = business.findByNome(str);
            if(list.size() == 0){
                headers.add("message", Messages.get("0107"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hotel>>(list, headers, status);
    }

    @GetMapping("/endereco/{str}")
    public ResponseEntity<List<Hotel>> findByEndereco(@PathVariable String str) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hotel> list = new ArrayList<Hotel>();
        try {
            list = business.findByEndereco(str);
            if (list.size() == 0) {
                headers.add("message", Messages.get("0107"));
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hotel>>(list, headers, status);
    }

    @GetMapping("/estrela/{qtd}")
    public ResponseEntity<List<Hotel>> findByQtdEstrelas(@PathVariable Integer qtd){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hotel> list = new ArrayList<Hotel>();
        try {
            list = business.findByQtdEstrelas(qtd);
            if (list.size() == 0) {
                headers.add("message", Messages.get("0107"));
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hotel>>(list, headers, status);
    }


}
