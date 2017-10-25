/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.Alimento_Prohibido_ClienteDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Alimento_Prohibido_Cliente;
import pojo.Producto;


public class Alimento_Prohibido_ClienteDAO implements Alimento_Prohibido_ClienteDAOIf{

    private static final String TABLE="prohibido";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (cliente_idCliente, producto_idProducto, fecha_inicio, fecha_fin, descripcion) VALUES (?,?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE cliente_idCliente = ? and producto_idproducto = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE Cliente_idCliente=? and Producto_idProducto=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET tipoCliente=? WHERE idCliente=?";
    private static final String SQL_OBTENER_PRODUCTOS = "SELECT producto.idProducto FROM producto, cliente "
            + "INNER JOIN prohibido "
            + "ON cliente.idCliente = prohibido.Cliente_idCliente "
            + "WHERE producto.idProducto = prohibido.producto_idProducto and cliente.idCliente = ?";
    
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
        Connection con = null;
        PreparedStatement st = null;
        Alimento_Prohibido_Cliente pojo = new Alimento_Prohibido_Cliente();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            st.setInt(2, id2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaAlimentoProhibido(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar categoria " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    @Override
    public DefaultTableModel cargarTabla(int id) {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Producto", "Fecha inicio", "Fecha fin", "Descripción"};
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
                Alimento_Prohibido_Cliente alimento_Prohibido_Cliente = buscaAlimento_Prohibido_Cliente(id,producto.getIdProducto());
                Object ob[] = new Object[4];
                ob[0] = producto.getNombre();
                ob[1] = alimento_Prohibido_Cliente.getFecha_inicio();
                ob[2] = alimento_Prohibido_Cliente.getFecha_fin();
                ob[3] = alimento_Prohibido_Cliente.getDescripcion();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla alimento prohibido " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Alimento_Prohibido_Cliente> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel<Alimento_Prohibido_Cliente> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Alimento_Prohibido_Cliente inflaAlimentoProhibido(ResultSet rs) {
        Alimento_Prohibido_Cliente pojo = new Alimento_Prohibido_Cliente();
        try {
            pojo.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
            pojo.setProducto_idProducto(rs.getInt("Producto_idProducto"));
            pojo.setFecha_inicio(rs.getDate("fecha_inicio"));
            pojo.setFecha_fin(rs.getDate("fecha_fin"));
            pojo.setDescripcion(rs.getString("descripcion"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar alimento prohibido " + ex);
        }
        return pojo;
    }
}
