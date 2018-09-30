/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

/**
 *
 * @author Admin
 */
public class Prueba {

    public static int NEGOCIO = 1;
    public static int ESCUELA = 2;
    public static int ENCARGADO = 3;
    public static int TELEFONO = 4;
    public static int DIRECCION = 5;

    public static void main(String[] args) {
        Prefs.put(NEGOCIO, "Ccafeteria Generica");
        Prefs.put(ESCUELA, "Baltico");
        Prefs.put(ENCARGADO, "Raquel Perez");
        Prefs.put(TELEFONO, "22-25925922259");
        Prefs.put(DIRECCION, "Costa de oro");
//        System.out.println("El valor es: " + Prefs.get(NEGOCIO));
    }
}
