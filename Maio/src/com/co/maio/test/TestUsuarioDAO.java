package com.co.maio.test;

import com.co.maio.modelo.Usuario;
import com.co.maio.modelo.UsuarioDAO;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario nuevoUsuario = new Usuario("testUser", "testPass123");

		// Prueba de inserción
		boolean insertado = usuarioDao.insertarUsuario(nuevoUsuario);
		System.out.println("Inserción fue " + (insertado ? "exitosa" : "fallida"));

		// Prueba de actualización de contraseña
		boolean actualizado = usuarioDao.actualizarPassword("testUser", "newTestPass123");
		System.out.println("Actualización de contraseña fue " + (actualizado ? "exitosa" : "fallida"));

		// Prueba de eliminación
		boolean eliminado = usuarioDao.eliminarUsuario("testUser");
		System.out.println("Eliminación fue " + (eliminado ? "exitosa" : "fallida"));

		// Agregamos un nuevo usuario, admin2 password admin2

		Usuario nuevoAdmin = new Usuario("admin2", "admin2");
		usuarioDao.insertarUsuario(nuevoAdmin);

		Usuario nuevoNuevoAdmin = new Usuario("admin3", "admin3");
		usuarioDao.insertarUsuario(nuevoNuevoAdmin);

		usuarioDao.limpiarTabla();
	}
}
