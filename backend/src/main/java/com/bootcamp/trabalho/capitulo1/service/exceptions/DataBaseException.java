package com.bootcamp.trabalho.capitulo1.service.exceptions;

public class DataBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataBaseException(String msg) {
		super(msg);
	}

}
