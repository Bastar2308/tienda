/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.util.prefs.Preferences;

/**
 *
 * @author Admin
 */
public class Prefs {

    public static int NEGOCIO = 1;
    public static int ESCUELA = 2;
    public static int ENCARGADO = 3;
    public static int TELEFONO = 4;
    public static int DIRECCION = 5;
    
    private static Preferences prefs = Preferences.userRoot().node("/auxiliares/Prefs");

    public static String get(int requerido) {
        return prefs.get(String.valueOf(requerido), "N/A");
    }

    public static void put(int key, String value) {
        prefs.put(String.valueOf(key), value);
    }
}
