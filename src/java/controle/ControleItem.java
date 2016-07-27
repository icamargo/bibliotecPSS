package controle;
//@author igor_

import DAO.ItemDAO;
import entidade.AcademicoPrototype;
import entidade.ItemPrototype;
import entidade.LivroPrototype;
import entidade.PeriodicoPrototype;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "controleItem")
@SessionScoped
public class ControleItem {
    public static final int SEM_FILTRO = 0;
    public static final int FILTRO_TIPO_NOME_AUTOR = 1;
    public static final int FILTRO_TIPO_NOME = 2;
    public static final int FILTRO_TIPO_AUTOR = 3;
    public static final int FILTRO_TIPO = 4;
    public static final int FILTRO_NOME_AUTOR = 5;
    public static final int FILTRO_NOME = 6;
    public static final int FILTRO_AUTOR = 7;
    
    private LivroPrototype livro = new LivroPrototype();
    private AcademicoPrototype academico = new AcademicoPrototype();
    private PeriodicoPrototype periodico = new PeriodicoPrototype();
    
    private LivroPrototype prototipoLivro = new LivroPrototype();
    private AcademicoPrototype prototipoAcademico = new AcademicoPrototype();
    private PeriodicoPrototype prototipoPeriodico = new PeriodicoPrototype();
    
    private String filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo;
    
    private final ItemDAO itemDAO = new ItemDAO();
    private List itens;
    
    public ControleItem(){
    }
    public String adicionarLivro(){
        ItemPrototype livroNovo = prototipoLivro.clonar();
        livroNovo = livro;
        livroNovo.setStatus("Disponível");
        itemDAO.add(livroNovo);
        return "index";
    }
    public String adicionarAcademico(){
        ItemPrototype academicoNovo = prototipoAcademico.clonar();
        academicoNovo = academico;
        academicoNovo.setStatus("Disponível");
        itemDAO.add(academicoNovo);
        return "index";
    }
    public String adicionarPeriodico(){
        ItemPrototype periodicoNovo = prototipoPeriodico.clonar();
        periodicoNovo = periodico;
        periodicoNovo.setStatus("Disponível");
        itemDAO.add(periodicoNovo);
        return "index";
    }
    public List listarItens(){
        int intVlrFiltroNumCatalogo;
        
        if(!(filtroNumCatalogo.equals(""))){
            //filtra por numero catalogo
            intVlrFiltroNumCatalogo = Integer.parseInt(filtroNumCatalogo);
            itens = itemDAO.getItem(intVlrFiltroNumCatalogo);
        }
        else if(!(filtroTipo.equals(""))){
            if(!(filtroNome.equals(""))){
                if(!(filtroAutor.equals(""))){
                    //filtra por tipo, nome e autor
                    itens = itemDAO.getLista(FILTRO_TIPO_NOME_AUTOR, filtroNome, filtroAutor, filtroTipo);
                }
                else{
                    //filtra por tipo e por nome
                    itens = itemDAO.getLista(FILTRO_TIPO_NOME, filtroNome, filtroAutor, filtroTipo);
                }
            }
            else if(!(filtroAutor.equals(""))){
                //filtra por tipo e autor
                itens = itemDAO.getLista(FILTRO_TIPO_AUTOR, filtroNome, filtroAutor, filtroTipo);
            }
            else{
                //filtra por tipo
                itens = itemDAO.getLista(FILTRO_TIPO, filtroNome, filtroAutor, filtroTipo);
            }
        }
        else if(!(filtroNome.equals(""))){
            if(!(filtroAutor.equals(""))){
                //filtra por nome e autor
                itens = itemDAO.getLista(FILTRO_NOME_AUTOR, filtroNome, filtroAutor, filtroTipo);
            }
            else {
                //filtra por nome
                itens = itemDAO.getLista(FILTRO_NOME, filtroNome, filtroAutor, filtroTipo);
            }
        }
        else if(!(filtroAutor.equals(""))){
            //filtra por autor
            itens = itemDAO.getLista(FILTRO_AUTOR, filtroNome, filtroAutor, filtroTipo);
        }
        else {
            //não filtra por nada
            itens = itemDAO.getLista(SEM_FILTRO, filtroNome, filtroAutor, filtroTipo);
        }
        //não tem itens cadastrados
        if (itens == null) {
            itens = new DAO.ItemDAO().getLista(SEM_FILTRO, filtroNome, filtroAutor, filtroTipo);
        }
        return itens;
    }
    public String exibirItem(ItemPrototype item){
        String tipoItem;
        int numCatalogo = item.getNumeroCatalogo();
        
        tipoItem = itemDAO.getTipoItem(numCatalogo);
        switch(tipoItem){
            case "Livro":
                this.livro = (LivroPrototype) item;
                return "exibirLivro";
            case "Periodico":
                this.periodico = (PeriodicoPrototype) item;
                return "exibirPeriodico";
            case "Academico":
                this.academico = (AcademicoPrototype) item;
                return "exibirAcademico";
        }
        return "";
    }
    public LivroPrototype getLivro() {
        return livro;
    }

    public AcademicoPrototype getAcademico() {
        return academico;
    }

    public PeriodicoPrototype getPeriodico() {
        return periodico;
    }

    public String getFiltroNome() {
        return filtroNome;
    }

    public void setFiltroNome(String filtroNome) {
        this.filtroNome = filtroNome;
    }

    public String getFiltroNumCatalogo() {
        return filtroNumCatalogo;
    }

    public void setFiltroNumCatalogo(String filtroNumCatalogo) {
        this.filtroNumCatalogo = filtroNumCatalogo;
    }

    public String getFiltroAutor() {
        return filtroAutor;
    }

    public void setFiltroAutor(String filtroAutor) {
        this.filtroAutor = filtroAutor;
    }

    public List getItens() {
        return itens;
    }

    public void setItens(List itens) {
        this.itens = itens;
    }

    public String getFiltroTipo() {
        return filtroTipo;
    }

    public void setFiltroTipo(String filtroTipo) {
        this.filtroTipo = filtroTipo;
    }
    
    
}
