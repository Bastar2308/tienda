/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import com.barcodelib.barcode.QRCode;
import java.awt.image.BufferedImage;

/**
 *
 * @author Fernando
 */
public class QrTools {
    
    private QrTools() {
    }
    
    public static QrTools getInstance() {
        return QrToolsHolder.INSTANCE;
    }
    
    private static class QrToolsHolder {

        private static final QrTools INSTANCE = new QrTools();
    }
    
    public BufferedImage generarQR(String contenido, String nombreArchivo, String ruta){
        BufferedImage bf;
        try {
            QRCode qrCode = new QRCode();
            qrCode.setData(contenido);
            qrCode.setDataMode(QRCode.MODE_BYTE);
            qrCode.setModuleSize(20);
            String file = ruta + "/" + nombreArchivo + ".png";
            //qrCode.renderBarcode(file);
            bf = qrCode.renderBarcode();
            return bf;
        } catch (Exception e) {
            System.out.println("Error al generar QR: "+e);
            return null;
        }
    }
}
