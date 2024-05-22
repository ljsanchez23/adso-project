package com.co.maio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja las operaciones de la base de datos para la entidad Usuario
 */
public class ProductoDAO {

	// Constantes para la conexión a la base de datos
	private static final String URL = System.getenv("DB_URL");
	private static final String USER = System.getenv("DB_USER");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");

	// Método para obtener una conexión a la base de datos
	protected Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Metodos para interactuar con la tabla productos en la base de datos Permite
	 * realizar las funciones CRUD
	 */
	public boolean agregarProducto(Producto producto) {
		String sql = "INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setInt(2, producto.getCantidad());
			preparedStatement.setDouble(3, producto.getPrecio());
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarProducto(Producto producto) {
		String sql = "DELETE FROM productos WHERE nombre = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, producto.getNombre());
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modificarCantidadProducto(Producto producto, int nuevaCantidad) {
		String sql = "UPDATE productos SET cantidad = ? WHERE nombre = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, nuevaCantidad);
			preparedStatement.setString(2, producto.getNombre());
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modificarNombreProducto(Producto producto, String nuevoNombre) {
		String sql = "UPDATE productos SET nombre = ? WHERE nombre = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, nuevoNombre);
			preparedStatement.setString(2, producto.getNombre());
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Producto buscarProducto(Producto productoBuscado) {
		String sql = "SELECT * FROM productos WHERE nombre = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, productoBuscado.getNombre());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String nombreProducto = resultSet.getString("nombre");
				int cantidad = resultSet.getInt("cantidad");
				double precio = resultSet.getDouble("precio");
				Producto producto = new Producto(nombreProducto, cantidad, precio);
				return producto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Obtiene una lista con todos los productos de la base de datos
	public List<Producto> obtenerTodosProductos() {
		List<Producto> productos = new ArrayList<>();
		String sql = "SELECT * FROM productos";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int cantidad = resultSet.getInt("cantidad");
				double precio = resultSet.getDouble("precio");
				Producto producto = new Producto(nombre, cantidad, precio);
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	// Metodo limpiar tabla que elimina todos los registros de la tabla usuarios
	public boolean limpiarTabla() {
		String sql = "DELETE FROM productos";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}