package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	public Supplier getById(Integer id) {
		System.out.println(id);
		return (Supplier) em.createQuery("from Supplier where id =" + id).getSingleResult();		
	}

	@Override
	@Transactional
	public void save(Supplier supplier) {
		if(supplier.getId() != null && supplier.getId() > 0) {
			em.merge(supplier);
		} else {
			em.persist(supplier);
		}		
	}

}
