/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jse;

import br.edu.ifpb.shared.Carrinho;
import br.edu.ifpb.shared.ServiceLocator;
import java.util.List;

/**
 *
 * @author jose
 */
public class CarrinnhoService implements Carrinho {

    private Carrinho carrinho;
    private ServiceLocator locator;

    public CarrinnhoService() {
        this.locator = new ServiceLocator();
        carrinho = locator
                .lookup("java:global/core/CarrinhoOnline", Carrinho.class);
//        carrinho.add("tv");
//        carrinho.add("cama");
//        carrinho.add("mesa");
    }

    @Override
    public void add(String produto) {
        carrinho.add(produto);
    }

    @Override
    public void remover(String produto) {
        carrinho.remover(produto);
    }

    @Override
    public void finalizar() {
        carrinho.finalizar();
    }

    @Override
    public List<String> todosProdutos() {
        return carrinho.todosProdutos();
    }

}
