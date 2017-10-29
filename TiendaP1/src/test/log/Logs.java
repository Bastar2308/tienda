/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.log;

import auxiliares.GuiTools;

/**
 *
 * @author Fernando
 */
public class Logs {
    public static void main(String[] args) {
        GuiTools.getInstance().debugLog("Log debug", new Exception());
        GuiTools.getInstance().infoLog("Log informativo", new Exception());
        GuiTools.getInstance().advertLog("Log warning", new Exception());
        GuiTools.getInstance().errorLog("Log error", new Exception());
    }
}
