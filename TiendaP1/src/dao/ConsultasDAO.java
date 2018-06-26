package dao;

import auxiliares.GuiTools;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 * @author David Vazquez
 *
 * Funcion de la clase:
 *
 */
public class ConsultasDAO {

    public static final String VENTAS_POR_CATEGORIA = "";
    public static final String VENTAS_POR_MARCA = "";
    public static final String VENTAS_POR_PRODUCTO = "";
    public static final String VENTAS_EN_RANGO = "";

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
        DefaultTableModel dt = new DefaultTableModel();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(consulta);
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

    public DefaultTableModel consultaComprasEnRango(Date desde, Date hasta) {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = new DefaultTableModel();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(VENTAS_EN_RANGO);
            st.setDate(1, desde);
            st.setDate(2, hasta);
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
