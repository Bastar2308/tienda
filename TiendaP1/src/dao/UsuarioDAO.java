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
import pojo.Categoria;
import pojo.Usuario;

public class UsuarioDAO {

    private UsuarioDAO() {
    }

    public static UsuarioDAO getInstance() {
        return UsuarioDAOHolder.INSTANCE;
    }

    private static class UsuarioDAOHolder {

        private static final UsuarioDAO INSTANCE = new UsuarioDAO();
    }

    public Usuario iniciaSesion(String usuario, String password) {
        Usuario pojo = new Usuario();
        Connection con = null;
        int id = 0;
        try {
            String consult = "SELECT * FROM usuario WHERE usuario = '" + usuario + "' and password = '" + password + "'";

            con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement(consult);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaUsuario(rs);
            }
        } catch (Exception e) {
            System.out.println("Error en login " + e);
        }
        return pojo;
    }

    public Usuario inflaUsuario(ResultSet rs) {
        Usuario pojo = new Usuario();
        try {
            pojo.setIdUsuario(rs.getInt("idUsuario"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setUsuario(rs.getString("usuario"));
            pojo.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            System.out.println("Error al inflar usuario " + ex);
        }
        return pojo;
    }

}
