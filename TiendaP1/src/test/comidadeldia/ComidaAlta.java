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
public class ComidaAlta {
    public static void main(String[] args) {
        Comida_del_dia comida_del_dia = new Comida_del_dia();
        comida_del_dia.setNombre("Comida004");
        comida_del_dia.setFecha(new java.sql.Date(117, 9, 29));
        comida_del_dia.setDescripción("Comida004");
        comida_del_dia.setPrecio(250);
        if (Comida_del_diaDAO.getInstance().insertaComida_del_dia(comida_del_dia) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
