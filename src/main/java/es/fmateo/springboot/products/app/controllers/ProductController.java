package es.fmateo.springboot.products.app.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.fmateo.springboot.products.app.models.dao.IProductDao;
import es.fmateo.springboot.products.app.models.dao.ISupplierDao;
import es.fmateo.springboot.products.app.models.entity.Product;
import es.fmateo.springboot.products.app.models.entity.Supplier;


@Controller
public class ProductController {

	@Autowired
	@Qualifier("ProductDaoJPA")
	private IProductDao productDao;
	
	@Autowired
	@Qualifier("SupplierDaoJPA")
	private ISupplierDao supplierDao;
		
	@GetMapping("/products")
	public String ProductList(Model model) {
		model.addAttribute("title", "List of products");
		model.addAttribute("products", productDao.getAll());
		return "product/list";
	}
	
	@RequestMapping(value="/products/edit")
	public String EditProduct( @RequestParam("product_id") Integer product_id, Model model){
		
		Product product = productDao.getById(product_id);
		model.addAttribute("title", "Edit");
		model.addAttribute("product", product);
		return "product/single_product";
	}
	
	@RequestMapping(value="/products/edit/save_product", method = RequestMethod.POST)
	public String save_product (@Valid Product product, BindingResult result, Model model){
		if(result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("title", "Editar");
			return "/product/single_product";
		}
		productDao.save(product);
		return "redirect:product/list";
	}
	
}
