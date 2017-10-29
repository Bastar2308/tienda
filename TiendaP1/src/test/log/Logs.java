/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.log;

import auxiliares.LogTools;

/**
 *
 * @author Fernando
 */
public class Logs {
    public static void main(String[] args) {
        LogTools.getInstance().debugLog("Log desde logtools", new Exception());
        LogTools.getInstance().infoLog("Log informativo", new Exception());
        LogTools.getInstance().advertLog("Log warning", new Exception());
        LogTools.getInstance().errorLog("Log error", new Exception());
    }
}
