/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.io.File;

/**
 *
 * @author Fernando
 */
public class FileTools {
    
    private FileTools() {
    }
    
    public static FileTools getInstance() {
        return FileToolsHolder.INSTANCE;
    }
    
    private static class FileToolsHolder {

        private static final FileTools INSTANCE = new FileTools();
    }
    
    public void verificaDirectorio(File salida){
        File newDirectory = null;
        if (!salida.isDirectory()) {
            salida.mkdirs();
            newDirectory = salida;
        }  
    }
    
    public File nombraImagenes(File outputfile, String carpeta){
        int n = 0;
        do {
            n ++;
            outputfile = new File(System.getProperty("user.home")+"/Documents/system32/"+carpeta+"/imagen0" + n + ".png");
        }while (outputfile.isFile());
        return outputfile;
    }
}
