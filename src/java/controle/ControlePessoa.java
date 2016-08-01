/**
 *
 * @author Pedro
 */
package controle;

import DAO.PessoaDAO;
import static controle.ControleItem.FILTRO_NOME;
import static controle.ControleItem.FILTRO_TIPO;
import static controle.ControleItem.FILTRO_TIPO_NOME;
import static controle.ControleItem.SEM_FILTRO;
import entidade.BalconistaPrototype;
import entidade.BibliotecarioPrototype;
import entidade.PessoaPrototype;
import entidade.UsuarioPrototype;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "controlePessoa")
@SessionScoped
public class ControlePessoa {
    private UsuarioPrototype usuario = new UsuarioPrototype();
    private BalconistaPrototype balconista = new BalconistaPrototype();
    private BibliotecarioPrototype bibliotecario = new BibliotecarioPrototype();
    
    private UsuarioPrototype prototipoUsuario = new UsuarioPrototype();
    private BalconistaPrototype prototipoBalconista = new BalconistaPrototype();
    private BibliotecarioPrototype prototipoBibliotecario = new BibliotecarioPrototype();
    
    private String filtroNome, filtroCodigo, filtroCpf, filtroRg, filtroTipo;
    
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private List pessoas;
    
    public ControlePessoa() {
    }
    
    public void adicionarUsuario() throws IOException {
        PessoaPrototype usuarioNovo = prototipoUsuario.clonar();
        usuarioNovo = usuario;
        pessoaDAO.add(usuarioNovo);
    }
    
    public void adicionarBalconista() throws IOException{
        PessoaPrototype balconistaNovo = prototipoBalconista.clonar();
        balconistaNovo = balconista;
        pessoaDAO.add(balconistaNovo);
    }
    
    public void adicionarBibliotecario() throws IOException{
        PessoaPrototype bibliotecarioNovo = prototipoBibliotecario.clonar();
        bibliotecarioNovo = bibliotecario;
        pessoaDAO.add(bibliotecarioNovo);
    }
    
    public List listarPessoas() {
        int vlrFiltroCodigo;
        
        if(!(filtroCodigo.equals(""))){
            //filtra por codigo
            vlrFiltroCodigo = Integer.parseInt(filtroCodigo);
            pessoas = pessoaDAO.getPessoaPorCodigo(vlrFiltroCodigo);
        }
        else if(!(filtroCpf.equals(""))){
            //filtra por cpf
            pessoas = pessoaDAO.getPessoaPorCpf(filtroCpf);
        }
        else if(!(filtroRg.equals(""))){
            //filtra por rg
            pessoas = pessoaDAO.getPessoaPorRg(filtroRg);
        }
        else if(!(filtroTipo.equals(""))){
            if(!(filtroNome.equals(""))){
                //filtra por tipo e por nome
                pessoas = pessoaDAO.getPessoas(FILTRO_TIPO_NOME, filtroTipo, filtroNome);
            }
            else{
                //filtra por tipo
                pessoas = pessoaDAO.getPessoas(FILTRO_TIPO, filtroTipo, filtroNome);
            }
        }
        else if(!(filtroNome.equals(""))){
            //filtra por nome
            pessoas = pessoaDAO.getPessoas(FILTRO_NOME, filtroTipo, filtroNome);
        }
        else {
            //não filtra por nada
            pessoas = pessoaDAO.getPessoas(SEM_FILTRO, filtroTipo, filtroNome);
        }
        //não tem pessoas cadastrados
        if (pessoas == null) {
            pessoas = new DAO.PessoaDAO().getPessoas(SEM_FILTRO, filtroTipo, filtroNome);
        }
        return pessoas;
    }

    public void exibirPessoa(PessoaPrototype pessoa) throws IOException{
        String tipoPessoa;
        
        tipoPessoa = pessoa.getTipoPessoa();
        switch(tipoPessoa){
            case "Balconista":
                this.balconista = (BalconistaPrototype) pessoa;
                FacesContext.getCurrentInstance().getExternalContext().redirect("exibirBalconista.xhtml");
                break;
            case "Bibliotecario":
                this.bibliotecario = (BibliotecarioPrototype) pessoa;
                FacesContext.getCurrentInstance().getExternalContext().redirect("exibirBibliotecario.xhtml");
                break;
            case "Usuario":
                this.usuario = (UsuarioPrototype) pessoa;
                FacesContext.getCurrentInstance().getExternalContext().redirect("exibirUsuario.xhtml");
                break;
        }
    }
    
    public void inativarBalconista() throws IOException{
        balconista.setAtivo(false);
        pessoaDAO.atualizarPessoa(balconista);
        FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciarPessoas.xhtml");
    }
    
    public void inativarBibliotecario() throws IOException{
        bibliotecario.setAtivo(false);
        pessoaDAO.atualizarPessoa(bibliotecario);
        FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciarPessoas.xhtml");
    }
    
    public void inativarUsuario() throws IOException{
        if(usuario.isAtivo()==true){
            usuario.setAtivo(false);
        }
        else{
            usuario.setAtivo(true);
        }
        pessoaDAO.atualizarPessoa(usuario);
        FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciarPessoas.xhtml");
    }
    
    public void atualizarBalconista() throws IOException{
        pessoaDAO.atualizarPessoa(balconista);
    }
    
    public void atualizarBibliotecario() throws IOException{
        pessoaDAO.atualizarPessoa(bibliotecario);
    }
    
    public void atualizarUsuario() throws IOException{
        pessoaDAO.atualizarPessoa(usuario);
    }

    public UsuarioPrototype getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPrototype usuario) {
        this.usuario = usuario;
    }

    public BalconistaPrototype getBalconista() {
        return balconista;
    }

    public void setBalconista(BalconistaPrototype balconista) {
        this.balconista = balconista;
    }

    public BibliotecarioPrototype getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(BibliotecarioPrototype bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public List getPessoas() {
        return pessoas;
    }

    public void setPessoas(List pessoas) {
        this.pessoas = pessoas;
    }

    public String getFiltroNome() {
        return filtroNome;
    }

    public void setFiltroNome(String filtroNome) {
        this.filtroNome = filtroNome;
    }

    public String getFiltroCodigo() {
        return filtroCodigo;
    }

    public void setFiltroCodigo(String filtroCodigo) {
        this.filtroCodigo = filtroCodigo;
    }

    public String getFiltroCpf() {
        return filtroCpf;
    }

    public void setFiltroCpf(String filtroCpf) {
        this.filtroCpf = filtroCpf;
    }

    public String getFiltroRg() {
        return filtroRg;
    }

    public void setFiltroRg(String filtroRg) {
        this.filtroRg = filtroRg;
    }

    public String getFiltroTipo() {
        return filtroTipo;
    }

    public void setFiltroTipo(String filtroTipo) {
        this.filtroTipo = filtroTipo;
    }   
}
