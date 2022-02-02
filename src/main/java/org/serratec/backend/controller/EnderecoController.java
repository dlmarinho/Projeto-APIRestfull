package org.serratec.backend.controller;

import org.serratec.backend.entity.Endereco;
import org.serratec.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep) {
		return clienteService.buscarPorCep(cep);
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Endereco> inserirEndeco(@RequestBody Endereco endereco) {
		return clienteService.inserirEndeco(endereco);

	}

}