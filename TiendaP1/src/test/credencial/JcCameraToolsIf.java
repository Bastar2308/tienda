/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.credencial;

import com.github.sarxos.webcam.WebcamPanel;

/**
 *
 * @author Fernando
 */
public interface JcCameraToolsIf {
    
    public abstract WebcamPanel getJpPanel();

    public abstract void setJpPanel(WebcamPanel wp);
}
