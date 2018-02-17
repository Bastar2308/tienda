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
public class ProductoConsulta {

    public static void main(String[] args) {
        Producto producto = ProductoDAO.getInstance().buscaCategoria(2);
        if (producto != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Detalles: " + producto.getDetalles());
            System.out.println("Categoría: " + producto.getCategoria_idCategoria());
            System.out.println("Marca: " + producto.getMarca_idMarca());
            System.out.println("Código: " + producto.getCodigo());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
