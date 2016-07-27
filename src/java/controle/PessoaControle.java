/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PessoaDAO;
import entidade.Usuario;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro
 */

//feita por pedro
@ManagedBean(name = "pessoaControl")
@SessionScoped
public class PessoaControle {

    /**
     * Creates a new instance of PessoaControl
     */
    public PessoaControle() {
    }
    
    private Usuario usuario = new Usuario();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private List listaUsuarios;

    
    public String adicionarUsuario(){
      pessoaDAO.addUsuario(usuario);
      usuario.setCpf(null);
      usuario.setDtNasc(null);
      usuario.setEmail(null);
      usuario.setEndereço(null);
      usuario.setNome(null);
      usuario.setRg(null);
      usuario.setTelefone(null);     
      return "login";
    }
    
    public String atualizarUsuario(){
      pessoaDAO.updatePessoa(usuario);
      usuario.setCpf(null);
      usuario.setDtNasc(null);
      usuario.setEmail(null);
      usuario.setEndereço(null);
      usuario.setNome(null);
      usuario.setRg(null);
      usuario.setTelefone(null);
      return "index";
    }
    
    public String removerUsuario(Usuario user){
        this.usuario = user;
        pessoaDAO.removePessoa(usuario);
        usuario.setCpf(null);
        usuario.setDtNasc(null);
        usuario.setEmail(null);
        usuario.setEndereço(null);
        usuario.setNome(null);
        usuario.setRg(null);
        usuario.setTelefone(null);
        return "index";
    }
    
    public List listarUsuarios(){
        listaUsuarios = pessoaDAO.getList();
        if(listaUsuarios == null){
            listaUsuarios = new DAO.PessoaDAO().getList();
        }
        
        return listaUsuarios;
    }
    
    public String carregarUsuario(Usuario user){
        this.usuario = user;
        return "editarUser";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaControle other = (PessoaControle) obj;
        return Objects.equals(this.usuario, other.usuario);
    }
}
