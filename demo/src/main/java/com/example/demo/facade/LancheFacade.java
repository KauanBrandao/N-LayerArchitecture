package com.example.demo.facade;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;

import java.util.List;

public class LancheFacade {
    private LancheApplication lancheApplication;

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

    public Lanche atualizar(int codigo, Lanche lanche, String novaImagem) {
        lancheApplication.atualizarLanche(codigo, lanche, novaImagem);
        return lanche;
    }

    public void excluir(int codigo) {
        lancheApplication.excluirLanche(codigo);
    }
}
