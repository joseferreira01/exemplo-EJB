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
public interface MensagemSingoton {
    
    public void add(String msg);
    public void remover(String msg);
    public List<String> historico();
}
