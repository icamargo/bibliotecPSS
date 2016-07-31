/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PessoaDAO;
import entidade.UsuarioPrototype;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pedro
 */
@ManagedBean
@SessionScoped
public class LoginControle {
    
    private UsuarioPrototype usuario;

    public LoginControle(){}
    
    public void login(){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        String pag;
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        usuario = pessoaDAO.buscarU(usuario);
        
        if (usuario != null) {
            loggedIn = true;
            pag = "index.xhtml";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", "Usuario");
        } else {
            loggedIn = false;
            pag = "login.xhtml";
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
       
    }

    public UsuarioPrototype getUsuario() {
        if (usuario == null) {
            usuario = new UsuarioPrototype();
        }
        return usuario;
    }

    public void setUsuario(UsuarioPrototype usuario) {
        this.usuario = usuario;
    }
}
