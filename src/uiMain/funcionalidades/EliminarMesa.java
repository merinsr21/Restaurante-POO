package uiMain.funcionalidades;
import java.util.Map;
import java.util.Scanner;

import BaseDatos.Datos;
import gestorAplicacion.logic.Mesa;
import uiMain.*;


public class EliminarMesa extends OpcionDeMenu {

	public EliminarMesa(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el codigo de la mesa que desea eliminar: ");
		String codigo = entrada.next();
		for(Map.Entry<String, Mesa> mesa : Datos.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.getCodigoMesa().equals(codigo)) {
				Datos.mesas.remove(codigo);
			}
		}
	}
	
	public String toString() {
		return "Eliminar una mesa";
	}
}
