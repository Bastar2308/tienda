/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Abono inflaAbono(ResultSet rs) {
        Abono pojo = new Abono();
        try {
            pojo.setId(rs.getInt("idabono"));
            pojo.setCliente_idCliente(rs.getInt("cliente_idcliente"));
            pojo.setMonto(rs.getDouble("monto"));
            pojo.setSaldo_anterior(rs.getInt("saldo_anterior"));
            pojo.setCliente_idCliente(rs.getInt("saldo_nuevo"));
            pojo.setFecha_hora(rs.getDate("fechahora"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar abono " + ex);
        }
        return pojo;
    }
    
}
