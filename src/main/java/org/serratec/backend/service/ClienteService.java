package org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.dtos.ClienteDto;
import org.serratec.backend.dtos.EnderecoDto;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	
	public List<ClienteDto> buscarTodos() {
		List<Cliente> clientes =  clienteRepository.findAll();
		List<ClienteDto> todosClientes = new ArrayList <>();
		List<EnderecoDto> todosEnderecos = new ArrayList<>();
		for(Cliente cliente : clientes) {
			ClienteDto x = new ClienteDto();
			x.setId_cliente(cliente.getId_cliente());
			x.setEmail(cliente.getEmail());
			x.setNomeCompleto(cliente.getNomeCompleto());
			x.setCpf(cliente.getCpf());
			EnderecoDto y =new EnderecoDto();
			y.setRua(cliente.getEndereco().getLogradouro());
			y.setNumero(cliente.getEndereco().getNumero());
			y.setComplemento(cliente.getEndereco().getComplemento());
			y.setBairro(cliente.getEndereco().getBairro());
			y.setLocalidade(cliente.getEndereco().getLocalidade());
			y.setUf(cliente.getEndereco().getUf());
			y.setRua(cliente.getEndereco().getLogradouro());
			x.setEnderecoDto(y);
			todosClientes.add(x);
		}
		return todosClientes;

	}

	public ResponseEntity<Optional<ClienteDto>> buscaCliente(@PathVariable(value = "id") Long id) {
		Optional<Cliente> clientes = clienteRepository.findById(id);
		Optional<ClienteDto> clienteDto = Optional.of(new ClienteDto());
		if (clientes.isPresent()) {
		
			
			EnderecoDto todosEnderecos = new EnderecoDto();
			
			clienteDto.get().setId_cliente(clientes.get().getId_cliente());
			clienteDto.get().setEmail(clientes.get().getEmail());
			clienteDto.get().setNomeCompleto(clientes.get().getNomeCompleto());
			clienteDto.get().setCpf(clientes.get().getCpf());
				
			todosEnderecos.setRua(clientes.get().getEndereco().getLogradouro());
			todosEnderecos.setNumero(clientes.get().getEndereco().getNumero());
			todosEnderecos.setComplemento(clientes.get().getEndereco().getComplemento());
			todosEnderecos.setBairro(clientes.get().getEndereco().getBairro());
			todosEnderecos.setLocalidade(clientes.get().getEndereco().getLocalidade());
			todosEnderecos.setUf(clientes.get().getEndereco().getUf());
			todosEnderecos.setRua(clientes.get().getEndereco().getLogradouro());
			clienteDto.get().setEnderecoDto(todosEnderecos);
				
		
			return ResponseEntity.ok(clienteDto);

		}
		return ResponseEntity.notFound().build();

	}

	

	public ResponseEntity<Cliente> atualizaCliente(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {

		Optional<Cliente> cliente1 = clienteRepository.findById(id);

		if (cliente1.isPresent()) {
			if (cliente.getEmail() != null) {
				cliente1.get().setEmail(cliente.getEmail());
			}
			if (cliente.getNomeUsuario() != null) {
				cliente1.get().setNomeUsuario(cliente.getNomeUsuario());
			}
			if (cliente.getNomeCompleto() != null) {
				cliente1.get().setNomeCompleto(cliente.getNomeCompleto());
			}
			if (cliente.getSenha() != null) {
				cliente1.get().setSenha(cliente.getSenha());
			}
			if (cliente.getCpf() != null) {
				cliente1.get().setCpf(cliente.getCpf());
			}
			if (cliente.getTelefone() != null) {
				cliente1.get().setTelefone(cliente.getTelefone());
			}
			if (cliente.getData_nasc() != null) {
				cliente1.get().setData_nasc(cliente.getData_nasc());
			}
			if (cliente.getEndereco() != null) {
				if (cliente.getEndereco().getCep() != null) {
					cliente1.get().getEndereco().setCep(cliente.getEndereco().getCep());
				}
				if (cliente.getEndereco().getLogradouro() != null) {
					cliente1.get().getEndereco().setLogradouro(cliente.getEndereco().getLogradouro());
				}
				if (cliente.getEndereco().getBairro() != null) {
					cliente1.get().getEndereco().setBairro(cliente.getEndereco().getBairro());
				}
				if (cliente.getEndereco().getLocalidade() != null) {
					cliente1.get().getEndereco().setLocalidade(cliente.getEndereco().getLocalidade());
				}
				if (cliente.getEndereco().getNumero() != null) {
					cliente1.get().getEndereco().setNumero(cliente.getEndereco().getNumero());
				}
				if (cliente.getEndereco().getComplemento() != null) {
					cliente1.get().getEndereco().setComplemento(cliente.getEndereco().getComplemento());
				}
				if (cliente.getEndereco().getUf() != null) {
					cliente1.get().getEndereco().setUf(cliente.getEndereco().getUf());
				}
				cliente = clienteRepository.save(cliente1.get());
				return ResponseEntity.ok(cliente);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		return null;
	}

	public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));

			if (enderecoViaCep.isPresent()) {
				// return inserir(enderecoViaCep.get());
				return ResponseEntity.ok(enderecoViaCep.get());
			}

		} catch (HttpClientErrorException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Endereco> inserirEndeco(@RequestBody Endereco endereco) {
		Optional<Endereco> endereco1 = Optional.of(new Endereco());
		endereco1.get().setCep(endereco.getCep());
		endereco1.get().setLogradouro(endereco.getLogradouro());
		endereco1.get().setComplemento(endereco.getComplemento());
		endereco1.get().setBairro(endereco.getBairro());
		endereco1.get().setLocalidade(endereco.getLocalidade());
		endereco1.get().setUf(endereco.getUf());
		endereco1.get().setIbge(endereco.getIbge());
		endereco1.get().setGia(endereco.getGia());
		endereco1.get().setDdd(endereco.getDdd());
		endereco1.get().setSiafi(endereco.getSiafi());
		endereco1.get().setNumero(endereco.getNumero());
		endereco = enderecoRepository.save(endereco1.get());
		return ResponseEntity.ok(endereco);

	}
}