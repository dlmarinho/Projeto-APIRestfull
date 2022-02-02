package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.dtos.ClienteDto;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api ")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteService clienteService;

	@GetMapping("/clientes")
	@ApiOperation(value = "Retorna lista de clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista criada com sucesso!!"),
			@ApiResponse(code = 401, message = "Erro de autenticação!!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso!"),
			@ApiResponse(code = 404, message = "Recurso não encontrado!!"),
			@ApiResponse(code = 500, message = "Exceção") })
	public List<ClienteDto> listaTodos() {
		return clienteService.buscarTodos();
	}

	@GetMapping("/cliente/{id}")
	@ApiOperation(value = "Retorna um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso!!"),
			@ApiResponse(code = 401, message = "Erro de autenticação!!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso!"),
			@ApiResponse(code = 404, message = "Recurso não encontrado!!"),
			@ApiResponse(code = 500, message = "Exceção") })
	public ResponseEntity<Optional<ClienteDto>> buscaCliente(@PathVariable(value = "id") Long id) {
		return clienteService.buscaCliente(id);
	}

	@PostMapping("/cliente")
	@ApiOperation(value = "Metodo para criar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso!!"),
			@ApiResponse(code = 401, message = "Erro de autenticação!!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso!"),
			@ApiResponse(code = 404, message = "Recurso não encontrado!!"),
			@ApiResponse(code = 500, message = "Exceção") })
	public Cliente criaCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);

	}

	@DeleteMapping("/cliente/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso!!"),
			@ApiResponse(code = 401, message = "Erro de autenticação!!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso!"),
			@ApiResponse(code = 404, message = "Recurso não encontrado!!"),
			@ApiResponse(code = 500, message = "Exceção") })
	public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.ok("Cliente Deletado com sucesso!");
	}

	@PutMapping("/cliente/{id}")
	@ApiOperation(value = "Metodo para editar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso!!"),
			@ApiResponse(code = 401, message = "Erro de autenticação!!"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar esse recurso!"),
			@ApiResponse(code = 404, message = "Recurso não encontrado!!"),
			@ApiResponse(code = 500, message = "Exceção") })
	public ResponseEntity<Cliente> atualizaCliente(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {

		return clienteService.atualizaCliente(id , cliente);
	}
}
