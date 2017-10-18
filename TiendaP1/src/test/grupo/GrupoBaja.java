/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.grupo;

import dao.GrupoDAO;

/**
 *
 * @author Fernando
 */
public class GrupoBaja {
    public static void main(String[] args) {
        GrupoDAO grupoDAO = new GrupoDAO();
        if (grupoDAO.eliminaGrupo(6) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
