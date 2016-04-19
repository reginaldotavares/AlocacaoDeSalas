/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Reginaldo
 */
public abstract class SisLocAbstractTableModel<E> extends AbstractTableModel {
    
    protected List<E> dados;
    private String[] colunas;

    public SisLocAbstractTableModel() {
        this.dados = new ArrayList<>();
        this.colunas = setColumns();
    }
    
    public void addElement(List<E> listaMaterial){
        dados.addAll(listaMaterial);
        fireTableDataChanged();
    }
    
    public void RemoveAllElements(int... rowIndexs){
        this.dados.removeAll(getElements(rowIndexs));
    }
    
    public List<E> removeElements(int... rowIndexs){
        List<E> elementos = new ArrayList<>();
        for(int i=0;i<rowIndexs.length;i++){
            elementos.add(this.dados.get(rowIndexs[i]));
        }
        this.dados.removeAll(getElements(rowIndexs));
        fireTableDataChanged();
        return elementos;
    }
    
    public E getMaterial(int rowIndex){
        return this.dados.get(rowIndex);
    }
    
    public List<E> getElements(int... indexes) {
        List<E> elementos = new ArrayList<>();
        for(int i=0;i<indexes.length;i++){
            elementos.add(this.dados.get(indexes[i]));
        }
        return elementos;
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    
    public abstract String[] setColumns();
}
