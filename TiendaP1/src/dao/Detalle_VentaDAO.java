/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Detalle_Venta;
import pojo.Producto;

public class Detalle_VentaDAO {

    private static final String TABLE = "detalle_venta";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + " (venta_idventa, producto_idproducto,cantidad, subtotal) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET cantidad=?, subtotal=? WHERE Venta_idVenta=? and Producto_idProducto=?";
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE venta_idVenta = ? and producto_idproducto = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE Venta_idVenta=?";
    private static final String SQL_OBTENER_PRODUCTOS = "SELECT producto.idProducto FROM producto, venta "
            + "INNER JOIN detalle_venta "
            + "ON venta.idVenta = detalle_venta.venta_idventa "
            + "WHERE producto.idProducto = detalle_venta.producto_idProducto and venta.idVenta = ?";

    private Detalle_VentaDAO() {
    }

    public static Detalle_VentaDAO getInstance() {
        return Detalle_VentaDAOHolder.INSTANCE;
    }

    private static class Detalle_VentaDAOHolder {

        private static final Detalle_VentaDAO INSTANCE = new Detalle_VentaDAO();
    }

    public int insertaDetalle_Venta(Detalle_Venta pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, pojo.getVenta_idVenta());
            st.setInt(2, pojo.getProducto_idProducto());
            st.setDouble(3, pojo.getCantidad());
            st.setDouble(4, pojo.getSubtotal());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar detalle_venta" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    public boolean eliminaDetalle_Venta(int id) {
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
            System.out.println("Error al eliminar detalle_venta " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public boolean modificaDetalle_Venta(Detalle_Venta pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setDouble(1, pojo.getCantidad());
            st.setDouble(2, pojo.getSubtotal());
            st.setInt(3, pojo.getVenta_idVenta());
            st.setInt(4, pojo.getProducto_idProducto());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle_venta " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public Detalle_Venta buscaCategoria(int id, int id2) {
        Connection con = null;
        PreparedStatement st = null;
        Detalle_Venta pojo = new Detalle_Venta();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            st.setInt(2, id2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaVenta(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar detalle_venta " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public DefaultTableModel cargarTabla(int id) {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Producto", "Cantidad", "Subtotal"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_OBTENER_PRODUCTOS);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id2 = String.valueOf(rs.getInt("producto.idProducto"));
                Producto producto = ProductoDAO.getInstance().buscaCategoria(Integer.parseInt(id2));
                Detalle_Venta detalle_Venta = buscaCategoria(id, producto.getIdProducto());
                Object ob[] = new Object[3];
                ob[0] = producto.getNombre();
                ob[1] = detalle_Venta.getCantidad();
                ob[2] = detalle_Venta.getSubtotal();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla detalle_venta " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    public DefaultComboBoxModel<Detalle_Venta> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DefaultListModel<Detalle_Venta> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Detalle_Venta inflaVenta(ResultSet rs) {
        Detalle_Venta pojo = new Detalle_Venta();
        try {
            pojo.setVenta_idVenta(rs.getInt("Venta_idVenta"));
            pojo.setProducto_idProducto(rs.getInt("Producto_idProducto"));
            pojo.setCantidad(rs.getDouble("cantidad"));
            pojo.setSubtotal(rs.getDouble("subtotal"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar detalle_venta " + ex);
        }
        return pojo;
    }
}
