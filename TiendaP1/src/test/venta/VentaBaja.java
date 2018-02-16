/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.venta;

import test.prohibido.*;
import dao.Alimento_Prohibido_ClienteDAO;

/**
 *
 * @author Fernando
 */
public class VentaBaja {

    public static void main(String[] args) {
        if (Alimento_Prohibido_ClienteDAO.getInstance().eliminaAlimento_Prohibido_Cliente(1, 3) == true) {
            System.out.println("Éxito al eliminar");
        } else {
            System.out.println("Error al eliminar");
        }
    }
}
