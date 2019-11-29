package es.fmateo.springboot.products.app.models.dao;

import java.util.List;

import es.fmateo.springboot.products.app.models.entity.User;

public interface IUserDao {
	
		public List<User> getAll();
		public User getById(Long id);
		public void save(User user);
}
