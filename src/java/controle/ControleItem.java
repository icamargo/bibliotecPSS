package controle;
//@author igor_

import DAO.ItemDAO;
import entidade.ItemPrototype;
import entidade.LivroPrototype;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "controleItem")
@SessionScoped
public class ControleItem {
    
    public ControleItem(){
    }
    private LivroPrototype livro = new LivroPrototype();
    private final ItemDAO itemDAO = new ItemDAO();
    private List listaLivros;
    LivroPrototype prototipoLivro = new LivroPrototype();
    
    public String adicionarLivro(){
        ItemPrototype livroNovo = prototipoLivro.clonar();
        livroNovo = livro;
        itemDAO.add(livroNovo);
        return "index";
    }
    public LivroPrototype getLivro() {
        return livro;
    }
}
