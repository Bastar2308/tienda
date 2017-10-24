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
public class ClienteAlta {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Cliente002");
        cliente.setSaldo(100);
        cliente.setGrupo_idGrupo(1);
        cliente.setQr("QR002");
        cliente.setFoto(null);
        cliente.setTutor("Tutor002");
        cliente.setTelefono("0000000002");
        cliente.setCorreo("correo002");
        cliente.setCompras_sin_credencial(5);
        cliente.setLimite_deuda(100);
        if (ClienteDAO.getInstance().insertaCliente(cliente) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }   
    }
}
