package com.co.maio.test;

import com.co.maio.modelo.Gestor;
import com.co.maio.modelo.Producto;

public class TestGestor {

	public static void main(String[] args) {
		Gestor gestor = new Gestor();
		Producto manzana = new Producto("Manzana", 15, 2000);
		Producto pera = new Producto("Pera", 10, 2500);
		Producto naranja = new Producto("Naranja", 10, 3500);

		gestor.modificarCantidad(naranja, 30);
	}
}
