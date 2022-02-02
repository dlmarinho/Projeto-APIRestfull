package org.serratec.backend.entity;

import java.time.LocalDate;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.serratec.backend.enums.CategoriaProduto;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;
	
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque;

	
	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	
	@Column(name = "valor_unitario", nullable = false)
	private Double valorUnitario;
	
	@Column(name = "valor_venda", nullable = false)
	private Double valorVenda;
	
	@Column(name = "url_img", nullable = true)
	private String urlImg;

	@Enumerated(EnumType.STRING)
	private CategoriaProduto categoriaProduto;
	
	public Produto() {

	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

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

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Produto(Long id_produto, String nome, Integer quantidadeEstoque, LocalDate dataCadastro,
			Double valorUnitario, Double valorVenda, String urlImg, CategoriaProduto categoriaProduto) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.valorVenda = valorVenda;
		this.urlImg = urlImg;
		this.categoriaProduto = categoriaProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id_produto, other.id_produto);
	}

	

}
