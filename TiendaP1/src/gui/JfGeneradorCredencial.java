/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import auxiliares.CameraTools;
import controladores.GeneradorCrendencialControlador;
import dao.ClienteDAO;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pojo.Cliente;

/**
 *
 * @author Fernando
 */
public class JfGeneradorCredencial extends javax.swing.JFrame {

    private final GeneradorCrendencialControlador controlador;
    private static Cliente cl;

    /**
     * Creates new form JfGeneradorCredencial
     */

    public JfGeneradorCredencial() {
        initComponents();
        setSize(715, 450);
        add(jpContenedorBotones, BorderLayout.WEST);
        add(jpCredencial, BorderLayout.CENTER);
        controlador = new GeneradorCrendencialControlador(this, CameraTools.getInstance(200, 200, jpCamara, this));
        System.out.println("Cambió");
    }

    public static JfGeneradorCredencial getInstance(int id) {
        cl = ClienteDAO.getInstance().buscaCliente(id);
        System.out.println(cl);
        return JfGeneradorCredencialHolder.INSTANCE;
    }

    public JButton getJbTomar() {
        return jbTomar;
    }

    public void setJbTomar(JButton bt) {
        this.jbTomar = bt;
    }

    public JButton getJbRepetir() {
        return jbRepetir;
    }

    public void setJbRepetir(JButton bt) {
        this.jbRepetir = bt;
    }

    public JButton getJbGuardar() {
        return jbGuardar;
    }

    public void setJbguardar(JButton bt) {
        this.jbGuardar = bt;
    }

    public JLabel getJlQr() {
        return jlQr;
    }

    public void setJlQr(JLabel lb) {
        this.jlQr = lb;
    }

    public JPanel getJpCamara() {
        return jpCamara;
    }

    public void setJpCamara(JPanel pn) {
        this.jpCamara = pn;
    }

    public JPanel getJpCredencial() {
        return jpCredencial;
    }

    public void setJpCredencial(JPanel pn) {
        this.jpCredencial = pn;
    }

    public Cliente getCliente() {
        return cl;
    }

    public void setCliente(Cliente cl) {
        this.cl = cl;
    }

    public JButton getJbRegresar() {
        return jbRegresar;
    }

    public void setJbRegresar(JButton jbRegresar) {
        this.jbRegresar = jbRegresar;
    }

    private static class JfGeneradorCredencialHolder {

        private static final JfGeneradorCredencial INSTANCE = new JfGeneradorCredencial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedorBotones = new javax.swing.JPanel();
        jbTomar = new javax.swing.JButton();
        jbRepetir = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbRegresar = new javax.swing.JButton();
        jpCredencial = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpCamara = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlQr = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpContenedorBotones.setLayout(new java.awt.GridLayout(4, 1));

        jbTomar.setText("Tomar");
        jpContenedorBotones.add(jbTomar);

        jbRepetir.setText("Repetir");
        jpContenedorBotones.add(jbRepetir);

        jbGuardar.setText("Guardar");
        jpContenedorBotones.add(jbGuardar);

        jbRegresar.setText("Regresar");
        jpContenedorBotones.add(jbRegresar);

        getContentPane().add(jpContenedorBotones, java.awt.BorderLayout.CENTER);

        jpCredencial.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 35)); // NOI18N
        jLabel13.setText("SISTEMA CAFETERÍA BÁLTICO");

        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel13)
        );

        jpCamara.setBackground(new java.awt.Color(255, 255, 255));
        jpCamara.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout jpCamaraLayout = new javax.swing.GroupLayout(jpCamara);
        jpCamara.setLayout(jpCamaraLayout);
        jpCamaraLayout.setHorizontalGroup(
            jpCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jpCamaraLayout.setVerticalGroup(
            jpCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 30)); // NOI18N
        jLabel8.setText("TARJETA RECARGABLE");

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpCredencialLayout = new javax.swing.GroupLayout(jpCredencial);
        jpCredencial.setLayout(jpCredencialLayout);
        jpCredencialLayout.setHorizontalGroup(
            jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jpCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlQr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jpCredencialLayout.setVerticalGroup(
            jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCredencialLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCredencialLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlQr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(jpCredencialLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jpCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jpCredencial, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfGeneradorCredencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfGeneradorCredencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfGeneradorCredencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfGeneradorCredencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfGeneradorCredencial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JButton jbRepetir;
    private javax.swing.JButton jbTomar;
    private javax.swing.JLabel jlQr;
    private javax.swing.JPanel jpCamara;
    private javax.swing.JPanel jpContenedorBotones;
    private javax.swing.JPanel jpCredencial;
    // End of variables declaration//GEN-END:variables
}
