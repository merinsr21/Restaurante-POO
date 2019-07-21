package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.Mesa;

public class VerMesasDisponibles extends OpcionDeMenu {
	
	public VerMesasDisponibles(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("Las siguientes mesas están disponibles: ");
		for(Mesa r: Mesa.getMesas()) {
			if(r.getOcupada() == false) {
				System.out.println(r);
			}
		}
	}
	
	public String toString() {
		return "Ver mesas disponibles en el restaurante";
	}
}
