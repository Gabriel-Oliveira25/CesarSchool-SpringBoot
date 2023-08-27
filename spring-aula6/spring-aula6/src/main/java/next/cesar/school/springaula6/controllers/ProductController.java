package next.cesar.school.springaula6.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import next.cesar.school.springaula6.entities.Product;
import next.cesar.school.springaula6.services.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/product")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		if (productService.getAllProducts() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.insertProduct(product), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String id) {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
}
