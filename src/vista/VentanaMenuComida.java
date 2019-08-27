package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import controlador.tableButton.ControlTableButtonComidas;
import controlador.tableButton.TablaMouseListener;
import modelo.gestorAplicacion.logic.Comida;
import vista.JTableButtonRenderer;
import vista.TablaModelo;

public class VentanaMenuComida extends JPanel implements InterfazVista{
	//JTable tabla;
	public VentanaMenuComida(){
		JPanel panelMenu = new JPanel();
		TextArea texto = new TextArea(arreglo(), 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		texto.setFont(new Font("arial", Font.HANGING_BASELINE, 15));
		texto.setEditable(false);
		texto.setBackground(Color.WHITE);
		panelMenu.add(texto);	
		
	}
	public String arreglo() {
		String texto = "";
		for(Comida comida : Comida.obtenerComidasDisponibles()) {
			texto += "/n"+comida.toString();
		}
		return texto;
	}
	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);		
	}
	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		
	}
	

}
/*HashMap<String, Comida> menu = Comida.menuComidas;
String nombreBoton = "Ordenar";
String [] nombreColumnas = {"Código", "Nombre", "Precio", nombreBoton};
Object [][] datos = new Object [menu.size()][nombreColumnas.length];
int contador = 0;
for(Map.Entry<String, Comida> producto : menu.entrySet()) {
	Comida item = producto.getValue();
	
	JButton boton = new JButton(nombreBoton);
	boton.setActionCommand(item.getCodigoComida());
	boton.addActionListener(new ControlTableButtonComidas());
	
	datos[contador][0]= item.getCodigoComida();
	datos[contador][1]= item.getNombreComida();
	datos[contador][2]= item.getPrecioComida();
	datos[contador][3]= boton;
	contador++;
}
tabla = new JTable(new TablaModelo(nombreColumnas,datos)); 
tabla.setFillsViewportHeight(true);
TableCellRenderer buttonRenderer = new JTableButtonRenderer();
tabla.getColumn(nombreBoton).setCellRenderer(buttonRenderer);
tabla.addMouseListener(new TablaMouseListener(tabla));

JScrollPane scrollPane = new JScrollPane(tabla);
add(scrollPane);
}
@Override
public void arranca() {
setVisible(true);	
}
@Override
public void cerrar() {
this.setVisible(false);
}*/
