package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.fmateo.springboot.products.app.models.entity.Product;
import es.fmateo.springboot.products.app.models.entity.Supplier;

@Repository("SupplierDaoJPA")
public class SupplierDaoImpl implements ISupplierDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Supplier> getAll() {
		return em.createQuery("from Supplier").getResultList();
	}

	@Override
	@Transactional
	public void save(Supplier supplier) {
		em.persist(supplier);
	}

}
