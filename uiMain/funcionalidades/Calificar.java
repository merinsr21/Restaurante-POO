package uiMain.funcionalidades;
import java.util.*;
import gestorAplicacion.logic.Calificacion;
import uiMain.*;

public class Calificar extends OpcionDeMenu {
	
	public Calificar(int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese el código de la comida que desea calificar: ");
		int codigo = entrada.nextInt();
		System.out.println("Ingrese la calificación de la comida: ");
		int calificacion = entrada.nextInt();
		Calificacion.crearCalificacion(codigo,calificacion);
		
	}
	
	public String toString(){
		return "Califica un comida";
	}
}
