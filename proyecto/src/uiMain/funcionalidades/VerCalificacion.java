package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.*;
import BaseDatos.*;
import java.util.*;

public class VerCalificacion extends OpcionDeMenu {

	public VerCalificacion(String pos) {
		super(pos);
	}
	
	public void ejecutar() {                                //NO FUNCIONA.
		Scanner entrada = new Scanner(System.in); 
		System.out.print("Ingrese el codigo de la comida :");
		String codigo = entrada.next();
		int cont = 0;
		int sum = 0;
		for(Calificacion r: Calificacion.getCalificaciones()) {
			if(r.getCodigo().equals(codigo)) {
				cont ++;
				sum += Integer.parseInt(r.getPuntaje());
			}
		}
		System.out.println("La comida con codigo "+codigo+" tiene "+cont+" calificaciones, y un total de "+sum+"/"+(5*cont)+" puntos");
	}
	
	public String toString() {
		return "Mostrar calificacion de una comida especifica";
	}
}
