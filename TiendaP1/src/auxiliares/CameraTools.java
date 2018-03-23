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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Fernando
 */
public class CameraTools implements Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {
    
    private Webcam webcam = Webcam.getDefault();
//    private WebcamPanel panel = new WebcamPanel(webcam, new Dimension(130, 130), false);
    private WebcamPicker picker = null;
    
    private CameraTools() {
    }
    
    public static CameraTools getInstance() {
        return CameraToolsHolder.INSTANCE;
    }

    @Override
    public void run() {
        
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
        
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent wde) {
        
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent wde) {
        
    }
    
    private static class CameraToolsHolder {

        private static final CameraTools INSTANCE = new CameraTools();
    }
}
