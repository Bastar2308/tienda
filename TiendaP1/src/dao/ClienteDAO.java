/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoif.ClienteDAOIf;
import java.io.File;
import java.io.FileInputStream;
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

public class ClienteDAO implements ClienteDAOIf {

    private static final String TABLE = "cliente";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + " (nombre, saldo, Grupo_idGrupo, qr, foto, tutor, telefono, correo, vigencia) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE idCliente = ?";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE idCliente=?";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET nombre=?, saldo=?, Grupo_idGrupo=?, qr=?, foto=?, tutor=?, telefono=?, correo=?, vigencia=?";

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        return ClienteDAOHolder.INSTANCE;
    }

    private static class ClienteDAOHolder {

        private static final ClienteDAO INSTANCE = new ClienteDAO();
    }

    @Override
    public int insertaCliente(Cliente pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getSaldo());
            st.setInt(3, pojo.getGrupo_idGrupo());
            st.setString(4, pojo.getQr());
            st.setBlob(5, pojo.getFoto());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setDate(9, pojo.getVigencia());
            id = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e);
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
            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getSaldo());
            st.setInt(3, pojo.getGrupo_idGrupo());
            st.setString(4, pojo.getQr());
            st.setBlob(5, pojo.getFoto());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setDate(9, pojo.getVigencia());
            st.setInt(10, pojo.getIdCliente());
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
    public DefaultTableModel cargarClientes() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Id", "Nombre", "Saldo", "Grupo", "QR", "Foto", "Tutor", "Telefono", "Correo", "Compras sin credencial", "Vigencia"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[11];
                Cliente pojo = inflaCliente(rs);
                ob[0] = pojo.getIdCliente();
                ob[1] = pojo.getNombre();
                ob[2] = pojo.getSaldo();
                ob[3] = pojo.getGrupo_idGrupo();
                ob[4] = pojo.getQr();
                ob[5] = pojo.getFoto();
                ob[6] = pojo.getTutor();
                ob[7] = pojo.getTelefono();
                ob[8] = pojo.getCorreo();
                ob[9] = pojo.getVigencia();
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
    public DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Id", "Nombre", "Saldo", "Grupo", "QR", "Foto", "Tutor", "Telefono", "Correo", "Vigencia"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[11];
                Cliente pojo = inflaCliente(rs);
                Grupo grupo = GrupoDAO.getInstance().buscaGrupo(pojo.getGrupo_idGrupo());
                ob[0] = pojo.getIdCliente();
                ob[1] = pojo.getNombre();
                ob[2] = pojo.getSaldo();
                ob[3] = grupo.getNombre();
                ob[4] = grupo.getIdGrupo();
                ob[5] = pojo.getQr();
                ob[6] = pojo.getFoto();
                ob[7] = pojo.getTutor();
                ob[8] = pojo.getTelefono();
                ob[9] = pojo.getCorreo();
                ob[10] = pojo.getVigencia();
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
            pojo.setNombre(rs.getString("nombre"));
            pojo.setSaldo(rs.getDouble("saldo"));
            pojo.setGrupo_idGrupo(rs.getInt("grupo_idGrupo"));
            pojo.setQr(rs.getString("qr"));
            pojo.setFoto(rs.getBlob("foto"));
            pojo.setTutor(rs.getString("tutor"));
            pojo.setTelefono(rs.getString("telefono"));
            pojo.setCorreo(rs.getString("correo"));
            pojo.setVigencia(rs.getDate("vigencia"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar cliente " + ex);
        }
        return pojo;
    }

}
