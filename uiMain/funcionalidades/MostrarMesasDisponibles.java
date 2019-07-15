package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.Mesa;

public class MostrarMesasDisponibles extends OpcionDeMenu {
	
	public MostrarMesasDisponibles(int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("Las siguientes mesas estan disponibles: ");
		for(Mesa r: Mesa.getMesas()) {
			if(r.getOcupada() == false) {
				System.out.println(r);
			}
		}
	}
	
	public String toString() {
		return "Muestra las mesas que estan disponibles para ser ocupadas por un usuaroio";
	}
}
