package org.serratec.backend.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "cliente")
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	
	
	@Email
	@Column(name = "email", length = 100, unique = true, nullable = true)
	private String email;
	
	
	@Column(name = "nome_usuario", length = 100, unique = true, nullable = false)
	private String nomeUsuario;
	
	
	@Column(name = "nome_completo", length = 100, nullable = false)
	private String nomeCompleto;
	

	@Size(min=6 , max=255)
	@Column(name = "senha", length = 255, nullable = false)
	private String senha;
	
	
	
	@Column(name = "cpf", length = 15, unique = true, nullable = false)
	private String cpf;
	
	
	@Size(min=10 , max=13)
	@Column(name = "telefone", length = 13, nullable = true)
	private String telefone;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_nasc", nullable = true)
	private Date data_nasc;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente(Long id_cliente, @Email String email, String nomeUsuario, String nomeCompleto,
			@Size(min = 6, max = 255) String senha, String cpf, @Size(min = 10, max = 13) String telefone,
			Date data_nasc, Endereco endereco) {
		super();
		this.id_cliente = id_cliente;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.data_nasc = data_nasc;
		this.endereco = endereco;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, endereco, id_cliente, nomeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id_cliente, other.id_cliente)
				&& Objects.equals(nomeUsuario, other.nomeUsuario);
	}

	
	
	
}