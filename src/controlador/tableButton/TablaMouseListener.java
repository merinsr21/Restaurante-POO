package controlador.tableButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

public class TablaMouseListener extends MouseAdapter {
    private final JTable tabla;

    public TablaMouseListener(JTable tabla) {
        this.tabla = tabla;
    }

    public void mouseClicked(MouseEvent e) {
        int columna = tabla.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
        int fila   = e.getY()/tabla.getRowHeight(); //get the row of the button

        /*Checking the row or column is valid or not*/
        if (fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
            Object value = tabla.getValueAt(fila, columna);
            if (value instanceof JButton) {
                /*perform a click event*/
                ((JButton)value).doClick();
            }
        }
    }
}
