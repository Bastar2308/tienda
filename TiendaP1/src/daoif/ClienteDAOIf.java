/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;

/**
 *
 * @author Fernando
 */
public interface ClienteDAOIf {

    public abstract boolean restaSaldo(String idClienteint, String cantidadARestar);

    public abstract int insertaCliente(Cliente pojo, String foto);

    public abstract boolean eliminaCliente(int id);

    public abstract boolean modificaCliente(Cliente pojo, String path);

    public abstract Cliente buscaCliente(int id);

    public abstract DefaultTableModel cargarTabla();

    public abstract DefaultTableModel cargarClientes();

    public abstract DefaultComboBoxModel<Cliente> cargarCombo();

    public abstract DefaultListModel<Cliente> cargarLista();

    public abstract Cliente inflaCliente(ResultSet rs);
    
    public abstract int obtenerRecienInsertado();
    
    public abstract Cliente obtenerClienteConAdeudos();
}
