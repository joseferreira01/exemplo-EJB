/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core;

import br.edu.ifpb.shared.Carrinho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author jose
 */
@Stateful
@Remote(Carrinho.class)
public class CarrinhoOnline implements Carrinho {

    private List<String> produtos;

    public CarrinhoOnline() {
    }

    @PostConstruct
    public void init() {
        this.produtos = new ArrayList<>();
       
    }

    @Override
    public void add(String produto) {
        System.err.println(produto+": adicionado");
        this.produtos.add(produto);
    }

    @Override
    public void remover(String produto) {
        this.produtos.remove(produto);
        System.err.println("removendo: "+produto);
    }

    @Override
    @Remove
    public void finalizar() {
        this.produtos.clear();
        System.err.println("-- Carrinho finalizado");
    }

    @Override
    public List<String> todosProdutos() {
        System.err.println("listadondo produtos"+produtos);
        //produtos.forEach(System.out::print());
        return Collections.unmodifiableList(produtos);
    }

}
