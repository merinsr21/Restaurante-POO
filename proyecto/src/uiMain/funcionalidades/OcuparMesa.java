package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.*;
import java.util.*;

public class OcuparMesa extends OpcionDeMenu{

	public OcuparMesa(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el código de la mesa que desea ocupar:");
		int codigo = entrada.nextInt();	
		System.out.println("Ingrese la cantidad de sillas que desea: ");
		int numeroSillas = entrada.nextInt();
		System.out.println("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		System.out.println(Mesa.ocuparMesa(codigo,numeroSillas,nombreUsuario));
	}
	
	public String toString() {
		return "Ocupar una mesa";
	}
}
