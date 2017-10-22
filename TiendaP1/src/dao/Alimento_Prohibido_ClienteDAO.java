/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.Alimento_Prohibido_ClienteDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Alimento_Prohibido_Cliente;


public class Alimento_Prohibido_ClienteDAO implements Alimento_Prohibido_ClienteDAOIf{

    private static final String TABLE="prohibido";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (cliente_idCliente, producto_idProducto, fecha_inicio, fecha_fin, descripcion) VALUES (?,?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idCliente = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE Cliente_idCliente=? and Producto_idProducto=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET tipoCliente=? WHERE idCliente=?";
    private static final String SQL_OBTENER_PRODUCTOS = "SELECT Producto.numeroIdentificacion FROM Producto, Venta "
            + "INNER JOIN Venta_has_Producto "
            + "ON venta.idVenta = Venta_has_Producto.Venta_idVenta "
            + "WHERE Producto.idProducto = Venta_has_Producto.Producto_idProducto and Venta.idVenta = ?";
    
    Alimento_Prohibido_ClienteDAO() {
    }
    
    public static Alimento_Prohibido_ClienteDAO getInstance() {
        return Alimento_Prohibido_ClienteDAOHolder.INSTANCE;
    }
    
    private static class Alimento_Prohibido_ClienteDAOHolder {

        private static final Alimento_Prohibido_ClienteDAO INSTANCE = new Alimento_Prohibido_ClienteDAO();
    }
    
    @Override
    public int insertaAlimento_Prohibido_Cliente(Alimento_Prohibido_Cliente pojo) {
        Connection con = null;
        PreparedStatement ps = null;
        int x = 0;
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pojo.getCliente_idCliente());
            ps.setInt(2, pojo.getProducto_idProducto());
            ps.setDate(3, pojo.getFecha_inicio());
            ps.setDate(4, pojo.getFecha_fin());
            ps.setString(5, pojo.getDescripcion());
            
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar alimento_prohibido "+e);
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
        }
        return x;
    }

    @Override
    public boolean eliminaAlimento_Prohibido_Cliente(int id, int id2) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            st.setInt(2, id2);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar alimento prohibido " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaAlimento_Prohibido_Cliente(Alimento_Prohibido_Cliente pojo, int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alimento_Prohibido_Cliente buscaAlimento_Prohibido_Cliente(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultComboBoxModel<Alimento_Prohibido_Cliente> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel<Alimento_Prohibido_Cliente> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
