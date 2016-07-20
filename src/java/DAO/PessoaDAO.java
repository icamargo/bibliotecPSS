/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.Usuario;
import java.util.List;
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
    
    public List<Usuario> getList(){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Criteria cri = session.createCriteria(Usuario.class);
        this.list = cri.list();
        return list;
    }
    
    public Usuario buscar(Usuario usuario){
        session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select u from Usuario u where email=:email and senha=:pass";
        Query query = session.createQuery(sql);
        query.setString("email", usuario.getEmail());
        query.setString("pass", usuario.getSenha());
        return (Usuario) query.uniqueResult();
    }
    
    public void addUsuario(Usuario u){
        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.beginTransaction();
        Usuario usuario = new Usuario();
        usuario.setNome(u.getNome());
        usuario.setCpf(u.getCpf());
        usuario.setDtNasc(u.getDtNasc());
        usuario.setEmail(u.getEmail());
        usuario.setEndereço(u.getEndereço());
        usuario.setSexo(u.getSexo());
        usuario.setId(u.getId());
        usuario.setRg(u.getRg());
        usuario.setSenha(u.getSenha());
        usuario.setSituaçao(u.getSituaçao());
        usuario.setTipo(u.getTipo());
        usuario.setTelefone(u.getTelefone());
        session.save(usuario);
        trans.commit();
    }
    
    public void removePessoa(Usuario user){ 
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(user);
            trans.commit();//confirmaçao
            
    }
    
    public void updatePessoa(Usuario user){
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.update(user);
            trans.commit();//confirmaçao
            
    }
    
}
