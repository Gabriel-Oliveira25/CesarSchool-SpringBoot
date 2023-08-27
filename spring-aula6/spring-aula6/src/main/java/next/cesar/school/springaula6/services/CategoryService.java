package next.cesar.school.springaula6.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import next.cesar.school.springaula6.entities.Category;
import next.cesar.school.springaula6.repositories.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository repository;
	
	public Category getCategoryById(String id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
	}
	
	public Category insertCategory(Category category) {
		return repository.save(category);
	}
	
	public List<Category> getAllCategories() {
		if (repository.findAll().isEmpty()) {
			return null;
		} else {
			return repository.findAll();
		}
	}
}
