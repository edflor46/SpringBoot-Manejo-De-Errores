package com.edflor.springboot.error.app.errors;

public class UsuarioNoEncontradoExeption extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontradoExeption(String id) {
		super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
		// TODO Auto-generated constructor stub
	}
	
	

}
