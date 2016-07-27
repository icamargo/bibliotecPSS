package DAO;
//@author igor_

import static controle.ControleItem.FILTRO_AUTOR;
import static controle.ControleItem.FILTRO_NOME;
import static controle.ControleItem.FILTRO_NOME_AUTOR;
import static controle.ControleItem.FILTRO_TIPO;
import static controle.ControleItem.FILTRO_TIPO_AUTOR;
import static controle.ControleItem.FILTRO_TIPO_NOME;
import static controle.ControleItem.FILTRO_TIPO_NOME_AUTOR;
import entidade.AcademicoPrototype;
import entidade.ItemPrototype;
import entidade.LivroPrototype;
import entidade.PeriodicoPrototype;
import java.util.List;
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
    
    public void add(ItemPrototype item){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.save(item);
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
            //sem filtro não faz nada
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
    public String getTipoItem(int numCatalogo){
        String tipoItem, consulta;
        
        consulta = "SELECT DTYPE FROM ITEM WHERE numeroCatalogo = :p";
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        tipoItem = session.createQuery(consulta).setParameter("p", numCatalogo).toString();
        return tipoItem;
    }
    
    
    
}
