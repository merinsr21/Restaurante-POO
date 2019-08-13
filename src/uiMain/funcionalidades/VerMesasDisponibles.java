package uiMain.funcionalidades;

import uiMain.*;

import java.util.Map;

import modelo.BaseDatos.*;
import modelo.gestorAplicacion.logic.Mesa;

public class VerMesasDisponibles extends OpcionDeMenu {
	
	public VerMesasDisponibles(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("Las siguientes mesas están disponibles: ");
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.getOcupada().equals("false")) {
				System.out.println(mesaOb);
			}
		}
	}
	
	public String toString() {
		return "Ver mesas disponibles en el restaurante";
	}
}
