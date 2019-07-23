package uiMain.funcionalidades;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CerrarSesion  extends OpcionDeMenu{
	
	public CerrarSesion(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Su cuenta cerr� exitosamente");
		Main.usuario = null;
		
	}

	@Override
	public String toString() {
		return "Cerrar Sesi�n";
	}

}
