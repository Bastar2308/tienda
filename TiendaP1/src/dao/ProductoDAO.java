/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.ProductoDAOIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Producto;


public class ProductoDAO implements ProductoDAOIf{
    
    private static final String TABLE="producto";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (nombre, precio, stock, detalles, categoria_idCategoria, marca_idMarca, codigo) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idProducto = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idProducto=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET nombre=?, precio=?, stock=?, detalles=?, categoria_idCategoria=?, marca_idMarca=?, codigo=? WHERE idProducto=?";

    @Override
    public int insertaProducto(Producto pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getPrecio());
            st.setInt(3, pojo.getStock());
            st.setString(4, pojo.getDetalles());
            st.setInt(5, pojo.getCategoria_idCategoria());
            st.setInt(6, pojo.getMarca_idMarca());
            st.setString(7, pojo.getCodigo());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar Producto" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificaProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscaCategoria(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultComboBoxModel<Producto> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel<Producto> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto inflaCategoria(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
