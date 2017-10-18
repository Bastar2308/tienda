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
public class ProductoAlta {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setNombre("Producto001");
        producto.setPrecio(100);
        producto.setStock(10);
        producto.setDetalles("Detalles001");
        producto.setCategoria_idCategoria(1);
        producto.setMarca_idMarca(1);
        producto.setCodigo("0000000001");
        ProductoDAO productoDAO = new ProductoDAO();
        if (productoDAO.insertaProducto(producto) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
