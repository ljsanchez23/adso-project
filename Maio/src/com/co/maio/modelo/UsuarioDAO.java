package com.co.maio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase que maneja las operaciones de la base de datos para la entidad Usuario
 */

public class UsuarioDAO {

	// Constantes para la conexión a la base de datos
	private static final String URL = System.getenv("DB_URL");
	private static final String USER = System.getenv("DB_USER");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");

	// Método para obtener una conexión a la base de datos
	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Metodos para interactuar con la tabla usuarios en la base de datos Permite
	 * realizar las funciones CRUD
	 */
	public boolean insertarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nombreUsuario, password) VALUES (?, ?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, usuario.getNombreUsuario());
			statement.setString(2, usuario.getPassword());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarUsuario(String nombreUsuario) {
		String sql = "DELETE FROM usuarios WHERE nombreUsuario = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, nombreUsuario);
			int rowsDeleted = statement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean actualizarPassword(String nombreUsuario, String newPassword) {
		String sql = "UPDATE usuarios SET password = ? WHERE nombreUsuario = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, newPassword);
			statement.setString(2, nombreUsuario);
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Metodo limpiar tabla que elimina todos los registros de la tabla usuarios
	public boolean limpiarTabla() {
		String sql = "DELETE FROM usuarios";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}