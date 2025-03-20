package br.com.example.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.example.api.models.Pessoa;
import br.com.example.api.repositorio.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class Controller {
    @Autowired
    private Repositorio repositorio;

    @GetMapping("")
    public String getMethodName() {
        return "ui";
    }
    
    @GetMapping("/api/{nome}")
    public String hello(@PathVariable String nome) {
        return "ola, "+nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoa) {        
        return pessoa;
    }
    
    
    @PostMapping("/cad")
    public Pessoa cad(@RequestBody Pessoa pessoa) {
        repositorio.save(pessoa);
        
        return pessoa;
    }


    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("index");
        List<Pessoa> lista = (List<Pessoa>) repositorio.findAll(); 
        mv.addObject("pessoas", lista);
        return mv;
    }

    
    
    
    
    
    
}
