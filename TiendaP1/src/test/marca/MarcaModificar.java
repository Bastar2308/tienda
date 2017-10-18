/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.marca;

import dao.MarcaDAO;
import pojo.Marca;

/**
 *
 * @author Fernando
 */
public class MarcaModificar {
    public static void main(String[] args) {
        Marca marca = new Marca();
        marca.setIdMarca(2);
        marca.setNombre("Marca002");
        MarcaDAO marcaDAO = new MarcaDAO();
        if (marcaDAO.modificaMarca(marca) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
