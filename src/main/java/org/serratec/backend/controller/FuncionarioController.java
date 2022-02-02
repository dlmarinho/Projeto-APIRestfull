package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.serratec.backend.service.FuncionarioService;
import org.serratec.backend.service.MailConfig;
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
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	FuncionarioService funcionarioService;

	@GetMapping("/funcionarios")
	@ApiOperation(value = "Retorna lista de funcionarios")
	public List<Funcionario> listaFuncionario() {

		return funcionarioService.buscarTodos();

	}

	@GetMapping("/funcionario/{id}")
	@ApiOperation(value = "Retorna um funcionario")
	public ResponseEntity<Optional<Funcionario>> buscaFuncionario(@PathVariable(value = "id") long id) {

		return funcionarioService.buscaFuncionario(id);

	}

	@PostMapping("/funcionario")
	@ApiOperation(value = "Metodo para criar funcionario")
	public Funcionario criaFuncionario(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioService.criaFuncionario(funcionario);

	}

	@DeleteMapping("/funcionario/{id}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
		return funcionarioService.deletarPorId(id);
	}

	@PutMapping("/funcionario/{id}")
	@ApiOperation(value = "Metodo para editar um funcionario")
	public ResponseEntity<Funcionario> atualizaFuncionario(@PathVariable(value = "id") long id,
			@RequestBody Funcionario funcionario) {

		return funcionarioService.atualizaFuncionario(id, funcionario);

	}

}