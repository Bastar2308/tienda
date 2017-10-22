/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.prohibido;

import dao.Alimento_Prohibido_ClienteDAO;
import java.sql.Date;
import pojo.Alimento_Prohibido_Cliente;

/**
 *
 * @author Fernando
 */
public class ProhibidoAlta {
    public static void main(String[] args) {
        Alimento_Prohibido_Cliente alimento_Prohibido_Cliente = new Alimento_Prohibido_Cliente();
        alimento_Prohibido_Cliente.setCliente_idCliente(1);
        alimento_Prohibido_Cliente.setProducto_idProducto(3);
        alimento_Prohibido_Cliente.setFecha_inicio(new Date(2017, 10, 21));
        alimento_Prohibido_Cliente.setFecha_fin(new Date(2017, 11, 21));
        alimento_Prohibido_Cliente.setDescripcion("Porque síX2");
        
        if (Alimento_Prohibido_ClienteDAO.getInstance().insertaAlimento_Prohibido_Cliente(alimento_Prohibido_Cliente) !=0) {
            System.out.println("Exito al prohibir");
        } else {
            System.out.println("Error al prohibir");
        }
    }
}
