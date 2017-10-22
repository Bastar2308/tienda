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
public class CategoriaConsulta {
    public static void main(String[] args) {
        Categoria categoria = CategoriaDAO.getInstance().buscaCategoria(2);
        if (categoria != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: "+categoria.getIdCategoria());
            System.out.println("Nombre: "+categoria.getNombre());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
