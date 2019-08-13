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
		System.out.println("Ingrese el c�digo(100-199), nombre, precio y calorias de la comida que desea agregar en el men�: ");	
		String codigoComida = entrada.next();
		String nombreComida = entrada.next();
		int precioComida = entrada.nextInt();
		String calorias = entrada.next();
		System.out.print(Comida.ValidacionComida(codigoComida, nombreComida, precioComida, calorias));
	}
	
	public String toString() {
		return "Agregar comida al men�";
	}
}
