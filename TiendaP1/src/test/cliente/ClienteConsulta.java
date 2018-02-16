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
public class ClienteConsulta {

    public static void main(String[] args) {
        Cliente cliente = ClienteDAO.getInstance().buscaCliente(2);
        if (cliente != null) {
            System.out.println("Consultado correctamente");
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Saldo: " + cliente.getSaldo());
            System.out.println("Grupo: " + cliente.getGrupo_idGrupo());
            System.out.println("Qr: " + cliente.getQr());
            System.out.println("Foto: " + cliente.getFoto());
            System.out.println("Tutor: " + cliente.getTutor());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Correo: " + cliente.getCorreo());
            System.out.println("Compras sin credencial: " + cliente.getCompras_sin_credencial());
        } else {
            System.out.println("Error en la consulta");
        }
    }
}
