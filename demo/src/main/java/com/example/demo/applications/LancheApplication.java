package com.example.demo.applications;

import com.example.demo.entities.Lanche;
import com.example.demo.repositories.LancheRepository;
import com.example.demo.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LancheApplication {
    private LancheService lancheService;
    private LancheRepository lancheRepository;

    @Autowired
    public LancheApplication(
            LancheService lancheService,
            LancheRepository lancheRepository) {
        this.lancheService = lancheService;
        this.lancheRepository = lancheRepository;
    }

    public void cadastrar(Lanche lanche) {
        this.lancheRepository.adicionar(lanche);
        this.lancheService.salvar(lanche);
    }

    public List<Lanche> buscar() {
        return this.lancheRepository.buscar();
    }

    public Lanche buscarPorCodigo(int codigo) {
        return this.lancheRepository.buscarPorCodigo(codigo);
    }

    public double calcularLanche(Lanche lanche, int quantidade) {
        return lanche.getPreco() * quantidade;
    }

    public void atualizarLanche(int codigo, Lanche lanche) {
        this.lancheRepository.atualizar(codigo, lanche);
        this.lancheService.atualizar(codigo, lanche);
        this.lancheService.salvar(lanche);
    }


    public void excluirLanche(int codigo) {
        this.lancheRepository.remover(codigo);
    }
}
