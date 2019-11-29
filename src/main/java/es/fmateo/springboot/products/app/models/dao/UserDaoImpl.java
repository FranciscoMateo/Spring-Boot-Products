package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.fmateo.springboot.products.app.models.entity.User;

@Repository("UserDaoJPA")
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<User> getAll() {
		return em.createQuery("from User").getResultList();
	}

	@Transactional(readOnly = true)
	public User getById(Long id) {
		return (User) em.createQuery("from User where id =" + id).getSingleResult();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

}
