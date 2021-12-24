package br.com.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.main.StatusLivro;
import br.com.biblioteca.service.StatusLivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sts")
public class StatusLivroResource {
	
	@Autowired
	StatusLivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <StatusLivro> findById(@PathVariable Integer id) {
		StatusLivro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@GetMapping
	public ResponseEntity<List<StatusLivro>> findAll() {
		List<StatusLivro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}*/
	
	/*
	@GetMapping
	public ResponseEntity<List<StatusLivro>> findByStatus(@RequestParam (value = "statusLivro", defaultValue = "0") Integer id_livro){
		List<StatusLivro> list = service.findByStatus(id_livro);
		return ResponseEntity.ok().body(list);
		//http://localhost:8080/cliente?statusLivro=1
	}*/
	
	/*@PostMapping
	public ResponseEntity<StatusLivro> create(@RequestParam(value = "livros", defaultValue = "0") @PathVariable Integer id_livro,
			@Valid @RequestBody StatusLivro obj) {
		StatusLivro newObj = service.create(id_livro, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/sts/{id_livro}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/

}
