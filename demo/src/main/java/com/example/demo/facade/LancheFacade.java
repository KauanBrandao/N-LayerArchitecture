package com.example.demo.facade;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LancheFacade {
    private LancheApplication lancheApplication;

    @Autowired
    public LancheFacade(LancheApplication lancheApplication) {
        this.lancheApplication = lancheApplication;
    }

    public Lanche cadastrar(Lanche lanche) {
        this.lancheApplication.cadastrar(lanche);
        return lanche;
    }

    public List<Lanche> buscar() {
        return this.lancheApplication.buscar();
    }

    public Lanche buscarPorCodigo(int codigo) {
        return this.lancheApplication.buscarPorCodigo(codigo);
    }

    public double calcularLanche(Lanche lanche, int quantidade) {
        return this.lancheApplication.calcularLanche(lanche, quantidade);
    }

    public Lanche atualizar(int codigo, Lanche lanche) {
        lancheApplication.atualizarLanche(codigo, lanche);
        return lanche;
    }

    public void excluir(int codigo) {
        lancheApplication.excluirLanche(codigo);
    }
}
