package br.com.bought.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bought.model.Compra;
import br.com.bought.model.Estabelecimento;
import br.com.bought.model.Usuario;

public class CompraDAOImpl implements CompraDAO {

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

	public Long salvar(Compra compra) {
		Long retorno = null;
		Session session = null;
		if (compra != null) {
			try {
				session = getSession().getCurrentSession();
				session.beginTransaction();

				retorno = (Long) session.save(compra);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		return retorno;
	}

	public List<Compra> obterComprasPorUsuario(Usuario usuario, Estabelecimento estabelecimento) {
		Session session = null;
		List<Compra> retorno = null;
		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query q = session
					.createQuery("From Compra c where c.usuario.id = :idUsuario and c.estabelecimento.id = :idEstabelecimento");
			q.setParameter("idUsuario", usuario.getId());
			q.setParameter("idEstabelecimento", estabelecimento.getId());
			retorno = q.list();
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

	public Compra buscarCompraPorId(Long id) {
		Compra retorno = null;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query query = session
					.createQuery("From Compra c where  c.id = :id");
			query.setParameter("id", id);
			retorno = (Compra) query.uniqueResult();
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

	public Boolean update(Compra compra){
		Boolean retorno = Boolean.FALSE;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			session.update(compra);
			session.getTransaction().commit();
			retorno = Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return retorno;
	}
	
	public Boolean excluirCompra(Compra compra) {
		// TODO Auto-generated method stub
		return null;
	}
}
