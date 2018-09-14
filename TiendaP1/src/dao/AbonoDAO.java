/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import auxiliares.GuiTools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import pojo.Abono;

/**
 *
 * @author Fernando
 */
public class AbonoDAO {

    private static final String TABLE = "abono";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + " (cliente_idCliente, monto, saldo_anterior, saldo_nuevo) VALUES (?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM " + TABLE + " WHERE cliente_idCliente = ?";
    private static final String SQL_SELECT_BY_DATE = "SELECT * FROM " + TABLE + " WHERE cliente_idCliente = ? and fechahora = ?";

    private AbonoDAO() {
    }

    public static AbonoDAO getInstance() {
        return AbonoDAOHolder.INSTANCE;
    }

    private static class AbonoDAOHolder {

        private static final AbonoDAO INSTANCE = new AbonoDAO();
    }

    public int insertaAbono(Abono pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, pojo.getCliente_idCliente());
            st.setDouble(2, pojo.getMonto());
            st.setDouble(3, pojo.getSaldo_anterior());
            st.setDouble(4, pojo.getSaldo_nuevo());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar marca" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    public Abono buscaAbono(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Abono pojo = new Abono();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_SELECT);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaAbono(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar  abono" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public Abono buscaAbono(int id, String fecha) {
        Connection con = null;
        PreparedStatement st = null;
        Abono pojo = new Abono();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_SELECT_BY_DATE);
            st.setInt(1, id);
            st.setString(2, fecha);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaAbono(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar  abono" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public DefaultTableModel abonos(int idCliente) {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("Select * from abono where cliente_idCliente=" + idCliente
                    + " order by fechahora desc");
            ResultSet rs = st.executeQuery();
            dt = GuiTools.getInstance().resultSetToDefaultTableModel(rs);
        } catch (SQLException e) {
            System.out.println("Error al consultar último abono " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    public long ultimoAbono(int idCliente) {
        Connection con = null;
        PreparedStatement st = null;
        long ultimoAbono = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("Select fechahora from abono where cliente_idCliente=" + idCliente
                    + " order by fechahora desc limit 1");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//                ultimoAbono = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                        .parse(String.valueOf(rs.getDate("fechahora"))).getTime() / 1000;
                ultimoAbono = rs.getTimestamp("fechahora").getTime();

                System.out.println(ultimoAbono);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar último abono " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ultimoAbono;
    }

    public Abono inflaAbono(ResultSet rs) {
        Abono pojo = new Abono();
        try {
            pojo.setId(rs.getInt("idabono"));
            pojo.setCliente_idCliente(rs.getInt("cliente_idcliente"));
            pojo.setMonto(rs.getDouble("monto"));
            pojo.setSaldo_anterior(rs.getDouble("saldo_anterior"));
            pojo.setSaldo_nuevo(rs.getDouble("saldo_nuevo"));
            pojo.setFecha_hora(new Date(rs.getTimestamp("fechahora").getTime()));
        } catch (SQLException ex) {
            System.out.println("Error al inflar abono " + ex);
        }
        return pojo;
    }

    public static void main(String[] args) {
        System.out.println("Hol");
        AbonoDAO.getInstance().ultimoAbono(697);
    }

}
