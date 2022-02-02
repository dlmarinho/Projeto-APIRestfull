package org.serratec.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.serratec.backend.entity.Pedido;
import org.serratec.backend.entity.ProdutoPedido;
import org.serratec.backend.repository.ClienteRepository;
import org.serratec.backend.repository.PedidoRepository;
import org.serratec.backend.repository.ProdutoPedidoRepository;
import org.serratec.backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping(value="/api")
@Api(value="Api ")
public class PedidoController {

	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoPedidoRepository produtoPedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PedidoService pedidoService;
	
	///////////////////////////////// GET ITEM DE PEDIDO POR ID /////////////////////////////////////////
	
	@GetMapping("/item/{id}")
	@ApiOperation(value="Retorna lista de pedidos")
	public ResponseEntity<Optional<ProdutoPedido>>  listaItens(@PathVariable(value="id") Long id) {
		return pedidoService.listaItens(id);
	}
	
	//////////////////////// GET TODODS OS ITENS DE PEDIDO POR ID DO PEDIDO /////////////////////////////////////////

	@GetMapping("/itens/pedido/{id}")
	@ApiOperation(value = "Retorna lista de itens por pedido")
	public List<ProdutoPedido> buscaItensPedido(@PathVariable(value = "id") Long id) {
		return pedidoService.buscaItensPedido(id);	
	}
	
	///////////////////////////// GET TODOS OS PEDIDOS /////////////////////////////////////////////
	@GetMapping("/pedidos")
	@ApiOperation(value="Retorna lista de pedidos")
	public List<Pedido> listaPedido() {
		return pedidoService.listaPedido();
	}
	
	///////////////////////////// GET TODOS OS ITENS PEDIDOS /////////////////////////////////////////////

	@GetMapping("/itens")
	@ApiOperation(value="Retorna lista de itens pedidos")
	public List<ProdutoPedido> listaItens() {
		return pedidoService.listaItens();
	}
	
	///////////////////////////// GET PEDIDO POR ID ////////////////////////////////////////////
	
	@GetMapping("/pedido/{id}")
	@ApiOperation(value="Retorna um pedido")
	public ResponseEntity<Optional<Pedido>> buscaPedido(@PathVariable(value="id")Long id){
				return pedidoService.buscaPedido(id);
	}
	
	///////////////////////////// CRIA PEDIDO ////////////////////////////////////////////

	@PostMapping("/pedido")
	@ApiOperation(value="Metodo para criar pedido")
	public Pedido criaPedido( @Valid  @RequestBody Pedido pedido) {
		return pedidoService.criaPedido(pedido);	
	}
	
	///////////////////////////// DELETA PEDIDO POR ID ////////////////////////////////////////////

	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long id){
		return pedidoService.deletarPorId(id);
	}
	
	///////////////////////////// ATUALIZA PEDIDO POR ID ////////////////////////////////////////////

	@PutMapping("/pedido/{id}")
	@ApiOperation(value="Metodo para editar um pedido")
	public ResponseEntity<Pedido>atualizaPedido(@PathVariable(value="id")Long id, @RequestBody Pedido pedido){
		return pedidoService.atualizaPedido(id, pedido);
	}

}