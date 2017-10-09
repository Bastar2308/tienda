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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificaCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscaCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultComboBoxModel<Cliente> cargarCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel<Cliente> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente inflaCategoria(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
