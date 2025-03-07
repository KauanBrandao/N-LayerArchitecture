package com.example.demo.controller;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;
import com.example.demo.facade.LancheFacade;
import com.example.demo.repositories.LancheRepository;
import com.example.demo.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LancheController {

    private static LancheRepository lancheRepository;
    private static LancheService lancheService;
    private static LancheApplication lancheApplication;
    private static LancheFacade lancheFacade;

    private static void injetarDependencias() {
        lancheRepository = new LancheRepository();
        lancheService = new LancheService();
        lancheApplication = new LancheApplication(lancheService, lancheRepository);
        lancheFacade = new LancheFacade(lancheApplication);
    }

    public LancheController() {
        injetarDependencias();

        Lanche lanche1 = new Lanche(1, "X-tudo", 19.90, "");
        Lanche lanche2 = new Lanche(2, "X-cheddar", 19.90, "");
        Lanche lanche3 = new Lanche(3, "X-bacon", 19.90, "");

        this.lancheFacade.cadastrar(lanche1);
        this.lancheFacade.cadastrar(lanche2);
        this.lancheFacade.cadastrar(lanche3);
    }

    @GetMapping("/listar")
    public List<Lanche> get (){
        return lancheFacade.buscar();
    }

    @PostMapping("/cadastrar")
    public  Lanche cadastrar(@RequestBody Lanche lanche) {
        return lancheFacade.cadastrar(lanche);
    }

    @PutMapping("/atualizar/{codigo}")
    public Lanche atualizar(@PathVariable int codigo, @RequestBody Lanche lanche, @PathVariable String novaImagem) {
        return lancheFacade.atualizar(codigo, lanche, novaImagem);
    }

    @DeleteMapping("/deletar/{codigo}")
    public void remover(@PathVariable int codigo) {
        lancheFacade.excluir(codigo);
    }
}
