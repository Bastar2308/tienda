/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.Alimento_Prohibido_ClienteDAOIf;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Alimento_Prohibido_Cliente;


public class Alimento_Prohibido_ClienteDAO implements Alimento_Prohibido_ClienteDAOIf{

    private static final String TABLE="alimentos_prohibidos_cliente";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (cliente_idCliente, producto_idProducto, fecha_inicio, fecha_fin, descripcion) VALUES (?,?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idCliente = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idCliente=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET tipoCliente=? WHERE idCliente=?";
    private static final String SQL_OBTENER_PRODUCTOS = "SELECT Producto.numeroIdentificacion FROM Producto, Venta "
            + "INNER JOIN Venta_has_Producto "
            + "ON venta.idVenta = Venta_has_Producto.Venta_idVenta "
            + "WHERE Producto.idProducto = Venta_has_Producto.Producto_idProducto and Venta.idVenta = ?";
    
    @Override
    public int insertaAlimento_Prohibido_Cliente(Alimento_Prohibido_Cliente pojo) {
//        Connection con = null;
//        PreparedStatement st = null;
//        int id = 0;
//        try {
//            con = Conexion.getConnection();
//            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
//            st.setString(1, pojo.getNombre());
//            st.setString(2, pojo.getApellidos());
//            st.setString(3, pojo.getTelefono());
//            st.setString(4, pojo.getCelular());
//            st.setString(5, pojo.getTipoCliente());
//            id = st.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("Error al insertar Cliente" + e);
//        } finally {
//            Conexion.close(con);
//            Conexion.close(st);
//        }
//        return id;
        return 0;
    }

    @Override
    public boolean eliminaAlimento_Prohibido_Cliente(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
