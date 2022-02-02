package org.serratec.backend.dtos;

import java.util.Date;

public class ClienteDto {

	private Long id_cliente;
	private String email;
	private String nomeUsuario;
	private String nomeCompleto;
	private String senha;
	private String cpf;
	private String telefone;
	private Date data_nasc;
	private EnderecoDto enderecoDto;

	public ClienteDto() {
		super();
	}

	public ClienteDto(Long id_cliente, String email, String nomeUsuario, String nomeCompleto, String senha, String cpf,
			String telefone, Date data_nasc, EnderecoDto enderecoDto) {
		super();
		this.id_cliente = id_cliente;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.data_nasc = data_nasc;
		this.enderecoDto = enderecoDto;
	}

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

	public EnderecoDto getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoDto enderecoDto) {
		this.enderecoDto = enderecoDto;
	}

}
