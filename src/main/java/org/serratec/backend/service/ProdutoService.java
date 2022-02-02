package org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	public ResponseEntity<Optional<Produto>> buscaProduto(@PathVariable(value = "id") Long id) {
		Optional<Optional<Produto>> produto = Optional.of(produtoRepository.findById(id));
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}

	public Produto criaProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.ok("Produto Deletado com sucesso!");
	}

	public ResponseEntity<Produto> atualizaProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
		Optional<Produto> produto1 = produtoRepository.findById(id);
		if (produto1.isPresent()) {
			if (produto.getNome() != null) {
				produto1.get().setNome(produto.getNome());
			}
			if (produto.getQuantidadeEstoque() != null) {
				produto1.get().setQuantidadeEstoque(produto.getQuantidadeEstoque());
			}
			if (produto.getDataCadastro() != null) {
				produto1.get().setDataCadastro(produto.getDataCadastro());
			}
			if (produto.getValorUnitario() != null) {
				produto1.get().setValorUnitario(produto.getValorUnitario());
			}
			if (produto.getUrlImg() != null) {
				produto1.get().setUrlImg(produto.getUrlImg());
			}

			produto = produtoRepository.save(produto1.get());
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}