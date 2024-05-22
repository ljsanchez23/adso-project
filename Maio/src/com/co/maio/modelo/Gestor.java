package com.co.maio.modelo;

import java.util.List;

/**
 * Clase gestor que se encarga de todas las acciones ejecutadas en el programa
 * Permite la separacion de la logica entre las acciones de negocio y las
 * interacciones con la base de datos
 */
public class Gestor {
	// Atributos de la clase gestor, para poder manejar la logica desde la base de
	// datos con los metodos de la clase ProductoDAO
	private ProductoDAO productoDAO;

	// Constructor de la clase gestor
	public Gestor() {
		productoDAO = new ProductoDAO();
	}

	/**
	 * Ejecucion de los metodos escritos en la clase ProductoDAO, se adicionan las
	 * validaciones necesarias de logica de negocio
	 */
	public boolean agregarProducto(Producto producto) {
		Producto existente = productoDAO.buscarProducto(producto);
		if (existente == null) {
			return productoDAO.agregarProducto(producto);
		} else {
			System.out.println("Producto ya existe en el inventario.");
			return false;
		}
	}

	public boolean eliminarProducto(Producto producto) {
		Producto existente = productoDAO.buscarProducto(producto);
		if (existente != null) {
			return productoDAO.eliminarProducto(producto);
		} else {
			System.out.println("Producto no encontrado, no se puede eliminar.");
			return false;
		}
	}

	public Producto buscarProducto(Producto producto) {
		return productoDAO.buscarProducto(producto);
	}

	public List<Producto> getListaProductos() {
		return productoDAO.obtenerTodosProductos();
	}

	public void limpiarTablaProductos() {
		productoDAO.limpiarTabla();
	}

	public void limpiarTablaUsuarios() {
		productoDAO.limpiarTabla();
	}

	public boolean modificarCantidad(Producto producto, int nuevaCantidad) {
		if (nuevaCantidad <= 0) {
			System.out.println("La cantidad debe ser mayor que cero.");
			return false;
		}
		Producto productoActual = productoDAO.buscarProducto(producto);
		if (productoActual == null) {
			System.out.println("Producto no encontrado en la base de datos.");
			return false;
		}

		if (nuevaCantidad == productoActual.getCantidad()) {
			System.out.println("La nueva cantidad no puede ser igual a la cantidad actual.");
			return false;
		}
		return productoDAO.modificarCantidadProducto(producto, nuevaCantidad);
	}
}