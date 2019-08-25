package uiMain.funcionalidades;

import java.util.*;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.logic.Comida;
import uiMain.*;

public class AgregarComida extends OpcionDeMenu {
	
	public AgregarComida(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el código, nombre, precio, calorias y disponibilidad de la comida que desea agregar en el menú: ");	
		String codigoComida = entrada.next();
		String nombreComida = entrada.next();
		String precioComida = entrada.next();
		String calorias = entrada.next();
		String disponible = entrada.next();
		System.out.print(Comida.ValidacionComida(codigoComida, nombreComida, precioComida, calorias, disponible));
	}
	
	public String toString() {
		return "Agregar comida al menú";
	}
}
