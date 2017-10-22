/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cliente;

import dao.ClienteDAO;


/**
 *
 * @author Fernando
 */
public class ClienteBaja {
    public static void main(String[] args) {
        if (ClienteDAO.getInstance().eliminaCliente(2) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
