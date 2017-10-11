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
import pojo.Grupo;

/**
 *
 * @author Fernando
 */
public interface GrupoDAOIf {
    public abstract int insertaGrupo(Grupo pojo);
    public abstract boolean eliminaGrupo(int id);
    public abstract boolean modificaGrupo(Grupo pojo, int id);
    public abstract Grupo buscaGrupo(int id);
    public abstract DefaultTableModel cargarTabla();
    public abstract DefaultComboBoxModel<Grupo> cargarCombo();
    public abstract DefaultListModel<Grupo> cargarLista();
    public abstract Grupo inflaGrupo(ResultSet rs);
}
