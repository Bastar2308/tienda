/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Fernando
 */
public class LogTools {

    Logger logger = LogManager.getRootLogger();

    private LogTools() {
    }

    public static LogTools getInstance() {
        return LogToolsHolder.INSTANCE;
    }

    private static class LogToolsHolder {

        private static final LogTools INSTANCE = new LogTools();
    }

    /**
     * Crea un registro de debuggeo
     *
     * @param mensaje
     * @param e
     */
    public void debugLog(String mensaje, Exception e) {
        logger.debug(mensaje, e);
    }

    /**
     * Crea un registro de información
     *
     * @param mensaje
     * @param e
     */
    public void infoLog(String mensaje, Exception e) {
        logger.info(mensaje, e);
    }

    /**
     * Crea un registro de advertencia
     *
     * @param mensaje
     * @param e
     */
    public void advertLog(String mensaje, Exception e) {
        logger.warn(mensaje, e);
    }

    /**
     * Crea un registro de error
     *
     * @param mensaje
     * @param e
     */
    public void errorLog(String mensaje, Exception e) {
        logger.error(mensaje, e);
    }

}
