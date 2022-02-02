package org.serratec.backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", nome=" + nome + ", cpf=" + cpf + ", salario="
				+ salario + ", produtoPedido=" + produtoPedido + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_funcionario;

//	@NotBlank
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

//	@NotBlank
	@Column(name = "cpf", length = 150, unique = true, nullable = false)
	private String cpf;

	@Column(name = "salario", length = 150, nullable = false)
	private String salario;
	
	@OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL)
	private List<ProdutoPedido> produtoPedido = new ArrayList<>();
	
	public Funcionario() {
		super();
	}

	public Funcionario(Long id_funcionario, String nome, String cpf, String salario) {
		super();
		this.id_funcionario = id_funcionario;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id_funcionario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id_funcionario, other.id_funcionario);
	}

}