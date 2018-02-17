/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.producto;

import dao.ProductoDAO;
import pojo.Producto;

/**
 *
 * @author Fernando
 */
public class ProductoModificar {

    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setIdProducto(2);
        producto.setNombre("Producto002");
        producto.setPrecio(200);
        producto.setDetalles("Detalles002");
        producto.setCategoria_idCategoria(1);
        producto.setMarca_idMarca(1);
        producto.setCodigo("0000000002");
        if (ProductoDAO.getInstance().modificaProducto(producto) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
