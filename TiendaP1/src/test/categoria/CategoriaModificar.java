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
public class CategoriaModificar {

    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(2);
        categoria.setNombre("Categoría002");
        if (CategoriaDAO.getInstance().modificaCategoria(categoria) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
