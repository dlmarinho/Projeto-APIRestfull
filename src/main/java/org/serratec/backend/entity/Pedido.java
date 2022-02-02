package org.serratec.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.serratec.backend.enums.StatusPedido;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;

	@Column(name = "data_pedido ", nullable = false)
	private LocalDate dataPedido;

	@Column(name = "data_envio", nullable = true)
	private LocalDate dataEnvio;

	@Column(name = "data_entrega", nullable = true)
	private LocalDate dataEntrega;

	@Enumerated(EnumType.ORDINAL)
	private StatusPedido statusPedido;

	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	private List<ProdutoPedido> produtoPedido = new ArrayList<>();

	@Column(name = "valor_total", nullable = true)
	private Double valorTotal;

	public Pedido() {
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

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		Double resultado = 0.0;

		for (ProdutoPedido produtoPedidoR : produtoPedido) {
			resultado = resultado + produtoPedidoR.getSubtotal();
		}
		return resultado;
	}

	public void setValorTotal() {
		Double resultado = 0.0;

		for (ProdutoPedido produtoPedidoR : produtoPedido) {
			resultado = resultado + produtoPedidoR.getSubtotal();
		}

		this.valorTotal = resultado;
	}

	public Pedido(Long id_pedido, LocalDate dataPedido, LocalDate dataEnvio, LocalDate dataEntrega,
			StatusPedido statusPedido, Cliente cliente, Double valorTotal) {
		super();
		this.id_pedido = id_pedido;
		this.dataPedido = dataPedido;
		this.dataEnvio = dataEnvio;
		this.dataEntrega = dataEntrega;
		this.statusPedido = statusPedido;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id_pedido, other.id_pedido);
	}

}