package br.com.sistema.modelos;


import br.com.sistema.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaMaterial extends SisLocAbstractTableModel<Material>{
 
    public ModeloTabelaMaterial() {
        super();
    }
    
    public ModeloTabelaMaterial(ArrayList<Material> dados) {
        super();
        addElement(dados);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.dados.get(rowIndex).getDescricao();
            default:
                return this.dados.get(rowIndex);
        }
    }

    @Override
    public String[] setColumns() {
        return new String[]{"Material"};
    }
}