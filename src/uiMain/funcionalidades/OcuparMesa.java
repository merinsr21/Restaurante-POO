package uiMain.funcionalidades;

import uiMain.*;

import java.util.*;

import modelo.gestorAplicacion.logic.*;

public class OcuparMesa extends OpcionDeMenu{

	public OcuparMesa(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el número de la mesa que desea ocupar: ");
		String codigo = entrada.next();	
		System.out.print("Ingrese la cantidad de sillas que desea: ");
		String numeroSillas = entrada.next();
		System.out.println(Mesa.ocuparMesa(codigo,numeroSillas));
	}
	
	public String toString() {
		return "Ocupar una mesa";
	}
}
