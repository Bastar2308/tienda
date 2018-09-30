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

    private static Preferences prefs = Preferences.userRoot().node("/auxiliares/Prefs");

    public static String get(String requerido) {
        return prefs.get(requerido, "N/A");
    }

    public static void put(int key, String value) {
        prefs.put(String.valueOf(key), value);
    }
}
