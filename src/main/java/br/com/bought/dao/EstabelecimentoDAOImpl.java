package br.com.bought.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bought.model.Estabelecimento;

public class EstabelecimentoDAOImpl implements EstabelecimentoDAO{

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
	
	public Long salvar(Estabelecimento estabelecimento){
		Session session = null;
		Long retorno = null;
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
			retorno = (Long) session.save(estabelecimento);
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
	
	public Estabelecimento obterEstabelecimentoPorId(Long id) {
		Estabelecimento retorno = null;		
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
		    Query query = session.createQuery("From Estabelecimento e where  e.id = :id");
		    query.setParameter("id", id);
		    retorno = (Estabelecimento) query.uniqueResult();
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

	public Estabelecimento obterEstabelecimentoPorCodigoEstabelecimento(
			String codigoEstabelecimento) {
		Estabelecimento retorno = null;		
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
		    Query query = session.createQuery("From Estabelecimento e where  e.codigoEstabelecimento = :codigoEstabelecimento");
		    query.setParameter("codigoEstabelecimento", codigoEstabelecimento);
		    retorno = (Estabelecimento) query.uniqueResult();
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
	
	public Estabelecimento obterEstabelecimentoPorQRCode(
			String qrCode) {
		Estabelecimento retorno = null;		
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
		    Query query = session.createQuery("From Estabelecimento e where	 e.qrCode = :qrCode");
		    query.setParameter("qrCode", qrCode);
		    retorno = (Estabelecimento) query.uniqueResult();
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

	public List<Estabelecimento> getTodosEstabelecimentos() {
		List<Estabelecimento> retorno = null;
		Session session = null;
		
		try{
			session = getSession().getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("From Estabelecimento");
			retorno = query.list();
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
