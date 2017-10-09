/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.CategoriaDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;


public class CategoriaDAO implements CategoriaDAOIf{

    private static final String TABLE="categoria";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nombre) VALUES (?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idCategoria = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idCategoria=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nombre=? WHERE idCategoria=?";
    
    @Override
    public int insertaCategoria(Categoria pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar categoría" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaCategoria(int id) {
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
            System.out.println("Error al eliminar categoría " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaCategoria(Categoria pojo, int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setInt(2, pojo.getIdCategoria());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar categoría" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Categoria buscaCategoria(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Categoria pojo = new Categoria();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaCategoria(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar  " + e);
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
        String encabezados[] = {"Id","Nombre"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                Categoria pojo = inflaCategoria(rs);
                ob[0] = pojo.getIdCategoria();
                ob[1] = pojo.getNombre();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla categoría " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Categoria> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar categoría");
            while (rs.next()) {
                Categoria categoria = inflaCategoria(rs);
                combo.addElement(categoria);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo categoría");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo categoría");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Categoria> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria inflaCategoria(ResultSet rs) {
        Categoria pojo = new Categoria();
        try {
            pojo.setIdCategoria(rs.getInt("idCategoria"));
            pojo.setNombre(rs.getString("nombre"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar categoria " + ex);
        }
        return pojo;
    }

}
