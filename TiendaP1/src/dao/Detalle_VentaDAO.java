/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.Detalle_VentaDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Detalle_Venta;


public class Detalle_VentaDAO implements Detalle_VentaDAOIf{

    private static final String TABLE="detalle_venta";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (venta_idventa, producto_idproducto, cantidad, subtotal) VALUES (?,?,?,?)";
    
    private Detalle_VentaDAO() {
    }
    
    public static Detalle_VentaDAO getInstance() {
        return Detalle_VentaDAOHolder.INSTANCE;
    }

    @Override
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

    @Override
    public boolean eliminaDetalle_Venta(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificaDetalle_Venta(Detalle_Venta pojo, int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detalle_Venta buscaCategoria(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultComboBoxModel<Detalle_Venta> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel<Detalle_Venta> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static class Detalle_VentaDAOHolder {

        private static final Detalle_VentaDAO INSTANCE = new Detalle_VentaDAO();
    }
    
    
    
}
