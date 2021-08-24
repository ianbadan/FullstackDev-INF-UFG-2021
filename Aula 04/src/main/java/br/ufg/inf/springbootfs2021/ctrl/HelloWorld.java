package br.ufg.inf.springbootfs2021.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "inicio")
public class HelloWorld {

    @GetMapping
    public String inicio(){
        return "Hello World";
    }
}
