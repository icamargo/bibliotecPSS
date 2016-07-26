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
    
    LivroPrototype prototipoLivro = new LivroPrototype();
    AcademicoPrototype prototipoAcademico = new AcademicoPrototype();
    PeriodicoPrototype prototipoPeriodico = new PeriodicoPrototype();
    
    private String filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo;
    
    private final ItemDAO itemDAO = new ItemDAO();
    private List itens;
    
    public ControleItem(){
    }
    public String adicionarLivro(){
        ItemPrototype livroNovo = prototipoLivro.clonar();
        livroNovo = livro;
        itemDAO.add(livroNovo);
        return "index";
    }
    public String adicionarAcademico(){
        ItemPrototype academicoNovo = prototipoAcademico.clonar();
        academicoNovo = academico;
        itemDAO.add(academicoNovo);
        return "index";
    }
    public String adicionarPeriodico(){
        ItemPrototype periodicoNovo = prototipoPeriodico.clonar();
        periodicoNovo = periodico;
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
        
        
        
        
        
        
        /*
        if (!(filtroTipo.equals(""))) {
            if (!(filtroNome.equals(""))) {
                if (!(filtroNumCatalogo.equals(""))) {
                    if (!(filtroAutor.equals(""))) {
                        //filtrar por tudo
                        itens = itemDAO.getLista(TODOS_FILTROS, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
                    } else {
                        //senao filtrar por tipo, nome e num catalogo
                        itens = itemDAO.getLista(FILTRO_TIPO_NOME_NUMCATALOGO, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
                    }
                } else {
                    //filtra por tipo e nome
                    itens = itemDAO.getLista(FILTRO_TIPO_NOME, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
                }
            } else {
                //filtra por tipo
                itens = itemDAO.getLista(FILTRO_TIPO, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
            }
        } else if (!(filtroNome.equals(""))) {
            if (!(filtroNumCatalogo.equals(""))) {
                if (!(filtroAutor.equals(""))) {
                    //filtra por nome, numero de catalogo e autor
                    itens = itemDAO.getLista(FILTRO_NOME_NUMCATALOGO_AUTOR, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
                } else {
                    //filtra por nome e numero de catalogo
                    itens = itemDAO.getLista(FILTRO_NOME_NUMCATALOGO, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
                }
            } else {
                //filtra por nome
                itens = itemDAO.getLista(FILTRO_NOME, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
            }
        } else if (!(filtroNumCatalogo.equals(""))) {
            if (!(filtroAutor.equals(""))) {
                //filtra por numero de catalogo e autor
                itens = itemDAO.getLista(FILTRO_NUMCATALOGO_AUTOR, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
            } else {
                //filtra por num de catalogo
                itens = itemDAO.getLista(FILTRO_NUMCATALOGO, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
            }
        } else if (!(filtroAutor.equals(""))) {
            //filtra por autor
            itens = itemDAO.getLista(FILTRO_AUTOR, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
        } else {
            //não filtra por nada
            itens = itemDAO.getLista(SEM_FILTRO, filtroNome, filtroNumCatalogo, filtroAutor, filtroTipo);
        }*/
        
        //não tem itens cadastrados
        //itens = itemDAO.getLista();
        if (itens == null) {
            itens = new DAO.ItemDAO().getLista(SEM_FILTRO, filtroNome, filtroAutor, filtroTipo);
        }
        
        return itens;
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
