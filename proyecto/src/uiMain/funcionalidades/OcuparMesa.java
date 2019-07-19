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
		System.out.println("Ingrese el codigo de la mesa que desea ocupar:");
		int codigo = entrada.nextInt();
		System.out.println("Ingrese su correo:");
		String correo = entrada.next();
		//con el correo del usuario obtengo al usuario que voy a ingresar como parametro, how ??
		//Mesa.ocuparMesa(codigo,);
		
	}
	
	public String toString() {
		return "Ocupar una de las mesas disponibles del restaurante";
	}
}
