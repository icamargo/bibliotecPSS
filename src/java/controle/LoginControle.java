/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PessoaDAO;
import entidade.UsuarioPrototype;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginControle implements Serializable{
    
    private UsuarioPrototype usuario;

    public LoginControle(){
    }
    
    public String logar(){
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        usuario = pessoaDAO.buscarUsuario(usuario);
        
        if(usuario != null){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("usuario", usuario);
            
            return "/app/interfaceUsuario?faces-redirect=true";
        }
        else{
            return "/seguranca/login?faces-redirect=true";
        }
    }
    
    public String sair(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/seguranca/login?faces-redirect=true";
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
