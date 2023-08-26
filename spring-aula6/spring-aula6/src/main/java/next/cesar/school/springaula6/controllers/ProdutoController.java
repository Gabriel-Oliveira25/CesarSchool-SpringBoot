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
import next.cesar.school.springaula6.entities.Produto;
import next.cesar.school.springaula6.repositories.ProdutoRepositorio;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produto")
public class ProdutoController {

	private final ProdutoRepositorio repositorio;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos(){
		if (repositorio.findAll().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Produto>>(repositorio.findAll(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
		return new ResponseEntity<Produto>(repositorio.save(produto), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //localhost:8080/v1/produto/2
	public ResponseEntity<Produto> listarProdutoPorID(@PathVariable(value = "id") String id){
		return new ResponseEntity<Produto>(repositorio.findById(id).orElseThrow(), HttpStatus.OK);
	}
}
