/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.MarcaDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Marca;


public class MarcaDAO implements MarcaDAOIf{

    private static final String TABLE="marca";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nombre) VALUES (?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idMarca = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idMarca=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nombre=? WHERE idMarca=?";
    
    @Override
    public int insertaMarca(Marca pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar marca" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaMarca(int id) {
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
            System.out.println("Error al eliminar marca " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaMarca(Marca pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setInt(2, pojo.getIdMarca());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar marca " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Marca buscaMarca(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Marca pojo = new Marca();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaMarca(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar  marca" + e);
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
                Marca pojo = inflaMarca(rs);
                ob[0] = pojo.getIdMarca();
                ob[1] = pojo.getNombre();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla marca " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Marca> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar marca");
            while (rs.next()) {
                Marca marca = inflaMarca(rs);
                combo.addElement(marca);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo marca");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo marca");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Marca> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marca inflaMarca(ResultSet rs) {
        Marca pojo = new Marca();
        try {
            pojo.setIdMarca(rs.getInt("idMarca"));
            pojo.setNombre(rs.getString("nombre"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar marca " + ex);
        }
        return pojo;
    }

}
