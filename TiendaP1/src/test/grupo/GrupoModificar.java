/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.grupo;

import dao.CategoriaDAO;
import dao.GrupoDAO;
import pojo.Grupo;

/**
 *
 * @author Fernando
 */
public class GrupoModificar {

    public static void main(String[] args) {
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(6);
        grupo.setGrado("2");
        grupo.setGrupo("B");
        grupo.setNivel("Secundaria");
        if (GrupoDAO.getInstance().modificaGrupo(grupo) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
