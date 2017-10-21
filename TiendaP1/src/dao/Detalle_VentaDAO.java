/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


public class Detalle_VentaDAO {

    private Detalle_VentaDAO() {
    }
    
    public static Detalle_VentaDAO getInstance() {
        return Detalle_VentaDAOHolder.INSTANCE;
    }
    
    private static class Detalle_VentaDAOHolder {

        private static final Detalle_VentaDAO INSTANCE = new Detalle_VentaDAO();
    }
    
}
