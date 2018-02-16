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
public class MarcaConsulta {

    public static void main(String[] args) {
        Marca marca = MarcaDAO.getInstance().buscaMarca(2);
        if (marca != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: " + marca.getIdMarca());
            System.out.println("Nombre: " + marca.getNombre());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
