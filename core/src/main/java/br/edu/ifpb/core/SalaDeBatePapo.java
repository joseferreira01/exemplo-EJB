/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core;

import br.edu.ifpb.shared.MensagemSingoton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

/**
 *
 * @author jose
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.WRITE)
@Remote(MensagemSingoton.class)
public class SalaDeBatePapo implements MensagemSingoton{
    private List<String> lista = new ArrayList<>();

    @Override
    public void add(String msg) {
        lista.add(msg);
    }

    @Override
    public void remover(String msg) {
       lista.remove(msg);
    }

    @Override
    @Lock(LockType.WRITE)
    public List<String> historico() {
       return Collections.unmodifiableList(lista);
    }
    
}
