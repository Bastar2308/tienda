/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Usuario;

/**
 *
 * @author Profesor Bastar
 */
public interface UsuarioDAOIf {
    
    public abstract int insertaUsuario(Usuario pojo);
    public abstract boolean eliminaUsuario(int id);
    public abstract boolean modificaUsuario(int id);
    public abstract Usuario buscaUsuario(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Usuario> cargarCombo();
    public abstract DefaultListModel<Usuario> cargarLista();

}