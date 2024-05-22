package com.co.maio.modelo;

/**
 * Representa un usuario en el sistema
 */

public class Usuario {

	// Atributos de la clase usuario
	private String nombreUsuario;
	private String password;

	// Constructor de la clase usuario
	public Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	// Getters y setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
