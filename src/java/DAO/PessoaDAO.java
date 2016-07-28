/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.jsse.openssl.Authentication;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
//feito por pedro
public class PessoaDAO {

    private Session session;
    private Transaction trans;
    private List<Usuario> list;

    public List<Usuario> getList() {
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Criteria cri = session.createCriteria(Usuario.class);
        this.list = cri.list();
        return list;
    }

    public Usuario buscarU(Usuario u) {
        session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Usuario u where email=:email and senha=:pass";
        Query query = session.createQuery(sql);
        query.setString("email", u.getEmail());
        query.setString("pass", u.getSenha());
        return (Usuario) query.uniqueResult();
    }

    public void addUsuario(Usuario u) {
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.save(u);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com sucesso."));
        trans.commit();
    }

    public void removePessoa(Usuario user) {
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.delete(user);
        trans.commit();//confirmaçao

    }

    public void updatePessoa(Usuario user) {
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        session.update(user);
        trans.commit();//confirmaçao

    }

}
