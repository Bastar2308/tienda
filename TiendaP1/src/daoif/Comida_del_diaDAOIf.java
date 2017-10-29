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
import pojo.Comida_del_dia;

/**
 *
 * @author Fernando
 */
public interface Comida_del_diaDAOIf {
    public abstract int insertaComida_del_dia(Comida_del_dia pojo);
    public abstract boolean eliminaComida_del_dia(int id);
    public abstract boolean modificaComida_del_dia(Comida_del_dia pojo);
    public abstract Comida_del_dia buscaComida_del_dia(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Comida_del_dia> cargarCombo();
    public abstract DefaultListModel<Comida_del_dia> cargarLista();
    public abstract Comida_del_dia inflaComida_del_dia(ResultSet rs);
}
