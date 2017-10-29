/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoif.Comida_del_diaDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Comida_del_dia;

/**
 *
 * @author Fernando
 */
public class Comida_del_diaDAO implements Comida_del_diaDAOIf{
    
    private static final String TABLE="comida_del_dia";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nombre, fecha, descripcion, precio) VALUES (?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idcomida_del_dia = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idcomida_del_dia=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nombre=?, fecha=?, descripcion=?, precio=? WHERE idcomida_del_dia=?";

    Comida_del_diaDAO() {
    }
    
    public static Comida_del_diaDAO getInstance() {
        return Comida_del_diaDAOHolder.INSTANCE;
    }
    
    private static class Comida_del_diaDAOHolder {

        private static final Comida_del_diaDAO INSTANCE = new Comida_del_diaDAO();
    }
    
    @Override
    public int insertaComida_del_dia(Comida_del_dia pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            st.setDate(2, pojo.getFecha());
            st.setString(3, pojo.getDescripción());
            st.setDouble(4, pojo.getPrecio());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar comida del dia" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaComida_del_dia(int id) {
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
            System.out.println("Error al eliminar comida del día " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaComida_del_dia(Comida_del_dia pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setDate(2, pojo.getFecha());
            st.setString(3, pojo.getDescripción());
            st.setDouble(4, pojo.getPrecio());
            st.setInt(5, pojo.getIdComida_del_dia());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar comida del día " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Comida_del_dia buscaComida_del_dia(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Comida_del_dia comida_del_dia = new Comida_del_dia();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                comida_del_dia = inflaComida_del_dia(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar comida del día " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return comida_del_dia;
    }

    @Override
    public DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Nombre", "Fecha", "Precio", "Descripción"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                Comida_del_dia pojo = inflaComida_del_dia(rs);
                ob[0] = pojo.getNombre();
                ob[1] = pojo.getFecha();
                ob[2] = pojo.getPrecio();
                ob[3] = pojo.getDescripción();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla comida del día " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Comida_del_dia> cargarCombo() {
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
                Comida_del_dia comida_del_dia = inflaComida_del_dia(rs);
                combo.addElement(comida_del_dia);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo comida del día "+e);
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo comida del día "+e);
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Comida_del_dia> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comida_del_dia inflaComida_del_dia(ResultSet rs) {
        Comida_del_dia comida_del_dia = new Comida_del_dia();
        try {
            comida_del_dia.setIdComida_del_dia(rs.getInt("idcomida_del_dia"));
            comida_del_dia.setNombre(rs.getString("nombre"));
            comida_del_dia.setFecha(rs.getDate("fecha"));
            comida_del_dia.setDescripción(rs.getString("descripcion"));
            comida_del_dia.setPrecio(rs.getDouble("precio"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar comida del día " + ex);
        }
        return comida_del_dia;
    }
    
}
