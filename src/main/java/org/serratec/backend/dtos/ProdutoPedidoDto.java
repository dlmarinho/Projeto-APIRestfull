package org.serratec.backend.dtos;

public class ProdutoPedidoDto {
	private String nomeProduto;
	private Integer quantidade;
	private Double valorUnit;
	private Double subtotal;

	public ProdutoPedidoDto() {
		super();
	}

	public ProdutoPedidoDto(String nomeProduto, Integer quantidade, Double valorUnit, Double subtotal) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.subtotal = subtotal;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

}