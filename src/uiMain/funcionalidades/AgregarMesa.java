package uiMain.funcionalidades;

import uiMain.*;
import java.util.*;
import gestorAplicacion.logic.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.Mesa;

public class AgregarMesa extends OpcionDeMenu{

		public AgregarMesa(String pos) {
			super(pos);
		}
		
		public void ejecutar() {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Ingrese codigo(0-99) y el numero de sillas de la mesa que desea agregar");
			String codigo = entrada.next();
			String numeroDeSillas = entrada.next();
			System.out.println(Mesa.ValidacionMesa(codigo,numeroDeSillas));
		} 
		
		public String toString() {
			return "Agregar una mesa";
		}
}
