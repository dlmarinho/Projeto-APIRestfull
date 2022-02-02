package org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	private MailConfig mailConfig;

	public List<Funcionario> buscarTodos() {

		return funcionarioRepository.findAll();

	}

	@GetMapping("/funcionario/{id}")
	@ApiOperation(value = "Retorna um funcionario")
	public ResponseEntity<Optional<Funcionario>> buscaFuncionario(@PathVariable(value = "id") long id) {
		Optional<Optional<Funcionario>> funcionario = Optional.of(funcionarioRepository.findById(id));

		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());

		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping("/funcionario")
	@ApiOperation(value = "Metodo para criar funcionario")
	public Funcionario criaFuncionario(@Valid @RequestBody Funcionario funcionario) {
		mailConfig.sendEmail("dm5237131@gmail.com", "Cadastro efetuado", funcionario.toString());
		return funcionarioRepository.save(funcionario);

	}

	@DeleteMapping("/funcionario/{id}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);
		return ResponseEntity.ok("funcionario Deletado com sucesso!");
	}

	@PutMapping("/funcionario/{id}")
	@ApiOperation(value = "Metodo para editar um funcionario")
	public ResponseEntity<Funcionario> atualizaFuncionario(@PathVariable(value = "id") long id,
			@RequestBody Funcionario funcionario) {

		Optional<Funcionario> funcionario1 = funcionarioRepository.findById(id);

		if (funcionario1.isPresent()) {
			if (funcionario.getNome() != null) {
				funcionario1.get().setNome(funcionario.getNome());
			}
			if (funcionario.getCpf() != null) {
				funcionario1.get().setCpf(funcionario.getCpf());
			}
			if (funcionario.getSalario() != null) {
				funcionario1.get().setSalario(funcionario.getSalario());
			}

			funcionario = funcionarioRepository.save(funcionario1.get());
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}