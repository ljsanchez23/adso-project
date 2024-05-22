package com.co.maio.controlador;

import com.co.maio.modelo.Usuario;

/**
 * Controlador de usuarios, permite la comunicacion entre la vista y el modelo
 */

public class UsuarioControlador {

	private Usuario usuario;

	public UsuarioControlador(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean autenticar(String nombreUsuario, String password) {
		if (nombreUsuario.equals(usuario.getNombreUsuario()) && password.equals(usuario.getPassword())) {
			System.out.println("Usuario autenticado exitosamente.");
			return true;
		} else {
			System.out.println("Error de autenticación: nombre de usuario o contraseña incorrectos.");
			return false;
		}
	}

	public void cambiarPassword(String nuevoPassword) {
		usuario.setPassword(nuevoPassword);
		System.out.println("Contraseña actualizada correctamente.");
	}
}