/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class ObraDAO {
    
    private Session session;
    private Transaction trans;
    private List<Obra> list;
    
    public List<Obra> getList(){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Criteria cri = session.createCriteria(Obra.class);//classe ja compilada
        this.list = cri.list();
        return list;
    }

    /*public void addObra(Obra obra){
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            //Obra obra = new Obra();
            session.save(obra);
            trans.commit();//confirmaçao
    }*/
    
    public void removeObra(Obra obra){ 
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(obra);
            trans.commit();//confirmaçao
            
    }
    
    public void updateObra(Obra obra){
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.update(obra);
            trans.commit();//confirmaçao
            
    }

    public void addObra(Livro livro) {
        session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.save(livro);
            trans.commit();//confirmaçao
    }
}
