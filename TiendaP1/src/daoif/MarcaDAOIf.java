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
import pojo.Marca;

/**
 *
 * @author Fernando
 */
public interface MarcaDAOIf {
    public abstract int insertaMarca(Marca pojo);
    public abstract boolean eliminaMarca(int id);
    public abstract boolean modificaMarca(int id);
    public abstract Marca buscaMarca(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Marca> cargarCombo();
    public abstract DefaultListModel<Marca> cargarLista();
    public abstract Marca inflaCategoria(ResultSet rs);
}
