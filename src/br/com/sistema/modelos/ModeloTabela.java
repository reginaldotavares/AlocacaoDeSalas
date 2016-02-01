package br.com.sistema.modelos;


import br.com.sistema.modelos.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{
 
    //constantes p/identificar colunas
    private final int NOME=0;
    private final int EMAIL=1;
    private final int PAPEL=2;
    private final int MATRICULA=3;
 
    private final String colunas[]={"Nome:","E-mail:","Papael:","Matricula:"};
    private final List<Usuario> dados;//usamos como dados uma lista genérica de Usuario
 
    public ModeloTabela(List<Usuario> dados) {
        //seto os dados no construtor
        this.dados=dados;
    }
 
    @Override
    public int getColumnCount() {
        //retorna o total de colunas
        return colunas.length;
    }
 
    @Override
    public int getRowCount() {
        //retorna o total de linhas na tabela
        return dados.size();
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
        case NOME:
            return String.class;
        case EMAIL:
            return String.class;
        case PAPEL:
            return String.class;
        case MATRICULA:
            return int.class;
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha
 
        //pega o dados corrente da linha
       Usuario usuario=dados.get(rowIndex);
 
        //retorna o valor da coluna
        switch (columnIndex) {
        case NOME:
            return usuario.getNome();
        case EMAIL:
            return usuario.getEmail();
        case PAPEL:
            return usuario.getPapel();
        case MATRICULA:
            return usuario.getMatricula();
       
        default:
            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //metodo identifica qual coluna é editavel
 
        //só iremos editar a coluna BENEFICIO, 
        //que será um checkbox por ser boolean
        
            return true;
 
       
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario usuario=dados.get(rowIndex);
 
        
    }
 
    //Métodos abaixo são para manipulação de dados
 
    /**
     * retorna o valor da linha indicada
     * @param rowIndex
     * @return
     */
    public Usuario getValue(int rowIndex){
        return dados.get(rowIndex);
    }
 
    /**
     * retorna o indice do objeto
     * @param usuario
     * @return
     */
    public int indexOf(Usuario usuario) {
        return dados.indexOf(usuario);
    }
 
    /**
     * add um usuario á lista
     * @param usuario
     */
    public void onAdd(Usuario usuario) {
        dados.add(usuario);
        fireTableRowsInserted(indexOf(usuario), indexOf(usuario));
    }
 
    /**
     * add uma lista de usuarios
     * @param dadosIn
     */
    public void onAddAll(List<Usuario> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }
 
    /**
     * remove um registro da lista, através do indice
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    /**
     * remove um registro da lista, através do objeto
     * @param usuario
     */
    public void onRemove(Usuario usuario) {
        int indexBefore=indexOf(usuario);//pega o indice antes de apagar
        dados.remove(usuario);  
        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }
 
}