/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.VentaDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;
import pojo.Venta;


public class VentaDAO implements VentaDAOIf{

    private static final String TABLE="venta";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nota, total, cliente_idCliente) VALUES (?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idVenta = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idVenta=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nota=?, fechahora=?, total=?, cliente_idCliente=? WHERE idVenta=?";
    
    private VentaDAO() {
    }
    
    public static VentaDAO getInstance() {
        return VentaDAOHolder.INSTANCE;
    }
    
    private static class VentaDAOHolder {

        private static final VentaDAO INSTANCE = new VentaDAO();
    }
    
    @Override
    public int insertaVenta(Venta pojo) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNota());
            st.setDouble(2, pojo.getTotal());
            st.setInt(3, pojo.getCliente_idCliente());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
            System.out.println("Error al insertar venta" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaVenta(int id) {
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
            System.out.println("Error al eliminar venta " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaVenta(Venta pojo, int idVenta) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNota());
            st.setTimestamp(2, pojo.getFechahora());
            st.setDouble(3, pojo.getTotal());
            st.setInt(4, pojo.getCliente_idCliente());
            st.setInt(5, idVenta);
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar venta" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Venta buscaVenta(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Venta pojo = new Venta();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaVenta(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar venta " + e);
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
        String encabezados[] = {"Id","Nota","Fecha/Hora","Total","Cliente"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                Venta pojo = inflaVenta(rs);
                Cliente cliente = ClienteDAO.getInstance().buscaCliente(pojo.getCliente_idCliente());
                ob[0] = pojo.getIdVenta();
                ob[1] = pojo.getNota();
                ob[2] = pojo.getFechahora();
                ob[3] = pojo.getTotal();
                ob[4] = cliente.getIdCliente();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla venta " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Venta> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar venta");
            while (rs.next()) {
                Venta venta = inflaVenta(rs);
                combo.addElement(venta);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo venta");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo venta");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Venta> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta inflaVenta(ResultSet rs) {
        Venta pojo = new Venta();
        try {
            pojo.setIdVenta(rs.getInt("idVenta"));
            pojo.setNota(rs.getString("nota"));
            pojo.setFechahora(rs.getTimestamp("fechahora"));
            pojo.setTotal(rs.getDouble("total"));
            pojo.setCliente_idCliente(rs.getInt("cliente_idCliente"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar venta " + ex);
        }
        return pojo;
    }

}
