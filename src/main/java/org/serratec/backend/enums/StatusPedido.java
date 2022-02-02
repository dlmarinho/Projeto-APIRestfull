package org.serratec.backend.enums;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusPedido {

	ABERTO(1, "Aberto."), CANCELADO(2, "Cancelado."), ENTREGUE(3, "Entregue."),
	AGUARDANDO_COLETA(4, "Aguardando a coleta."), PRODUTO_EM_TRANSITO(5, "Produto em trânsito.");

	
	@JsonCreator
	public static StatusPedido verifica(String value)throws BeanDefinitionValidationException{
		for(StatusPedido c: values()) {
			if(value.equals(c.name())) {
				return c;
			}
		}
		throw new BeanDefinitionValidationException("Status preenchido incorretamente");
	}
	
	
	
	private Integer codigoStatus;
	private String descricaoStatus;

	private StatusPedido() {

	}

	private StatusPedido(Integer codigoStatus, String descricaoStatus) {
		this.codigoStatus = codigoStatus;
		this.descricaoStatus = descricaoStatus;
	}

	public Integer getCodigoStatus() {
		return codigoStatus;
	}

	public void setCodigoStatus(Integer codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

}
