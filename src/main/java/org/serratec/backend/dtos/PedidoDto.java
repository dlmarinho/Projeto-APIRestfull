package org.serratec.backend.dtos;

import java.time.LocalDate;

public class PedidoDto {

	private Long id_pedido;
	private LocalDate dataPedido;
	private LocalDate dataEnvio;
	private LocalDate dataEntrega;
	private String nomeCliente;
	private String email;
	private String cpf;
	private ProdutoPedidoDto produtoPedidoDto;
	private Double total;

	public PedidoDto() {
		super();
	}

	public PedidoDto(Long id_pedido, LocalDate dataPedido, LocalDate dataEnvio, LocalDate dataEntrega,
			String nomeCliente, String email, String cpf, ProdutoPedidoDto produtoPedidoDto, Double total) {
		super();
		this.id_pedido = id_pedido;
		this.dataPedido = dataPedido;
		this.dataEnvio = dataEnvio;
		this.dataEntrega = dataEntrega;
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.cpf = cpf;
		this.produtoPedidoDto = produtoPedidoDto;
		this.total = total;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ProdutoPedidoDto getProdutoPedidoDto() {
		return produtoPedidoDto;
	}

	public void setProdutoPedidoDto(ProdutoPedidoDto produtoPedidoDto) {
		this.produtoPedidoDto = produtoPedidoDto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}