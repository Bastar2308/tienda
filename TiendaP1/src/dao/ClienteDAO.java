/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;
import pojo.Grupo;

public class ClienteDAO {

    private static final String TABLE = "cliente";
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + " (nombre, saldo, Grupo_idGrupo, qr, foto, tutor, telefono, correo, limite, observaciones, vigencia) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_INSERT2 = "INSERT INTO " + TABLE + " (nombre, saldo, Grupo_idGrupo, qr, tutor, telefono, correo, limite, observaciones,vigencia) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_QUERY = "SELECT * FROM " + TABLE + " WHERE idCliente = ?";
    private static final String SQL_ADEUDOS = "SELECT * FROM " + TABLE + " WHERE saldo < 0";
    private static final String SQL_QUERY_ALL = "Select * from " + TABLE;
    private static final String SQL_DELETE = "DELETE FROM " + TABLE + " WHERE idCliente=?";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET nombre=?, saldo=?, Grupo_idGrupo=?, qr=?, foto=?, tutor=?, telefono=?, correo=?, limite=?, observaciones=? WHERE idCliente=?";
    private static final String SQL_UPDATE_CREDENCIAL = "UPDATE " + TABLE + " SET vigencia=? WHERE idCliente=?";
    private static final String SQL_UPDATE_CREDENCIAL2 = "UPDATE " + TABLE + " SET foto=? WHERE idCliente=?";

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        return ClienteDAOHolder.INSTANCE;
    }

    public boolean restaSaldo(String idClienteint, String cantidadARestar) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("UPDATE Cliente set saldo=saldo-" + cantidadARestar + " WHERE idCliente=" + idClienteint);
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente resta saldo" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public boolean agregaSaldo(String idClienteint, String cantidadARestar) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("UPDATE Cliente set saldo=saldo+" + cantidadARestar + " WHERE idCliente=" + idClienteint);
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente agrega saldo" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public int obtenerRecienInsertado() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("SELECT * FROM cliente");
            rs = st.executeQuery();
            rs.last();
            Cliente clientePOJO = new Cliente();
            clientePOJO = inflaCliente(rs);
            id = clientePOJO.getIdCliente();
            System.out.println(id);
        } catch (Exception e) {
            System.out.println("Error al obtener el último " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
            Conexion.close(rs);
        }
        return id;
    }

    public String obtenObservaciones(String id) {
        Connection con = null;
        PreparedStatement st = null;
        String observaciones = "";
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("SELECT observaciones FROM cliente WHERE idCliente=" + id);
            ResultSet rs = st.executeQuery();

            rs.next();
            observaciones = rs.getString(1);
        } catch (Exception e) {
            System.out.println("Error al consultar cliente con adeudos" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return observaciones;
    }

    public Cliente obtenerClienteConAdeudos() {
        Connection con = null;
        PreparedStatement st = null;
        Cliente pojo = new Cliente();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_ADEUDOS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaCliente(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar cliente con adeudos" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public long ultimoAbono(int idCliente) {
        Connection con = null;
        PreparedStatement st = null;
        long ultimoAbono = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("Select fechahora from abono where cliente_idCliente="+idCliente+
                                                                                " order by fechahora desc limit 1");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ultimoAbono=rs.getLong("fechahora");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar último abono " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return ultimoAbono;
    }

    private static class ClienteDAOHolder {

        private static final ClienteDAO INSTANCE = new ClienteDAO();
    }

    public int insertaCliente(Cliente pojo, String foto) {
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
            st.setBinaryStream(5, new FileInputStream(new File(foto)), (int) new File(foto).length());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setInt(9, pojo.getLimite());
            st.setString(10, pojo.getQr());
            st.setString(11, pojo.getObservacion());
            id = st.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error al insertar cliente: " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

    public boolean agregarQR(String qr, int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement("UPDATE " + TABLE + " SET qr=? WHERE idCliente=?");
            st.setString(1, qr);
            st.setInt(2, id);
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar QRs " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public int insertaCliente(Cliente pojo) {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_INSERT2, PreparedStatement.RETURN_GENERATED_KEYS);
            System.out.println("Insert2");
            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getSaldo());
            st.setInt(3, pojo.getGrupo_idGrupo());
            st.setString(4, pojo.getQr());
            st.setString(5, pojo.getTutor());
            st.setString(6, pojo.getTelefono());
            st.setString(7, pojo.getCorreo());
            st.setDouble(8, pojo.getLimite());
            st.setString(9, pojo.getObservacion());
            st.setDate(10, pojo.getVigencia());
            id = st.executeUpdate();
            ResultSet rs2 = st.getGeneratedKeys();
            if (rs2.next()) {
                id = rs2.getInt(1);
            }
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }

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
            st.setInt(9, pojo.getLimite());
            st.setString(10, pojo.getObservacion());
            st.setInt(11, pojo.getIdCliente());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
            System.out.println("Estiy en modifica cliente 1");
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente 1" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public boolean modificaCliente(Cliente pojo, String path) {
        Connection con = null;
        PreparedStatement st = null;
        System.out.println("Estoy en modifica cliente con foto");
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE);

            st.setString(1, pojo.getNombre());
            st.setDouble(2, pojo.getSaldo());
            st.setInt(3, pojo.getGrupo_idGrupo());
            st.setString(4, pojo.getQr());
            st.setBinaryStream(5, new FileInputStream(new File(path)), (int) new File(path).length());
            st.setString(6, pojo.getTutor());
            st.setString(7, pojo.getTelefono());
            st.setString(8, pojo.getCorreo());
            st.setInt(9, pojo.getLimite());
            st.setString(10, pojo.getObservacion());
            st.setInt(11, pojo.getIdCliente());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente con foto" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public boolean modificaClienteCredencial(Cliente pojo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE_CREDENCIAL);
            st.setDate(1, pojo.getVigencia());
            st.setInt(2, pojo.getIdCliente());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente credencial 1" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

    public boolean modificaClienteCredencial(Cliente pojo, String foto) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            //Recuerden que el últmo es el id
            st = con.prepareStatement(SQL_UPDATE_CREDENCIAL2);
            st.setBinaryStream(1, new FileInputStream(new File(foto)), (int) new File(foto).length());
            st.setInt(2, pojo.getIdCliente());
            int x = st.executeUpdate();
            if (x == 0) {
                return false;
            }
        } catch (SQLException | FileNotFoundException e) {
            System.out.println("Error al actualizar cliente credencial 2" + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }

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

    public DefaultTableModel cargarClientes() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Id", "Nombre", "Saldo", "Grupo", "QR", "Foto", "Tutor", "Telefono", "Correo", "Vigencia", "Límite", "Observaciones"};
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
                ob[10] = pojo.getLimite();
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

    public JComboBox<Cliente> cargarClientesCombo() {
        Connection con = null;
        PreparedStatement st = null;
        JComboBox<Cliente> combo = new JComboBox<>();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_QUERY_ALL);
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
                ob[10] = pojo.getLimite();
                ob[11] = pojo.getObservacion();
                combo.addItem(pojo);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla cliente " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return combo;
    }

    public DefaultTableModel cargarTabla() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"Id", "Nombre", "Saldo", "Grupo", "QR", "Foto", "Tutor", "Telefono", "Correo", "Vigencia", "Límite"};
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
                ob[3] = grupo.getNivel() + " " + grupo.getGrado() + " " + grupo.getGrupo();
                ob[4] = pojo.getQr();
                ob[5] = pojo.getFoto();
                ob[6] = pojo.getTutor();
                ob[7] = pojo.getTelefono();
                ob[8] = pojo.getCorreo();
                ob[9] = pojo.getVigencia();
                ob[10] = pojo.getLimite();
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

    public DefaultListModel<Cliente> cargarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            pojo.setLimite(rs.getInt("limite"));
            pojo.setObservacion(rs.getString("observaciones"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar cliente " + ex);
        }
        return pojo;
    }

    public DefaultTableModel cargarTablaPuntoDeVenta() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("SELECT cliente.idCliente,cliente.nombre,cliente.saldo,cliente.limite,CONCAT(grupo.nivel,' ',grupo.grado,' ',grupo.grupo),cliente.qr from cliente,grupo WHERE cliente.Grupo_idGrupo=grupo.idGrupo\n ORDER BY `cliente`.`idCliente` ASC");
            dt = new DefaultTableModel();
            ResultSet rs = st.executeQuery();
            dt.setColumnIdentifiers(new Object[7]);
            while (rs.next()) {
                dt.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)});
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
}
