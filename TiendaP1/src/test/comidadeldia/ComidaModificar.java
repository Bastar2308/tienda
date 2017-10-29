/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comidadeldia;

import dao.Comida_del_diaDAO;
import java.sql.Date;
import pojo.Comida_del_dia;


/**
 *
 * @author Fernando
 */
public class ComidaModificar {
    public static void main(String[] args) {
        Comida_del_dia comida_del_dia = new Comida_del_dia();
        comida_del_dia.setIdComida_del_dia(1);
        comida_del_dia.setNombre("Comida001");
        comida_del_dia.setFecha(new Date(117, 9, 26));
        comida_del_dia.setPrecio(300);
        comida_del_dia.setDescripción("Comida001");
        if (Comida_del_diaDAO.getInstance().modificaComida_del_dia(comida_del_dia) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
