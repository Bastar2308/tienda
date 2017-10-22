/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.categoria;

import dao.CategoriaDAO;
import pojo.Categoria;

/**
 *
 * @author Fernando
 */
public class CategoriaAlta {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNombre("Categoría001");
        if (CategoriaDAO.getInstance().insertaCategoria(categoria) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
