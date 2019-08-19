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
		System.out.print("Ingrese el n�mero de la mesa que desea ocupar: ");
		String codigo = entrada.next();	
		System.out.print("Ingrese la cantidad de sillas que desea: ");
		int numeroSillas = entrada.nextInt();
		System.out.println(Mesa.ocuparMesa(codigo));
	}
	
	public String toString() {
		return "Ocupar una mesa";
	}
}
