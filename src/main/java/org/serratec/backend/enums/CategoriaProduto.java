package org.serratec.backend.enums;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoriaProduto {

	ANIMES, CELEBRIDADES, ESPORTES, FILMES, GAMES, HEROIS, MARCAS, SERIES;

	

@JsonCreator
public static CategoriaProduto verifica(String value)throws BeanDefinitionValidationException{
	for(CategoriaProduto c: values()) {
		if(value.equals(c.name())) {
			return c;
		}
	}
	throw new BeanDefinitionValidationException("Categoria preenchida incorretamente");
}
}
	
	
	
	
	

