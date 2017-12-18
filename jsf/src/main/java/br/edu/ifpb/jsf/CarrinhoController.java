/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jsf;

import br.edu.ifpb.shared.Carrinho;
import br.edu.ifpb.shared.ServiceLocator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@Named
@SessionScoped
public class CarrinhoController implements Serializable{

    private String produto;
    @EJB
    private Carrinho carrinhoOnline;
    private ServiceLocator locator;

    @PostConstruct
    public void init() {
        this.locator = new ServiceLocator();
        carrinhoOnline = locator
                .lookup("java:global/core/CarrinhoOnline", Carrinho.class);
        carrinhoOnline.add("tv");
        carrinhoOnline.add("cama");
        carrinhoOnline.add("mesa");
      

    }

    public String add() {
        carrinhoOnline.add(produto);
        produto = "";
        return null;
    }

    public String remover(String produto) {
        carrinhoOnline.remover(produto);
        return null;
    }

    public String finalizar() {
        carrinhoOnline.finalizar();
        encerrarSessao();
        return "index.xhtml?faces-redirect=true";
    }

    public List<String> todosProdutos() {
        return carrinhoOnline.todosProdutos();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }
}
