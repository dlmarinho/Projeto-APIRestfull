package org.serratec.backend.entity;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class ProdutoPedido {
	
//	@Autowired
//	ProdutoRepository produtoRepository;
//	@Autowired
//	PedidoRepository pedidoRepository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produtoPedido;
	
	@OneToOne
	@JoinColumn(name ="id_produto")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@Column(name="quantidade_produto")
	private Integer quantidade;
	
	@OneToOne
	@JoinColumn(name ="id_funcionario")
	private Funcionario funcionario;
	
	@Column(name = "subtotal")
	private Double subtotal;

	public ProdutoPedido() {
		super();
	}

	

	public ProdutoPedido(Long id_produtoPedido, Produto produto, Pedido pedido, Integer quantidade,
			Funcionario funcionario, Double subtotal) {
		super();
		this.id_produtoPedido = id_produtoPedido;
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.funcionario = funcionario;
		this.subtotal = subtotal;
	}



	public Long getId_produtoPedido() {
		return id_produtoPedido;
	}



	public void setId_produtoPedido(Long id_produtoPedido) {
		this.id_produtoPedido = id_produtoPedido;
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	public Double getSubtotal() {
		return quantidade * produto.getValorVenda();
	}



	public void setSubtotal() {
		this.subtotal = quantidade * produto.getValorVenda();
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_produtoPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoPedido other = (ProdutoPedido) obj;
		return Objects.equals(id_produtoPedido, other.id_produtoPedido);
	}

	
	
}