/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import test.credencial.JcCameraToolsIf;

/**
 *
 * @author Fernando
 */
public class CameraTools implements JcCameraToolsIf, Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {
    
    private Webcam webcam = Webcam.getDefault();
    private static WebcamPanel wPanel;
    private WebcamPicker picker = null;
    static JPanel contenedor;
    static JFrame ventana;
    static int width;
    static int height;
    
    private CameraTools() {
        System.out.println("Instanciado");
        run();
    }
    
    public static CameraTools getInstance(int x, int y, JPanel panel, JFrame frame) {
        width = x;
        height = y;
        contenedor = panel;
        ventana = frame;
        return CameraToolsHolder.INSTANCE;
    }

    @Override
    public WebcamPanel getJpPanel() {
        return wPanel;
    }

    @Override
    public void setJpPanel(WebcamPanel wp) {
        this.wPanel = wp;
    }
    
    private static class CameraToolsHolder {
        private static final CameraTools INSTANCE = new CameraTools();
    }
    
    @Override
    public void run() {
        Webcam.addDiscoveryListener(this);
        addWindowListener(this);

        picker = new WebcamPicker();
        picker.addItemListener(this);
        
        webcam.addWebcamListener(CameraTools.this);

        wPanel = new WebcamPanel(webcam, new Dimension(width, height), false);
        wPanel.setFPSDisplayed(false);
        wPanel.setFillArea(true);
        
        ventana.add(picker, BorderLayout.NORTH);
        
        contenedor.removeAll();
        contenedor.setLayout(new FlowLayout());
        contenedor.add(wPanel);
        contenedor.repaint();
        
        Thread t = new Thread() {

            @Override
            public void run() {
                wPanel.start();
                System.out.println("Corre");
            }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
        
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
        
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
        
    }

    @Override
    public void webcamImageObtained(WebcamEvent we) {
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
        wPanel.stop();
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

    @Override
    public void uncaughtException(Thread thread, Throwable thrwbl) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItem() != webcam) {
            if (webcam != null) {

                wPanel.stop();
                contenedor.remove(wPanel);
                
                webcam.removeWebcamListener(this);
                webcam.close();

                webcam = (Webcam) ie.getItem();
                webcam.addWebcamListener(this);

                System.out.println("selected " + webcam.getName());

                wPanel = new WebcamPanel(webcam, new Dimension(width, height), false);
                wPanel.setFPSDisplayed(false);
                wPanel.setFillArea(true);
                
                contenedor.removeAll();
                contenedor.add(wPanel, BorderLayout.CENTER);
                contenedor.repaint();
                contenedor.revalidate();
                
                Thread t = new Thread() {

                    @Override
                    public void run() {
                        wPanel.start();
                    }
                };
                t.setName("example-stoper");
                t.setDaemon(true);
                t.setUncaughtExceptionHandler(this);
                t.start();
            }
        }
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent wde) {
        
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent wde) {
        
    }
}
