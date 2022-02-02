
package org.serratec.backend.service;

public class DataNotFoundException extends Exception {

	private Long id;
	public  DataNotFoundException(Long id2) {
		this.id = id2;
	}
	public Long getId() {
		return id;
	}
}