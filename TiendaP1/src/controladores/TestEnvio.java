/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.MailTools;

/**
 *
 * @author Bastar
 */
public class TestEnvio {
    public static void main(String[] args) {
        
        MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("cafeteriakpbaltico@hotmail.com", "R4quel_23"),
                "profesorbastar@hotmail.com",
                "Pruebas 1",
                "cONTENIDO", "Estado de cuenta");

    }
}
