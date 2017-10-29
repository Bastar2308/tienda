/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import controladores.MenuCargaSaldoControlador;
import guiif.JfMenuCargaSaldoIf;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author BurnKill
 */
public class JfMenuCargaSaldo extends javax.swing.JFrame implements JfMenuCargaSaldoIf {

    private MenuCargaSaldoControlador controlador;

    /**
     * Creates new form CargaSaldo
     */
    public JfMenuCargaSaldo() {
        initComponents();
        getContentPane().setBackground(new Color(51, 51, 51));
        controlador = new MenuCargaSaldoControlador(this);
        setLocationRelativeTo(null);
    }

    public static JfMenuCargaSaldo getInstance() {
        return JfMenuCargaSaldoHolder.INSTANCE;
    }

    private static class JfMenuCargaSaldoHolder {

        private static final JfMenuCargaSaldo INSTANCE = new JfMenuCargaSaldo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbAgregarSaldo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rb20 = new javax.swing.JRadioButton();
        rb50 = new javax.swing.JRadioButton();
        rb100 = new javax.swing.JRadioButton();
        rb200 = new javax.swing.JRadioButton();
        rb500 = new javax.swing.JRadioButton();
        rb1000 = new javax.swing.JRadioButton();
        rbOtra = new javax.swing.JRadioButton();
        jsOtra = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlClientes = new javax.swing.JList<>();
        jbFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargar saldo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jbAgregarSaldo.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregarSaldo.setText("Agregar saldo");

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        rb20.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb20);
        rb20.setForeground(new java.awt.Color(255, 255, 255));
        rb20.setText("$20");
        rb20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb20ActionPerformed(evt);
            }
        });
        jPanel3.add(rb20);

        rb50.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb50);
        rb50.setForeground(new java.awt.Color(255, 255, 255));
        rb50.setText("$50");
        rb50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb50ActionPerformed(evt);
            }
        });
        jPanel3.add(rb50);

        rb100.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb100);
        rb100.setForeground(new java.awt.Color(255, 255, 255));
        rb100.setText("$100");
        rb100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb100ActionPerformed(evt);
            }
        });
        jPanel3.add(rb100);

        rb200.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb200);
        rb200.setForeground(new java.awt.Color(255, 255, 255));
        rb200.setText("$200");
        rb200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb200ActionPerformed(evt);
            }
        });
        jPanel3.add(rb200);

        rb500.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb500);
        rb500.setForeground(new java.awt.Color(255, 255, 255));
        rb500.setText("$500");
        rb500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb500ActionPerformed(evt);
            }
        });
        jPanel3.add(rb500);

        rb1000.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rb1000);
        rb1000.setForeground(new java.awt.Color(255, 255, 255));
        rb1000.setText("$1,000");
        rb1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1000ActionPerformed(evt);
            }
        });
        jPanel3.add(rb1000);

        rbOtra.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rbOtra);
        rbOtra.setForeground(new java.awt.Color(255, 255, 255));
        rbOtra.setText("Otra:");
        rbOtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOtraActionPerformed(evt);
            }
        });
        jPanel3.add(rbOtra);

        jsOtra.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 10));
        jsOtra.setEnabled(false);
        jPanel3.add(jsOtra);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione cantidad");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar:");

        jlClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlClientes);

        jbFiltrar.setBackground(new java.awt.Color(51, 51, 51));
        jbFiltrar.setText("Filtrar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbAgregarSaldo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jbFiltrar))
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFiltrar))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAgregarSaldo)
                .addGap(15, 15, 15))
        );

        jbRegresar.setBackground(new java.awt.Color(102, 102, 102));
        jbRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"))); // NOI18N
        jbRegresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegresar)
                .addGap(45, 45, 45))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbOtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOtraActionPerformed
        jsOtra.setEnabled(true);
    }//GEN-LAST:event_rbOtraActionPerformed

    private void rb20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb20ActionPerformed
        jsOtra.setEnabled(false);
    }//GEN-LAST:event_rb20ActionPerformed

    private void rb50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb50ActionPerformed
        jsOtra.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rb50ActionPerformed

    private void rb100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb100ActionPerformed
        jsOtra.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rb100ActionPerformed

    private void rb200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb200ActionPerformed
        jsOtra.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rb200ActionPerformed

    private void rb500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb500ActionPerformed
        jsOtra.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rb500ActionPerformed

    private void rb1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1000ActionPerformed
        jsOtra.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rb1000ActionPerformed

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
            java.util.logging.Logger.getLogger(JfMenuCargaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenuCargaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenuCargaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenuCargaSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenuCargaSaldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarSaldo;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JList<String> jlClientes;
    private javax.swing.JSpinner jsOtra;
    private javax.swing.JRadioButton rb100;
    private javax.swing.JRadioButton rb1000;
    private javax.swing.JRadioButton rb20;
    private javax.swing.JRadioButton rb200;
    private javax.swing.JRadioButton rb50;
    private javax.swing.JRadioButton rb500;
    private javax.swing.JRadioButton rbOtra;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getJbRegresar() {
        return jbRegresar;
    }

    @Override
    public void setJbRegresar(JButton jb) {
        this.jbRegresar = jb;
    }

    public javax.swing.JButton getJbAgregarSaldo() {
        return jbAgregarSaldo;
    }

    public void setJbAgregarSaldo(javax.swing.JButton jbAgregarSaldo) {
        this.jbAgregarSaldo = jbAgregarSaldo;
    }

    public javax.swing.JButton getJbFiltrar() {
        return jbFiltrar;
    }

    public void setJbFiltrar(javax.swing.JButton jbFiltrar) {
        this.jbFiltrar = jbFiltrar;
    }

    public javax.swing.JList<String> getJlClientes() {
        return jlClientes;
    }

    public void setJlClientes(javax.swing.JList jlClientes) {
        this.jlClientes = jlClientes;
    }

    public javax.swing.JSpinner getJsOtra() {
        return jsOtra;
    }

    public void setJsOtra(javax.swing.JSpinner jsOtra) {
        this.jsOtra = jsOtra;
    }

    public javax.swing.JRadioButton getRb100() {
        return rb100;
    }

    public void setRb100(javax.swing.JRadioButton rb100) {
        this.rb100 = rb100;
    }

    public javax.swing.JRadioButton getRb1000() {
        return rb1000;
    }

    public void setRb1000(javax.swing.JRadioButton rb1000) {
        this.rb1000 = rb1000;
    }

    public javax.swing.JRadioButton getRb20() {
        return rb20;
    }

    public void setRb20(javax.swing.JRadioButton rb20) {
        this.rb20 = rb20;
    }

    public javax.swing.JRadioButton getRb200() {
        return rb200;
    }

    public void setRb200(javax.swing.JRadioButton rb200) {
        this.rb200 = rb200;
    }

    public javax.swing.JRadioButton getRb50() {
        return rb50;
    }

    public void setRb50(javax.swing.JRadioButton rb50) {
        this.rb50 = rb50;
    }

    public javax.swing.JRadioButton getRb500() {
        return rb500;
    }

    public void setRb500(javax.swing.JRadioButton rb500) {
        this.rb500 = rb500;
    }

    public javax.swing.JRadioButton getRbOtra() {
        return rbOtra;
    }

    public void setRbOtra(javax.swing.JRadioButton rbOtra) {
        this.rbOtra = rbOtra;
    }

    public javax.swing.JTextField getTfBuscar() {
        return tfBuscar;
    }

    public void setTfBuscar(javax.swing.JTextField tfBuscar) {
        this.tfBuscar = tfBuscar;
    }
}
