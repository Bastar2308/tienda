/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.grupo;

import dao.GrupoDAO;
import pojo.Grupo;

/**
 *
 * @author Fernando
 */
public class GrupoAlta {
    public static void main(String[] args) {
        Grupo grupo = new Grupo();
        grupo.setNombre("Grupo001");
        grupo.setNivel("Secundaria");
        if (GrupoDAO.getInstance().insertaGrupo(grupo) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
