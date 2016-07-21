package DAO;
//@author igor_

import entidade.ItemPrototype;
import entidade.LivroPrototype;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class ItemDAO {
    private Session session;
    private Transaction trans;
    private List<LivroPrototype> list;
    
    public void add(ItemPrototype item){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.save(item);
        trans.commit();
    }
    
}
