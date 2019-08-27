package vista;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class TablaModelo extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] columnNames;
    private Object[][] data;
    
    public TablaModelo(String[] columnNames, Object[][] data){
    	this.columnNames = columnNames;
    	this.data = data;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return  data[rowIndex][columnIndex];
    }   
}