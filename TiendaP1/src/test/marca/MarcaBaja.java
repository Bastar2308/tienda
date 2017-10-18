/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.marca;

import dao.MarcaDAO;


/**
 *
 * @author Fernando
 */
public class MarcaBaja {
    public static void main(String[] args) {
        MarcaDAO marcaDAO = new MarcaDAO();
        if (marcaDAO.eliminaMarca(2) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
