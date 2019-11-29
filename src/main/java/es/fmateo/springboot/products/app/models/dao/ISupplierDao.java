package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import es.fmateo.springboot.products.app.models.entity.Supplier;


public interface ISupplierDao {
	public List<Supplier> getAll();
	public Supplier getById(Integer id);
	public void save(Supplier supplier);
}
