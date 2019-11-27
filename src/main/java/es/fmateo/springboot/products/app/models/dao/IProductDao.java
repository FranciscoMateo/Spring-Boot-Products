package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import es.fmateo.springboot.products.app.models.entity.Product;


public interface IProductDao {
public List<Product> getAll();
public Product getById(Integer id);
public void save(Product product);
}
