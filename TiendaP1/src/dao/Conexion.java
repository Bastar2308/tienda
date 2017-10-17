/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
    private static final String JDBC_HOST = "201.150.40.222";

    private static final String JDBC_USER = "root";

    private static final String JDBC_PASS = "OSIlgf81467";

    private static final String JDBC_BD = "tienda_cbb";

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String JDBC_URL = "jdbc:mysql://" + JDBC_HOST + "/" + JDBC_BD;

    private static Driver controlador = null;



    public static synchronized Connection getConnection() throws SQLException {

        if (controlador == null) {

            try {

                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);

                controlador = (Driver) jdbcDriverClass.newInstance();

                DriverManager.registerDriver(controlador);

            } catch (Exception e) {

                System.out.println("Error en el driver " + e);

            }

        }

        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

    }



    public static void close(Connection rs) {

        try {

            if (rs != null) {

                rs.close();

            }

        } catch (Exception e) {

            System.out.println("Error al cerrar conexión " + e);

        }

    }



    public static void close(ResultSet rs) {

        try {

            if (rs != null) {

                rs.close();

            }

        } catch (Exception e) {

            System.out.println("Error al cerrar ResultSet " + e);

        }

    }



    public static void close(PreparedStatement rs) {

        try {

            if (rs != null) {

                rs.close();

            }

        } catch (Exception e) {

            System.out.println("Error al cerrar PreparedStatement" + e);

        }

    }



    public static void main(String[] args) {

        try {

            Connection con = Conexion.getConnection();

            System.out.println(con);

        } catch (Exception e) {

            System.out.println("Error = " + e);

        }

    }
    
}
