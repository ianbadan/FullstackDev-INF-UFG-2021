package br.ufg.inf.springbootfs2021.ctrl;



import br.ufg.inf.springbootfs2021.business.HospedagemBusiness;
import br.ufg.inf.springbootfs2021.business.HospedeBusiness;
import br.ufg.inf.springbootfs2021.business.QuartoBusiness;
import br.ufg.inf.springbootfs2021.entities.Hospedagem;
import br.ufg.inf.springbootfs2021.exceptions.HospedagemException;
import br.ufg.inf.springbootfs2021.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "hospedagens")
public class HospedagemCtrl {
    @Autowired
    HospedagemBusiness business;

    @Autowired
    HospedeBusiness hospedeBusiness;

    @Autowired
    QuartoBusiness quartoBusiness;

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findAll();
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        Hospedagem retorno = new Hospedagem();
        try{
            retorno = business.findById(id);
            if(retorno == null) {
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Hospedagem>(retorno, headers, status);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;
        try{
            hospedagem = business.insert(hospedagem);
            headers.add("message", Messages.get("0401"));
        } catch (HospedagemException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0402"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            hospedagem = business.update(hospedagem);
            headers.add("message", Messages.get("0403"));
        } catch (HospedagemException e) {
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            headers.add("message", Messages.get("0404"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            business.delete(id);
            headers.add("message", Messages.get("0405"));
        } catch (Exception e){
            headers.add("message", Messages.get("0406"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Void>(headers,status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/quarto/{id}")
    public ResponseEntity<List<Hospedagem>> findByIdQuarto(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findByIdQuarto(quartoBusiness.findById(id));
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/hospede/{id}")
    public ResponseEntity<List<Hospedagem>> findByIdHospede(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findByIdHospede(hospedeBusiness.findById(id));
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/checkin/{str}")
    public ResponseEntity<List<Hospedagem>> findByDataCheckin(@PathVariable String str){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findByDataCheckin(LocalDate.parse(str));
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/checkout/{str}")
    public ResponseEntity<List<Hospedagem>> findByDataCheckout(@PathVariable String str){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findByDataCheckout(LocalDate.parse(str));
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/paginator")
    public ResponseEntity<Page<Hospedagem>> paginator(Pageable pageable){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Hospedagem> list = null;
        try {
            list = business.paginator(pageable);
            if(list.getSize() == 0) {
                headers.add("message", Messages.get("0107"));
            }
        }catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Page<Hospedagem>>(list, headers, status);
    }

}
