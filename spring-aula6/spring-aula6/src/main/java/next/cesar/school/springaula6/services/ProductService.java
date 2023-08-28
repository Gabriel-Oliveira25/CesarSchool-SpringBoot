package next.cesar.school.springaula6.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import next.cesar.school.springaula6.entities.Product;
import next.cesar.school.springaula6.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;
	
	public Product getProductById(String id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado"));
	}
	
	public Product insertProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> getAllProducts() {
		if (repository.findAll().isEmpty()) {
			return null;
		} else {
			return repository.findAll();
		}
	}
}
