/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PessoaDAO;
import entidade.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
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

    public void adicionarUsuario() throws IOException {
        pessoaDAO.addUsuario(usuario);
        usuario = new Usuario();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

    public void atualizarUsuario() throws IOException {
        pessoaDAO.updatePessoa(usuario);
        usuario = new Usuario();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void removerUsuario(Usuario user) throws IOException {
        this.usuario = user;
        pessoaDAO.removePessoa(usuario);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void inativarUsuario(Usuario user) {
        this.usuario = user;
        if (usuario.getSituaçao().equals("normal")) {
            usuario.setSituaçao("inativo");
        } else if (usuario.getSituaçao().equals("inativo")) {
            usuario.setSituaçao("normal");
        }
        pessoaDAO.updatePessoa(usuario);
        usuario = new Usuario();
    }

    public List listarUsuarios() {
        listaUsuarios = pessoaDAO.getList();
        if (listaUsuarios == null) {
            listaUsuarios = new DAO.PessoaDAO().getList();
        }

        return listaUsuarios;
    }

    public void carregarUsuario(Usuario user) throws IOException {
        this.usuario = user;
        FacesContext.getCurrentInstance().getExternalContext().redirect("editarUser.xhtml");
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
