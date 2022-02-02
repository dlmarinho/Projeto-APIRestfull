package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.serratec.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api ")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna lista de produtos")
	private List<Produto> buscarTodos() {

		return produtoService.buscarTodos();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto")
	public ResponseEntity<Optional<Produto>>buscaProduto(@PathVariable(value = "id") Long id) {

		return produtoService.buscaProduto(id) ;

	}
	
	

	@PostMapping("/produto")
	@ApiOperation(value = "Metodo para criar produto")
	public Produto criaProduto(@Valid @RequestBody Produto produto) {
		return produtoService.criaProduto(produto);

	}

	
		@DeleteMapping("/produto/{id}")
		public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
			return produtoService.deletarPorId(id);
		}
	

	@PutMapping("/produto/{id}")
	@ApiOperation(value = "Metodo para editar um cliente")
	public ResponseEntity<Produto> atualizaProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto) {

	return produtoService.atualizaProduto(id, produto);
	}
}