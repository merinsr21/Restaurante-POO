package uiMain;

import gestorAplicacion.logic.*;
import uiMain.funcionalidades.*;

public class Main {

	public static void main(String[] args) {
		MostrarMenu mostrar = new MostrarMenu(1);
		AgregarComida agregar = new AgregarComida(3);
		OrdenarMenu ordenar =  new OrdenarMenu(2);
		BorrarComida borrar = new BorrarComida(4);
		
		agregar.ejecutar();
		agregar.ejecutar();
		agregar.ejecutar();
		agregar.ejecutar();
		mostrar.ejecutar();
		ordenar.ejecutar();
		mostrar.ejecutar();
	}

}
