/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Venta;

/**
 *
 * @author Fernando
 */
public interface VentaDAOIf {
    public abstract int insertaVenta(Venta pojo);
    public abstract boolean eliminaVenta(int id);
    public abstract boolean modificaVenta(int id);
    public abstract Venta buscaCategoria(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Venta> cargarCombo();
    public abstract DefaultListModel<Venta> cargarLista();
}
