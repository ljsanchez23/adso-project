package com.co.maio.controlador;

import com.co.maio.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de usuarios, permite la comunicacion entre la vista y el modelo
 */

public class ProductoControlador {
	private List<Producto> inventario;

	public ProductoControlador() {
		this.inventario = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		inventario.add(producto);
		System.out.println("Producto agregado: " + producto);
	}

	public boolean eliminarProducto(String nombre) {
		for (Producto producto : inventario) {
			if (producto.getNombre().equals(nombre)) {
				inventario.remove(producto);
				System.out.println("Producto eliminado: " + nombre);
				return true;
			}
		}
		System.out.println("Producto no encontrado: " + nombre);
		return false;
	}

	public boolean actualizarCantidadProducto(String nombre, int nuevaCantidad) {
		for (int i = 0; i < inventario.size(); i++) {
			if (nombre.equals(inventario.get(i).getNombre())) {
				inventario.get(i).setCantidad(nuevaCantidad);
				System.out.println("Cantidad actualizada para " + nombre + ": " + nuevaCantidad);
				return true;
			}
		}
		System.out.println("El producto buscado no existe");
		return false;
	}

	public void incrementarCantidad(String nombre) {
		for (Producto producto : inventario) {
			if (producto.getNombre().equals(nombre)) {
				producto.setCantidad(producto.getCantidad() + 1);
				System.out.println("Cantidad incrementada para " + nombre + ": " + producto.getCantidad());
				return;
			}
		}
		System.out.println("Producto no encontrado para incrementar: " + nombre);
	}

	public void decrementarCantidad(String nombre) {
		for (Producto producto : inventario) {
			if (producto.getNombre().equals(nombre)) {
				int nuevaCantidad = producto.getCantidad() - 1;
				if (nuevaCantidad >= 0) {
					producto.setCantidad(nuevaCantidad);
					System.out.println("Cantidad decrementada para " + nombre + ": " + nuevaCantidad);
				} else {
					System.out.println("No se puede reducir la cantidad más allá de cero.");
				}
				return;
			}
		}
		System.out.println("Producto no encontrado para decrementar: " + nombre);
	}

	public void mostrarInventario() {
		if (inventario.isEmpty()) {
			System.out.println("El inventario está vacío.");
		} else {
			System.out.println("Inventario:");
			for (Producto producto : inventario) {
				System.out.println(producto);
			}
		}
	}

	public List<Producto> getInventario() {
		return inventario;
	}
}
