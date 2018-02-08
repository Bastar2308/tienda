/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cliente;

import dao.ClienteDAO;
import java.sql.Date;
import pojo.Cliente;


/**
 *
 * @author Fernando
 */
public class ClienteModificar {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("Cliente001");
        cliente.setSaldo(200);
        cliente.setGrupo_idGrupo(1);
        cliente.setQr("QR001");
        cliente.setFoto(null);
        cliente.setTutor("Tutor001");
        cliente.setTelefono("0000000001");
        cliente.setCorreo("correo001");
        cliente.setCompras_sin_credencial(10);
        cliente.setVigencia(new Date(118, 9, 27));
        if (ClienteDAO.getInstance().modificaCliente(cliente) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
