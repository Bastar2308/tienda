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
    public static final String VENTAS_EN_RANGO = "SELECT venta.fechahora AS Fecha, producto.nombre AS Producto, detalle_venta.cantidad AS Cantidad, detalle_venta.subtotal AS Subtotal FROM detalle_venta\n"
            + "INNER JOIN venta ON venta.idVenta = detalle_venta.Venta_idVenta\n"
            + "INNER JOIN producto ON producto.idProducto = detalle_venta.Producto_idProducto\n"
            + "WHERE venta.Cliente_idCliente =? AND venta.fechahora BETWEEN ? AND ?";

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

    public DefaultTableModel consultaComprasEnRango(int idCliente, Date desde, Date hasta) {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = new DefaultTableModel();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(VENTAS_EN_RANGO);
            st.setInt(1, idCliente);
            st.setString(2, desde.toString() + " 00:00:00");
            st.setString(3, hasta.toString() + " 23:59:59");
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
