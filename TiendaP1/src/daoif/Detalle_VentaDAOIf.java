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
import pojo.Detalle_Venta;

/**
 *
 * @author Fernando
 */
public interface Detalle_VentaDAOIf {
    public abstract int insertaDetalle_Venta(Detalle_Venta pojo);
    public abstract boolean eliminaDetalle_Venta(int id);
    public abstract boolean modificaDetalle_Venta(Detalle_Venta pojo);
    public abstract Detalle_Venta buscaCategoria(int id, int id2);
    public abstract DefaultTableModel cargarTabla(int id);
    public abstract DefaultComboBoxModel<Detalle_Venta> cargarCombo();
    public abstract DefaultListModel<Detalle_Venta> cargarLista();
    public abstract Detalle_Venta inflaVenta(ResultSet rs);
}
