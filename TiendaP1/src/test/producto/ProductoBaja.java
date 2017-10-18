/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.producto;

import dao.ProductoDAO;

/**
 *
 * @author Fernando
 */
public class ProductoBaja {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        if (productoDAO.eliminaProducto(2) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
