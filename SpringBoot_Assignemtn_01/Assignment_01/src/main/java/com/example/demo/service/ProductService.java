package com.example.demo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	private Product products;

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(int productId) {
		return productRepository.findOne(productId);
	}

	public boolean deleteProduct(int productId) {
		if (this.getProductById(productId) != null) {
			productRepository.delete(productId);
			return true;
		}
		return false;
	}

	public boolean addProduct(Product product) {
		try {
			setProducts(new Product(product.getProductName(), product.getDateOfPayment(), product.getPrice()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (productRepository.save(product) != null) {
			return true;
		}
		return false;
	}

	public boolean editProduct(Product product) throws ParseException {
		Product productEdit  = new Product(product.getProductNumber(),product.getProductName(), product.getDateOfPayment(), product.getPrice());
		productEdit.setProductNumber(product.getProductNumber());
		if(productRepository.save(productEdit)!=null) {
			return true;
		}
		return false;
	}

	
	
	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}
}
