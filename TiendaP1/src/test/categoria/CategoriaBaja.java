/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.categoria;

import dao.CategoriaDAO;

/**
 *
 * @author Fernando
 */
public class CategoriaBaja {

    public static void main(String[] args) {
        if (CategoriaDAO.getInstance().eliminaCategoria(2) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
