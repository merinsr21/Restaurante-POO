package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.*;
import BaseDatos.*;
import java.util.*;

public class VerCalificacion extends OpcionDeMenu {

	public VerCalificacion(String pos) {
		super(pos);
	}
	
	public void ejecutar() {                                
		Scanner entrada = new Scanner(System.in); 
		System.out.print("Ingrese el código de la comida: ");
		String codigo = entrada.next();
		int cont = 0;
		int sum = 0;
		//poner el metodo en la clase Calificacion 
		for(Calificacion r: Calificacion.getCalificaciones()) {
			if(r.getCodigoCa().equals(codigo)) {
				cont ++;
				sum += Integer.parseInt(r.getPuntaje());
			}
		}
		System.out.println("La comida con código "+codigo+" tiene "+cont+" calificaciones, y un total de "+sum+"/"+(5*cont)+" puntos");
	}
	
	public String toString() {
		return "Ver calificación de una comida específica";
	}
}
