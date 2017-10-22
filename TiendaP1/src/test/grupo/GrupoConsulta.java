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
public class GrupoConsulta {
    public static void main(String[] args) {
        Grupo grupo = GrupoDAO.getInstance().buscaGrupo(3);
        if (grupo != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: "+grupo.getIdGrupo());
            System.out.println("Nombre: "+grupo.getNombre());
            System.out.println("Nivel: "+grupo.getNivel());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
