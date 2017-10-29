/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comidadeldia;

import dao.Comida_del_diaDAO;
import pojo.Comida_del_dia;

/**
 *
 * @author Fernando
 */
public class ComidaConsulta {
    public static void main(String[] args) {
        Comida_del_dia comida_del_dia = Comida_del_diaDAO.getInstance().buscaComida_del_dia(1);
        if (comida_del_dia != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: "+comida_del_dia.getIdComida_del_dia());
            System.out.println("Nombre: "+comida_del_dia.getNombre());
            System.out.println("Descripción: "+comida_del_dia.getDescripción());
            System.out.println("Precio: "+comida_del_dia.getPrecio());
            System.out.println("Fecha: "+comida_del_dia.getFecha());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
