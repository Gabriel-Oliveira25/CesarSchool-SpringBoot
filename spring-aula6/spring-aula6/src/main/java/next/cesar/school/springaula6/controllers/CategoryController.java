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
import next.cesar.school.springaula6.entities.Category;
import next.cesar.school.springaula6.services.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllProducts() {
		if (categoryService.getAllCategories() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Category> insertProduct(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.insertCategory(category), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> getProductById(@PathVariable(value = "id") String id) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}
}