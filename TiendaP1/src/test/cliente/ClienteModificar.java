/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cliente;

import dao.ClienteDAO;
import pojo.Cliente;


/**
 *
 * @author Fernando
 */
public class ClienteModificar {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(2);
        cliente.setNombre("Cliente002");
        cliente.setSaldo(200);
        cliente.setGrupo_idGrupo(3);
        cliente.setQr("QR002");
        cliente.setFoto(null);
        cliente.setTutor("Tutor002");
        cliente.setTelefono("0000000002");
        cliente.setCorreo("correo002");
        cliente.setCompras_sin_credencial(10);
        cliente.setLimite_deuda(200);
        if (ClienteDAO.getInstance().modificaCliente(cliente) == true) {
            System.out.println("Actualizado correctamente");
        } else {
            System.out.println("Error en la actualización");
        }
    }
}
