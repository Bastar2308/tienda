/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;

/**
 *
 * @author Fernando
 */
public interface CategoriaDAOIf {
    public abstract int insertaCategoria(Categoria pojo);
    public abstract boolean eliminaCategoria(int id);
    public abstract boolean modificaCategoria(int id);
    public abstract Categoria buscaCategoria(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Categoria> cargarCombo();
    public abstract DefaultListModel<Categoria> cargarLista();
}
