/**
 *
 * @author Igor
 */
package DAO;

import static controle.ControleItem.FILTRO_AUTOR;
import static controle.ControleItem.FILTRO_NOME;
import static controle.ControleItem.FILTRO_NOME_AUTOR;
import static controle.ControleItem.FILTRO_TIPO;
import static controle.ControleItem.FILTRO_TIPO_AUTOR;
import static controle.ControleItem.FILTRO_TIPO_NOME;
import static controle.ControleItem.FILTRO_TIPO_NOME_AUTOR;
import static controle.ControleItem.SEM_FILTRO;
import entidade.AcademicoPrototype;
import entidade.ItemPrototype;
import entidade.LivroPrototype;
import entidade.PeriodicoPrototype;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

public class ItemDAO {
    private Session session;
    private Transaction trans;
    private List<ItemPrototype> lista;
    
    public void add(ItemPrototype item) throws IOException{
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.save(item);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("index.xhtml");
        context.addMessage(null, new FacesMessage("Item Cadastrado com Sucesso!"));
        trans.commit();
    }

    public List<ItemPrototype> getItem (int vlrFiltroNumCatalogo){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Criteria cri = session.createCriteria(ItemPrototype.class);
        cri.add(Restrictions.eq("numeroCatalogo", vlrFiltroNumCatalogo));
        this.lista = cri.list();
        return lista;
    }
    
    public List<ItemPrototype> getLista(int tipoFiltro, String vlrFiltroNome, String vlrFiltroAutor, String vlrFiltroTipo) {
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Criteria cri = session.createCriteria(ItemPrototype.class);
        switch(tipoFiltro){
            case SEM_FILTRO:
                //sem filtro não faz nada
                break;
            case FILTRO_TIPO_NOME_AUTOR:
                switch(vlrFiltroTipo){
                    case "Livro":
                        cri = session.createCriteria(LivroPrototype.class);
                        break;
                    case "Academico":
                        cri = session.createCriteria(AcademicoPrototype.class);
                        break;
                    case "Periodico":
                        cri = session.createCriteria(PeriodicoPrototype.class);
                        break;
                }
                cri.add(Restrictions.ilike("nome", vlrFiltroNome, MatchMode.ANYWHERE));
                cri.add(Restrictions.ilike("autor", vlrFiltroAutor, MatchMode.ANYWHERE));
                break;
            case FILTRO_TIPO_NOME:
                switch(vlrFiltroTipo){
                    case "Livro":
                        cri = session.createCriteria(LivroPrototype.class);
                        break;
                    case "Academico":
                        cri = session.createCriteria(AcademicoPrototype.class);
                        break;
                    case "Periodico":
                        cri = session.createCriteria(PeriodicoPrototype.class);
                        break;
                }
                cri.add(Restrictions.ilike("nome", vlrFiltroNome, MatchMode.ANYWHERE));
                break;
            case FILTRO_TIPO_AUTOR:
                switch(vlrFiltroTipo){
                    case "Livro":
                        cri = session.createCriteria(LivroPrototype.class);
                        break;
                    case "Academico":
                        cri = session.createCriteria(AcademicoPrototype.class);
                        break;
                    case "Periodico":
                        cri = session.createCriteria(PeriodicoPrototype.class);
                        break;
                }
                cri.add(Restrictions.ilike("autor", vlrFiltroAutor, MatchMode.ANYWHERE));
                break;
            case FILTRO_TIPO:
                switch(vlrFiltroTipo){
                    case "Livro":
                        cri = session.createCriteria(LivroPrototype.class);
                        break;
                    case "Academico":
                        cri = session.createCriteria(AcademicoPrototype.class);
                        break;
                    case "Periodico":
                        cri = session.createCriteria(PeriodicoPrototype.class);
                        break;
                }
                break;
            case FILTRO_NOME_AUTOR:
                cri.add(Restrictions.ilike("nome", vlrFiltroNome, MatchMode.ANYWHERE));
                cri.add(Restrictions.ilike("autor", vlrFiltroAutor, MatchMode.ANYWHERE));
                break;
            case FILTRO_NOME:
                cri.add(Restrictions.ilike("nome", vlrFiltroNome, MatchMode.ANYWHERE));
                break;
            case FILTRO_AUTOR:
                cri.add(Restrictions.ilike("autor", vlrFiltroAutor, MatchMode.ANYWHERE));
                break;                        
        }
        this.lista = cri.list();
        return lista;
    }
    
    public void atualizarItem (ItemPrototype item) throws IOException{
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.update(item);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Item Atualizado com Sucesso!"));
        context.getExternalContext().redirect("gerenciarItens.xhtml");
        trans.commit();//confirmaçao
    }

    
}
