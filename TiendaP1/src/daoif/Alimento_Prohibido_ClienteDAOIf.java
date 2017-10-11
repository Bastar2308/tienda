/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Alimento_Prohibido_Cliente;

/**
 *
 * @author Fernando
 */
public interface Alimento_Prohibido_ClienteDAOIf {
    public abstract int insertaAlimento_Prohibido_Cliente(Alimento_Prohibido_Cliente pojo);
    public abstract boolean eliminaAlimento_Prohibido_Cliente(int id, int id2);
    public abstract boolean modificaAlimento_Prohibido_Cliente(Alimento_Prohibido_Cliente pojo, int id, int id2);
    public abstract Alimento_Prohibido_Cliente buscaAlimento_Prohibido_Cliente(int id, int id2);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Alimento_Prohibido_Cliente> cargarCombo();
    public abstract DefaultListModel<Alimento_Prohibido_Cliente> cargarLista();
}
