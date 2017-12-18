/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

import java.util.List;

/**
 *
 * @author jose
 */
public interface Carrinho {

    public void add(String produto);

    public void remover(String produto);

    public void finalizar();
    
    public List<String> todosProdutos();
}
       
