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

//    public static final int NEGOCIO = 1;
//    public static final int ESCUELA = 2;
//    public static final int ENCARGADO = 3;
//    public static final int TELEFONO = 4;
//    public static final int DIRECCION = 5;
    public static String get(String requerido) {
//        Preferences prefs = Preferences.systemNodeForPackage(auxiliares.Prefs.class);
//        return prefs.get(requerido, "N/A");
        return "EN PROCESO";
    }

    public static void put(String key, String value) {
//        Preferences prefs = Preferences.systemNodeForPackage(auxiliares.Prefs.class);
//        prefs.put(key, value);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void d() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
