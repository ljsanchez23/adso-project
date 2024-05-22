package com.co.maio.modelo;

/**
 * Representa el producto a agregar en el sistema
 */
public class Producto {

	// Atributos de la clase producto
	private String nombre;
	private int cantidad;
	private double precio;

	// Constructor de la clase producto
	public Producto(String nombre, int cantidad, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Metodo que permite crear una descripcion total del objeto
	 */
	@Override
	public String toString() {
		return "Productos{" + ", nombre='" + nombre + '\'' + ", cantidad=" + cantidad + ", precio=" + precio + '}';
	}
}