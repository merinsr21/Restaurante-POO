package uiMain.funcionalidades;

import uiMain.*;
import modelo.gestorAplicacion.logic.*;

import java.util.*;

public class VerCalificacion extends OpcionDeMenu {

	public VerCalificacion(String pos) {
		super(pos);
	}
	
	public void ejecutar() {                                
		Scanner entrada = new Scanner(System.in); 
		System.out.print("Ingrese el código de la comida: ");
		String codigo = entrada.next();
		int contador = 0;
		int suma = 0;
		//poner el metodo en la clase Calificacion 
		for(Calificacion buscador: Calificacion.getCalificaciones()) {
			if(buscador.getCodigoCa().equals(codigo)) {
				contador ++;
				suma += buscador.getPuntaje();
			}
		}
		System.out.println("La comida con código "+codigo+" tiene "+contador+" calificaciones, y un total de "+suma+"/"+(5*contador)+" puntos");
	}
	
	public String toString() {
		return "Ver calificación de una comida específica";
	}
}
