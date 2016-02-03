package br.com.bought.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.bought.model.Compra;
import br.com.bought.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

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

	public Usuario buscarPorId(Long id) {
		Usuario retorno = null;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Object load = session.load(Usuario.class, id);
			if (load != null) {
				retorno = (Usuario) load;
			}
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

	public Usuario obterUsuarioPorEmail(String email) {
		Usuario retorno = null;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query query = session
					.createQuery("From Usuario u where  u.email = :email");
			query.setParameter("email", email);
			retorno = (Usuario) query.uniqueResult();
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

	public Boolean update(Usuario usuario){
		Boolean retorno = Boolean.FALSE;
		Session session = null;

		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			session.update(usuario);
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
	
	public Long salvar(Usuario usuario) {
		Long retorno = null;
		Session session = null;
		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			retorno = (Long) session.save(usuario);
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

	public List<Usuario> listarTodos() {
		Session session = null;
		List<Usuario> retorno = null;
		try {
			session = getSession().getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery("From Usuario ");
			retorno = q.list();
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