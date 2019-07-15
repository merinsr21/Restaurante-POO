package uiMain;

public abstract class OpcionDeMenu {
	
	private int pos;
	
	
	public OpcionDeMenu() {
		
	}
	
	public OpcionDeMenu(int pos) {
		this.pos = pos;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public abstract void ejecutar();
	
	public abstract String toString();
	
	public static void mostrarFuncionalidades() {            //mostrar funcionalidades de la opcion de menu.
		
	}
}
