/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jsf;

import br.edu.ifpb.shared.Calculadora;
import br.edu.ifpb.shared.ServiceLocator;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class CalculadoraController {
    private int x;
    private int y;
    private int resultado;
    private ServiceLocator locator;
    private Calculadora calculadora;
    @PostConstruct
    public void init(){
        this.locator = new ServiceLocator();
    }
    public String somar(){
        this.calculadora = locator.
                lookup("java:global/core/CalculadoraImpl", Calculadora.class);
        this.resultado = calculadora.somar(x, y);
        return null;
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}

