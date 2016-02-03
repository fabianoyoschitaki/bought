package br.com.bought.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bought.model.AtivacaoCadastroUsuario;
import br.com.bought.model.Usuario;

public class AtivacaoCadastroUsuarioDAOImpl implements AtivacaoCadastroUsuarioDAO{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSession(){
		if(sessionFactory == null){
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		
		if(sessionFactory.isClosed()){
			sessionFactory.openSession();
		}
		return sessionFactory;
	}
	
	public Long salvar(AtivacaoCadastroUsuario ativacaoCadastroUsuario){
		Session session = null;
		Long retorno = null;
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
			retorno = (Long) session.save(ativacaoCadastroUsuario);
			session.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return retorno;
	}
	
	public AtivacaoCadastroUsuario obterAtivacaoCadastroPorUsuario(Usuario usuario) {
		AtivacaoCadastroUsuario retorno = null;		
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
		    Query query = session.createQuery("From AtivacaoCadastroUsuario a where  a.usuario.id = :id");
		    query.setParameter("id", usuario.getId());
		    retorno = (AtivacaoCadastroUsuario) query.uniqueResult();
		    session.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return retorno;
	}

	public AtivacaoCadastroUsuario obterAtivacaoCadastroUsuarioPorChave(
			String chaveConfirmacao) {
		AtivacaoCadastroUsuario retorno = null;
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
		    Query query = session.createQuery("From AtivacaoCadastroUsuario a where  a.chaveConfirmacao = :chaveConfirmacao");
		    query.setParameter("chaveConfirmacao", chaveConfirmacao);
		    retorno = (AtivacaoCadastroUsuario) query.uniqueResult();
		    session.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return retorno;
	}
}