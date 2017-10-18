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
import pojo.Producto;

/**
 *
 * @author Fernando
 */
public interface ProductoDAOIf {
    public abstract int insertaProducto(Producto pojo);
    public abstract boolean eliminaProducto(int id);
    public abstract boolean modificaProducto(Producto pojo);
    public abstract Producto buscaCategoria(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Producto> cargarCombo();
    public abstract DefaultListModel<Producto> cargarLista();
    public abstract Producto inflaProducto(ResultSet rs);
}
