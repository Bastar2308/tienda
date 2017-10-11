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
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;
import pojo.Marca;
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
            System.out.println("Error al insertar producto" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaProducto(int id) {
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
            System.out.println("Error al eliminar producto " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaProducto(Producto pojo, int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getPrecio());
            st.setInt(3, pojo.getStock());
            st.setString(4, pojo.getDetalles());
            st.setInt(5, pojo.getCategoria_idCategoria());
            st.setInt(6, pojo.getMarca_idMarca());
            st.setString(7, pojo.getCodigo());
            st.setInt(8, pojo.getIdProducto());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar producto " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Producto buscaCategoria(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Producto pojo = new Producto();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaProducto(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar producto " + e);
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
        String encabezados[] = {"Id","Nombre", "Precio", "Stock", "Detalles", "Categoría", "Marca", "Codigox"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[8];
                Producto pojo = inflaProducto(rs);
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Categoria categoria = categoriaDAO.buscaCategoria(pojo.getCategoria_idCategoria());
                MarcaDAO marcaDAO = new MarcaDAO();
                Marca marca = marcaDAO.buscaMarca(pojo.getMarca_idMarca());
                ob[0] = pojo.getIdProducto();
                ob[1] = pojo.getNombre();
                ob[2] = pojo.getPrecio();
                ob[3] = pojo.getStock();
                ob[4] = pojo.getDetalles();
                ob[5] = categoria.getNombre();
                ob[6] = marca.getNombre();
                ob[7] = pojo.getCodigo();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla producto " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Producto> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar producto");
            while (rs.next()) {
                Producto producto = inflaProducto(rs);
                combo.addElement(producto);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo producto");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo producto");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Producto> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto inflaProducto(ResultSet rs) {
        Producto pojo = new Producto();
        try {
            pojo.setIdProducto(rs.getInt("idProducto"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setPrecio(rs.getDouble("precio"));
            pojo.setStock(rs.getInt("stock"));
            pojo.setNombre(rs.getString("detalles"));
            pojo.setCategoria_idCategoria(rs.getInt("categoria_idCategoria"));
            pojo.setMarca_idMarca(rs.getInt("marca_idMarca"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar categoria " + ex);
        }
        return pojo;
    }

}
