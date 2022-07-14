package com.adidas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.entity.Product;

@RestController
public class AdidasController {
	@GetMapping("displayProduct")
	public String displayAllProduct() {
		return "product details";
	}
	@PostMapping("create")
	public String createProduct(@RequestBody Product pp) {
		return "product created "+pp.getProductId()+"  "+pp.getProductDescription();
	}
	@PutMapping("edit/{pid}")
	public String editProduct(@PathVariable("pid") String ss) {
		return "product edited";
	}
	@DeleteMapping("delete")
	public String deleteProduct() {
		return "product deleted";
	}
}
