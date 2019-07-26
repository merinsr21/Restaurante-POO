package uiMain;

import gestorAplicacion.logic.*;
import uiMain.funcionalidades.*;
import gestorAplicacion.users.*;

public class Main1 {

	public static void main(String[] args) {
		VerMenu mostrar = new VerMenu("1");
		AgregarComida agregar = new AgregarComida("3");
		OrdenarMenu ordenar =  new OrdenarMenu("2");
		BorrarComida borrar = new BorrarComida("4");
		Mesa.crearMesa("1", "4", "false");
		Mesa.crearMesa("3", "6", "false");
		Mesa.crearMesa("2", "10", "false");
		Mesa.crearMesa("4", "1", "false");
		Usuario usuario = new Usuario("pepe","pepito","caca@gmail.com","caca123");
		Usuario usuario2 = new Usuario("pepe","pepito2","caca@gmail.coma","caca1234");
		VerMesasDisponibles ver = new VerMesasDisponibles("5");
		OcuparMesa ocupar = new OcuparMesa("6");
		HacerPedido pedir = new HacerPedido("7");
		VerFactura verFactura = new VerFactura("8");
		CalcularCalorias calcular = new CalcularCalorias("9");
		Calificar calificar = new Calificar("10");
		VerCalificacion ver1 = new VerCalificacion("11");
		for(Comida comida : Comida.getMenuC()) {
			System.out.println(comida);
		}
		
		agregar.ejecutar();
		agregar.ejecutar();
		//agregar.ejecutar();
		//agregar.ejecutar();
		mostrar.ejecutar();
		//ver.ejecutar();
		//ocupar.ejecutar();
		//pedir.ejecutar();
		//calcular.ejecutar();
		//calificar.ejecutar();
		//calificar.ejecutar();
		//calificar.ejecutar();
		ver1.ejecutar();
		
		
		
		
		
		
		
		

		
	}

}
