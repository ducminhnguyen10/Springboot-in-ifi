package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "entity")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> getAllCustomer() {
		List<Product> products = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping(value = "/product/{id}") /*ERROR*/ /*****/
	public ResponseEntity<Product> getProductByNumber(@PathVariable("id") Integer productNumber) {
		Product ProductGet = productService.getProductById(productNumber);
		return new ResponseEntity<Product>(ProductGet,HttpStatus.OK);
	}

	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Void> deleteProductByNumber(@PathVariable("id") Integer productNumber) {
		productService.deleteProduct(productNumber);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/product") 
	public ResponseEntity<Void> createProduct(Product products, UriComponentsBuilder builder) throws ParseException {
		boolean flag = productService.addProduct(products);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/entity/product/{id}").buildAndExpand(products.getProductNumber()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/product") /*ERROR*/ /*****/
	public ResponseEntity<Product> updateCustomer(Product productUpdate) throws ParseException {
		productService.editProduct(productUpdate);
		return new ResponseEntity<Product>(productUpdate, HttpStatus.OK);
	}
}
