package dao;

import auxiliares.GuiTools;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;

/**
 * @author David Vazquez
 *
 * Funcion de la clase:
 *
 */
public class ConsultasDAO {

    public static final String VENTAS_POR_CATEGORIA = "SELECT categoria.nombre AS Categoria, COUNT(categoria.nombre) AS Total FROM detalle_venta\n"
            + "INNER JOIN producto ON detalle_venta.Producto_idProducto =  producto.idProducto\n"
            + "INNER JOIN categoria ON producto.Categoria_idCategoria = categoria.idCategoria\n"
            + "GROUP BY categoria.nombre";
    public static final String VENTAS_POR_MARCA = "SELECT marca.nombre, COUNT(marca.nombre) AS Marca FROM detalle_venta\n"
            + "INNER JOIN producto ON detalle_venta.Producto_idProducto =  producto.idProducto\n"
            + "INNER JOIN marca ON producto.Marca_idMarca = marca.idMarca\n"
            + "GROUP BY marca.nombre";
    public static final String VENTAS_POR_PRODUCTO = "SELECT producto.nombre AS 'Producto', SUM(detalle_venta.cantidad) AS Cantidad_total FROM detalle_venta\n"
            + "INNER JOIN producto on detalle_venta.Producto_idProducto = producto.idProducto\n"
            + "GROUP BY detalle_venta.Producto_idProducto\n"
            + "ORDER BY Cantidad_total DESC";
    public static final String VENTAS_EN_RANGO = "SELECT * FROM venta WHERE venta.fechahora BETWEEN =? AND =?";

    private ConsultasDAO() {
    }

    public static ConsultasDAO getInstance() {
        return ConsultasDAOHolder.INSTANCE;
    }

    private static class ConsultasDAOHolder {

        private static final ConsultasDAO INSTANCE = new ConsultasDAO();
    }

    public DefaultTableModel consulta(String consulta) {
        Connection con = null;
        PreparedStatement st = null;
        Statement st2 = null;
        DefaultTableModel dt = new DefaultTableModel();
        try {
            con = Conexion.getConnection();
            st2 = con.prepareStatement(consulta);
            ResultSet rs = st.executeQuery();
            dt = GuiTools.getInstance().resultSetToDefaultTableModel(rs);
        } catch (Exception e) {
            System.out.println("Error al cargar la consulta" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    public DefaultTableModel consultaComprasEnRango(Cliente cliente, Date desde, Date hasta) {
        System.out.println(cliente.getNombre() + " " + desde.getTime() + " " + hasta.getTime());
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = new DefaultTableModel();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(VENTAS_EN_RANGO);
            st.setInt(1, cliente.getIdCliente());
            st.setDate(2, desde);
            st.setDate(3, hasta);
            ResultSet rs = st.executeQuery();
            dt = GuiTools.getInstance().resultSetToDefaultTableModel(rs);
        } catch (Exception e) {
            System.out.println("Error al cargar la consulta" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
}
