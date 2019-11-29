package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.fmateo.springboot.products.app.models.entity.Product;
import es.fmateo.springboot.products.app.models.entity.User;

@Repository("ProductDaoJPA")
public class ProductDaoImpl implements IProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	@Qualifier("UserDaoJPA")
	private IUserDao userDao;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Product> getAll() {
		return em.createQuery("from Product").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Product getById(Integer id) {
		return (Product) em.createQuery("from Product where id =" + id).getSingleResult();
	}
	
	@Override
	@Transactional
	public void save(Product product) {
		if(product.getId() != null && product.getId() > 0) {
			em.merge(product);
		} else {
			User creator = userDao.getById((long) 2);
			product.setCreator(creator);
			
			em.persist(product);
		}		
	}

}
