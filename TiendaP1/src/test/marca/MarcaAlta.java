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
public class MarcaAlta {
    public static void main(String[] args) {
        Marca marca = new Marca();
        marca.setNombre("Marca001");
        MarcaDAO marcaDAO = new MarcaDAO();
        if (marcaDAO.insertaMarca(marca) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
