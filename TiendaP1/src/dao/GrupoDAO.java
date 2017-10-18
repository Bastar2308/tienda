/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.GrupoDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Grupo;


public class GrupoDAO implements GrupoDAOIf{

    private static final String TABLE="grupo";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nombre, nivel) VALUES (?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idGrupo = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idGrupo=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nombre=?, nivel=? WHERE idGrupo=?";
    
    @Override
    public int insertaGrupo(Grupo pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            st.setString(2, pojo.getNivel());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar grupo" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaGrupo(int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar grupo " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaGrupo(Grupo pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setString(2, pojo.getNivel());
            st.setInt(3, pojo.getIdGrupo());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar grupo " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Grupo buscaGrupo(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Grupo pojo = new Grupo();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaGrupo(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar grupo " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    @Override
    public DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Id","Nombre","Nivel"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                Grupo pojo = inflaGrupo(rs);
                ob[0] = pojo.getIdGrupo();
                ob[1] = pojo.getNombre();
                ob[2] = pojo.getNivel();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla grupo " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Grupo> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar grupo");
            while (rs.next()) {
                Grupo grupo = inflaGrupo(rs);
                combo.addElement(grupo);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo grupo");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo grupo");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Grupo> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grupo inflaGrupo(ResultSet rs) {
        Grupo pojo = new Grupo();
        try {
            pojo.setIdGrupo(rs.getInt("idGrupo"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setNivel(rs.getString("nivel"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar grupo " + ex);
        }
        return pojo;
    }

}
