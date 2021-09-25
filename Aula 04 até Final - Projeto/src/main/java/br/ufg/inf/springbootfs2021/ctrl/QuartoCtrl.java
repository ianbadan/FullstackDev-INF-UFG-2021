package br.ufg.inf.springbootfs2021.ctrl;

import br.ufg.inf.springbootfs2021.Messages;
import br.ufg.inf.springbootfs2021.business.HotelBusiness;
import br.ufg.inf.springbootfs2021.business.QuartoBusiness;

import br.ufg.inf.springbootfs2021.entities.Quarto;
import br.ufg.inf.springbootfs2021.enums.CategoriaQuarto;
import br.ufg.inf.springbootfs2021.exceptions.QuartoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "quartos")
public class QuartoCtrl {
    @Autowired
    QuartoBusiness business;

    @Autowired
    HotelBusiness hotelBusiness;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        List<Quarto> list = new ArrayList<Quarto>();
        try{
            list = business.findAll();
            if(list.size() == 0){
                headers.add("message", Messages.get("0207"));
            }
        } catch ( Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Integer id) {
        Quarto retorno = new Quarto();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            retorno = business.findById(id);
            if(retorno == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<Quarto>(retorno, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Quarto> insert(@RequestBody Quarto quarto) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;

        try{
            quarto = business.insert(quarto);
            headers.add("message", Messages.get("0201"));
        } catch (QuartoException e){
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e){
            headers.add("message", Messages.get("0202"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<Quarto>(quarto, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Quarto> update(@RequestBody Quarto quarto) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try {
            quarto = business.update(quarto);
            headers.add("message", Messages.get("0203"));
        } catch (QuartoException e){
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e){
            headers.add("message", Messages.get("0204"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Quarto>(quarto, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try {
            business.delete(id);
            headers.add("message", Messages.get("0205"));
        } catch (Exception e) {
            headers.add("message", Messages.get("0206"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Void>(headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/categoriaquarto/{id}")
    public ResponseEntity<List<Quarto>> findByCategoriaQuarto(@PathVariable Integer id) {
        List<Quarto> list = new ArrayList<Quarto>();
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByCategoriaQuarto(CategoriaQuarto.get(id));
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/qtdleitos/{qtd}")
    public ResponseEntity<List<Quarto>> findByQtdLeito(@PathVariable Integer qtd) {
        List<Quarto> list = new ArrayList<Quarto>();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByQtdLeito(qtd);
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/nrquarto/{nrQuarto}")
    public ResponseEntity<List<Quarto>> findByNumeroQuarto(@PathVariable Integer nrQuarto) {
        List<Quarto> list = new ArrayList<Quarto>();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByNumeroQuarto(nrQuarto);
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/precodiaria/{precoDiaria}")
    public ResponseEntity<List<Quarto>> findByPrecoDiaria(@PathVariable Double precoDiaria) {
        List<Quarto> list = new ArrayList<Quarto>();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByPrecoDiaria(precoDiaria);
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/intervalopreco/{precoMinimo}/{precoMaximo}")
    public ResponseEntity<List<Quarto>> findByIntervaloPrecoDiaria(@PathVariable Double precoMinimo, @PathVariable Double precoMaximo) {
        List<Quarto> list = new ArrayList<Quarto>();

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByIntervaloPrecoDiaria(precoMinimo, precoMaximo);
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/idhotel/{id}")
    public ResponseEntity<List<Quarto>> findByIdHotel(@PathVariable Integer id) {
        List<Quarto> list = new ArrayList<Quarto>();
        System.out.println("Começando");
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try{
            list = business.findByIdHotel(hotelBusiness.findById(id));
            if(list == null){
                headers.add("message", Messages.get("0207"));
            }
        } catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }

        return new ResponseEntity<List<Quarto>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/paginator")
    public ResponseEntity<Page<Quarto>> paginator(Pageable pageable){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Quarto> list = null;
        try {
            list = business.paginator(pageable);
            if(list.getSize() == 0) {
                headers.add("message", Messages.get("0107"));
            }
        }catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Page<Quarto>>(list, headers, status);
    }


}
