package org.serratec.backend.dtos;

import java.time.LocalDate;


public class ProdutoDto {


	
	private String nome;
	private Integer quantidadeEstoque;
	private LocalDate dataCadastro;
	private Double valorUnitario;
	
	
	
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ProdutoDto(String nome, Integer quantidadeEstoque, LocalDate dataCadastro, Double valorUnitario) {
		super();
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
	}
	
	
	
	
	
	
}
