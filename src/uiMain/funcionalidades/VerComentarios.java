package uiMain.funcionalidades;

import uiMain.*;
import java.util.*;

import gestorAplicacion.logic.Calificacion;

public class VerComentarios extends OpcionDeMenu {

	public VerComentarios(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el código de la comida: ");
		String codigo = entrada.next();
		for(Calificacion r: Calificacion.getCalificaciones()) {
			if(r.getComida().getCodigo().equals(codigo)){
				System.out.println(r.getComentario());
			}
		}
	}
	
	public String toString() {
		return "Ver los comentarios asociados a una comida";
	}
	
}
