/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jsf;

import br.edu.ifpb.shared.Carrinho;
import br.edu.ifpb.shared.MensagemSingoton;
import br.edu.ifpb.shared.ServiceLocator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class MensagensController {

    private String mensagem;
    private MensagemSingoton mensagems;
    private ServiceLocator locator;

    @PostConstruct
    public void init() {
        this.locator = new ServiceLocator();
        mensagems = locator
                .lookup("java:global/core/SalaDeBatePapo", MensagemSingoton.class);

    }
     public String add(){
         mensagems.add(mensagem);
         mensagem = ""; 
         return null;
     }
    public void remover(String msg){
        mensagems.remover(msg);
    }
    public List<String> historico(){
        return mensagems.historico();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
