/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.ClienteDAOIf;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;
import pojo.Grupo;


public class ClienteDAO implements ClienteDAOIf{
    
    private static final String TABLE="cliente";
    private static final String SQL_INSERT="INSERT INTO "+TABLE+" (grupo_idGrupo, nombre, saldo, qr, foto, tutor, telefono, correo, compras_sin_credencial, limite_deuda) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_QUERY="SELECT * FROM "+TABLE+ " WHERE idCliente = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE="DELETE FROM "+TABLE+" WHERE idCliente=?";
    private static final String SQL_UPDATE="UPDATE "+TABLE+" SET grupo_idGrupo=?, nombre=?, saldo=?, qr=?, foto=?, tutor=?, telefono=?, correo=?, compras_sin_credencial=?, limite_deuda=? WHERE idCliente=?";

    @Override
    public int insertaCliente(Cliente pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, pojo.getGrupo_idGrupo());
            st.setString(2, pojo.getNombre());
            st.setDouble(3, pojo.getSaldo());
            st.setString(4, pojo.getQr());
            st.setBlob(5, (Blob) pojo.getFoto());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setInt(9, pojo.getCompras_sin_credencial());
            st.setDouble(10, pojo.getLimite_deuda());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar cliente" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    @Override
    public boolean eliminaCliente(int id) {
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
            System.out.println("Error al eliminar cliente " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public boolean modificaCliente(Cliente pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);
            st.setInt(1, pojo.getGrupo_idGrupo());
            st.setString(2, pojo.getNombre());
            st.setDouble(3, pojo.getSaldo());
            st.setString(4, pojo.getQr());
            st.setBlob(5, pojo.getFoto());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setInt(9, pojo.getCompras_sin_credencial());
            st.setDouble(10, pojo.getLimite_deuda());
            st.setInt(11, pojo.getIdCliente());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    @Override
    public Cliente buscaCliente(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Cliente pojo = new Cliente();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaCliente(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar cliente " + e);
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
        String encabezados[] = {"Id","Grupo","Nombre","Salro","Tutor","Telefono","Correo","Compra sin credencial", "Limite"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                Cliente pojo = inflaCliente(rs);
                GrupoDAO grupoDAO = new GrupoDAO();
                Grupo grupo = grupoDAO.buscaGrupo(pojo.getGrupo_idGrupo());
                ob[0] = pojo.getIdCliente();
                ob[1] = grupo.getNombre();
                ob[2] = pojo.getNombre();
                ob[3] = pojo.getSaldo();
                ob[4] = pojo.getTutor();
                ob[5] = pojo.getTelefono();
                ob[6] = pojo.getCorreo();
                ob[7] = pojo.getCompras_sin_credencial();
                ob[8] = pojo.getLimite_deuda();
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla cliente " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }

    @Override
    public DefaultComboBoxModel<Cliente> cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try {
            combo = new DefaultComboBoxModel();
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar cliente");
            while (rs.next()) {
                Cliente cliente = inflaCliente(rs);
                combo.addElement(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar combo cliente");
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cargar combo cliente");
            }
        }
        return combo;
    }

    @Override
    public DefaultListModel<Cliente> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente inflaCliente(ResultSet rs) {
        Cliente pojo = new Cliente();
        try {
            pojo.setIdCliente(rs.getInt("idCliente"));
            pojo.setGrupo_idGrupo(rs.getInt("grupo_idGrupo"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setSaldo(rs.getDouble("saldo"));
            pojo.setQr(rs.getString("qr"));
            pojo.setFoto(rs.getBlob("foto"));
            pojo.setTutor(rs.getString("tutor"));
            pojo.setTelefono(rs.getString("telefono"));
            pojo.setCorreo(rs.getString("correo"));
            pojo.setCompras_sin_credencial(rs.getInt("compras_sin_credencial"));
            pojo.setLimite_deuda(rs.getDouble("limite_deuda"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar cliente " + ex);
        }
        return pojo;
    }

}
