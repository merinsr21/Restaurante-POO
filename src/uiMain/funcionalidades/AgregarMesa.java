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
			String print = "El código ingresado no se encuentra en el intervalo pedido(0-99)";
			if(Integer.parseInt(codigo) >= 0 && Integer.parseInt(codigo) <= 99) {
				if(!Datos.mesas.containsKey(codigo)) {
					String numeroDeSillas = entrada.next();
					Mesa.crearMesa(codigo, numeroDeSillas, "false");
					print = "La mesa ha sido creada con exito";
				}
				else {
					print = "Ya existe una mesa con ese codigo";
				}
			}
			System.out.println(print);
		} 
		
		public String toString() {
			return "Agregar una mesa";
		}
}
