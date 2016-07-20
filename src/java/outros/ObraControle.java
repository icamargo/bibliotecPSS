/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import outros.ObraDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "obraControl")
@SessionScoped
public class ObraControle {

    /**
     * Creates a new instance of obraControle
     */
    
    private Obra obra = new Obra() {};
    private Livro livro = new Livro();
    private final ObraDAO obraDAO = new ObraDAO();
    private List<Obra> listaObras;
    
    public ObraControle() {
    }
    public String cadastro(){
        return "cadastrarObra";
    }

    public String adicionarObra(){
        obraDAO.addObra(livro);
        return "interfaceUsuario";
    }
    
    public String removerObra(Obra ob){
        obra = ob;
        obraDAO.removeObra(obra);
        return "index";
    }
    
    public List listarObras(){
        listaObras = obraDAO.getList();
        return this.listaObras;
    }
    
    public String carregarObra(Obra ob){
        obra = ob;
        return "editar";
    }
    
    public String atualizarObra(){
        obraDAO.updateObra(obra);
        return "index";
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Obra getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    
}
