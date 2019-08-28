package controlador.tableButton;

import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.gestorAplicacion.logic.Comida;
import modelo.gestorAplicacion.users.Usuario;

import vista.*;

public class ControlTableButtonPedidos implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String codigo = e.getActionCommand();
		Comida producto = Comida.getComidaConCodigo(codigo);
        Object [] textoDeOpciones = {"Si", "No"};
		int opcion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el producto del pedido?"+producto.getNombreComida(), "Eliminar el producto del pedido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoDeOpciones, null);
        if(opcion == 0) {
        	Usuario.usuario.getMiCarrito().borrarComida(producto);
        	VentanaPrincipal.contenedor.removeAll();
        	VentanaPrincipal.contenedor.add( new PanelPedido());
        	VentanaPrincipal.ventana.pack();
        }
        
    }
}