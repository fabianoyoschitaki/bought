package br.com.bought.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bought.model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO{

	private SessionFactory sessionFactory;

	public SessionFactory getSession() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}

		if (sessionFactory.isClosed()) {
			sessionFactory.openSession();
		}
		return sessionFactory;
	}
	
	@Override
	public Produto obterPorCodigoBarra(String codigoBarra) {
		Produto item = null;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query query = session
					.createQuery("From Produto p where  p.codigoBarra = :codigoBarra");
			query.setParameter("codigoBarra", codigoBarra);
			item = (Produto) query.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return item;
	}

	@Override
	public List<Produto> listarTodos() {
		Session session = null;
		List<Produto> retorno = null;
		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query query = session
					.createQuery("From Produto");
			retorno = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return retorno;
	}

	@Override
	public Long salvar(Produto produto) {
		Session session = null;
		Long retorno = null;
		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			retorno = (Long) session.save(produto);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return retorno;
	}
}