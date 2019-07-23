package uiMain.funcionalidades;
import java.util.*;
import gestorAplicacion.logic.Calificacion;
import uiMain.*;

public class Calificar extends OpcionDeMenu {
	
	public Calificar(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese el código de la comida que desea calificar: ");
		String codigo = entrada.next();
		System.out.println("Ingrese la calificación de la comida: ");
		String puntaje = entrada.next();
		Calificacion.crearCalificacion(codigo, puntaje);
		System.out.println("Gracias por calificar, vuelva pronto.");
		//En este punto se termina la secuencia de acciones del usuario ---> liberar mesa.
	}
	
	public String toString(){
		return "Calificar una comida";
	}
}
