package controlador.tableButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.gestorAplicacion.logic.Comida;
import modelo.gestorAplicacion.users.Usuario;

public class ControlTableButtonComidas implements ActionListener{



	public void actionPerformed(ActionEvent e) {
		String codigo = e.getActionCommand();
		Comida comida = Comida.getComidaConCodigo(codigo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, 
               "Cantidad de "+comida.getNombreComida()+" que desea ordenar"));
        Usuario.usuario.getMiCarrito().añadirComida(comida, cantidad);
    }
}