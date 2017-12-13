/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core;

import br.edu.ifpb.shared.Calculadora;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
@Remote(Calculadora.class)
public class CalculadoraImpl implements Calculadora{

    @Override
    public int somar(int x, int y) {
        return x+y;
    }
    
}
