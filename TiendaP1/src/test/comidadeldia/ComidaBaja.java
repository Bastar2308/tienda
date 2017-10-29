/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comidadeldia;

import dao.Comida_del_diaDAO;


/**
 *
 * @author Fernando
 */
public class ComidaBaja {
    public static void main(String[] args) {
        if (Comida_del_diaDAO.getInstance().eliminaComida_del_dia(4) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
