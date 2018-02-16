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
public class ClienteAlta {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Cliente003");
        cliente.setSaldo(100);
        cliente.setGrupo_idGrupo(5);
        cliente.setQr("QR003");
        cliente.setFoto(null);
        cliente.setTutor("Tutor003");
        cliente.setTelefono("0000000003");
        cliente.setCorreo("correo003");
        cliente.setCompras_sin_credencial(5);
        cliente.setVigencia(new Date(118, 9, 27));
        if (ClienteDAO.getInstance().insertaCliente(cliente) != 0) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error en la inserción");
        }
    }
}
