package org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Pedido;
import org.serratec.backend.entity.ProdutoPedido;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.repository.PedidoRepository;
import org.serratec.backend.repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoPedidoRepository produtoPedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	///////////////////////////////// GET ITEM DE PEDIDO POR ID /////////////////////////////////////////
	
	public ResponseEntity<Optional<ProdutoPedido>>  listaItens(@PathVariable(value="id") Long id) {
		Optional<Optional<ProdutoPedido>> item = Optional.of(produtoPedidoRepository.findById(id));
		
		if(item.isPresent()) {
			return ResponseEntity.ok(item.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	//////////////////////// GET TODODS OS ITENS DE PEDIDO POR ID DO PEDIDO /////////////////////////////////////////
	
	public List<ProdutoPedido> buscaItensPedido(@PathVariable(value = "id") Long id) {
		
		List<ProdutoPedido> itens = produtoPedidoRepository.findAll();
		
		List<ProdutoPedido> resultado = new ArrayList<ProdutoPedido>();
		
		for (ProdutoPedido produtoPedido : itens) {
			if(produtoPedido.getPedido().getId_pedido() == id) {
				resultado.add(produtoPedido);
			} 
		}
		return resultado;	
	}
	
	///////////////////////////// GET TODOS OS PEDIDOS /////////////////////////////////////////////

	public List<Pedido> listaPedido() {
		List<Pedido> todosPedidos = pedidoRepository.findAll();
		return todosPedidos;
	}
	
	///////////////////////////// GET TODOS OS ITENS PEDIDOS /////////////////////////////////////////////

	public List<ProdutoPedido> listaItens() {
		return produtoPedidoRepository.findAll();

	}
	
	///////////////////////////// GET PEDIDO POR ID ////////////////////////////////////////////

	public ResponseEntity<Optional<Pedido>> buscaPedido(@PathVariable(value="id")Long id){
		Optional<Optional<Pedido>> pedido = Optional.of(pedidoRepository.findById(id));
		
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	///////////////////////////// CRIA PEDIDO ////////////////////////////////////////////

	public Pedido criaPedido(@Valid  @RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
		
	}
	
	public ResponseEntity<String> deletarPorId(@PathVariable Long id){
		if(!pedidoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		pedidoRepository.deleteById(id);
		return ResponseEntity.ok("pedido Deletado com sucesso!");
	}
	
	
	
	public ResponseEntity<Pedido>atualizaPedido(@PathVariable(value="id")Long id, @RequestBody Pedido pedido){
		
		Optional<Pedido> pedido1 = pedidoRepository.findById(id);
		
		if (pedido1.isPresent()) {
			if (pedido.getDataPedido() != null) {
				pedido1.get().setDataPedido(pedido.getDataPedido());
			}
			if (pedido.getDataEnvio() != null) {
				pedido1.get().setDataEnvio(pedido.getDataEnvio());
			}
			if (pedido.getDataEntrega() != null) {
				pedido1.get().setDataEntrega(pedido.getDataEntrega());
			}
			if(pedido.getCliente() != null) {
				pedido1.get().setCliente(clienteRepository.getById(pedido.getCliente().getId_cliente()));
			}

			pedido = pedidoRepository.save(pedido1.get());
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}