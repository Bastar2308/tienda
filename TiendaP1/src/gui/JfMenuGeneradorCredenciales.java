/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import controladores.MenuGeneradorCredencialesControlador;
import guiif.JfMenuGeneradorCredencialesIf;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author BurnKill
 */
public class JfMenuGeneradorCredenciales extends javax.swing.JFrame implements JfMenuGeneradorCredencialesIf {

    MenuGeneradorCredencialesControlador controlador;

    /**
     * Creates new form JfMenuGeneradorCredenciales
     */
    public JfMenuGeneradorCredenciales() {
        initComponents();
        getContentPane().setBackground(new Color(51, 51, 51));
        controlador = new MenuGeneradorCredencialesControlador(this);
        setLocationRelativeTo(null);
    }

    public static JfMenuGeneradorCredenciales getInstance() {
        return JfMenuGeneradorCredencialesHolder.INSTANCE;
    }

    private static class JfMenuGeneradorCredencialesHolder {

        private static final JfMenuGeneradorCredenciales INSTANCE = new JfMenuGeneradorCredenciales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcSelector = new javax.swing.JFileChooser();
        jbRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        tfBuscar = new javax.swing.JTextField();
        jbFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbSeleccionar = new javax.swing.JButton();
        tfRuta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        fcSelector.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de credenciales");
        setResizable(false);

        jbRegresar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"))); // NOI18N
        jbRegresar.setText("Regresar");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jbGenerar.setBackground(new java.awt.Color(102, 102, 102));
        jbGenerar.setText("Generar");

        jlLista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlLista);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");

        jbFiltrar.setBackground(new java.awt.Color(102, 102, 102));
        jbFiltrar.setText("Filtrar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carpeta:");

        jbSeleccionar.setBackground(new java.awt.Color(102, 102, 102));
        jbSeleccionar.setText("Seleccionar...");

        tfRuta.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbGenerar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbSeleccionar)
                    .addComponent(tfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(jbGenerar)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generador de credenciales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegresar)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegresar)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

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
            java.util.logging.Logger.getLogger(JfMenuGeneradorCredenciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenuGeneradorCredenciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenuGeneradorCredenciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenuGeneradorCredenciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenuGeneradorCredenciales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fcSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbGenerar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JButton jbSeleccionar;
    private javax.swing.JList<String> jlLista;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfRuta;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getJbRegresar() {
        return jbRegresar;
    }

    @Override
    public void setJbRegresar(JButton jb) {
        this.jbRegresar = jb;
    }

    public javax.swing.JFileChooser getFcSelector() {
        return fcSelector;
    }

    public void setFcSelector(javax.swing.JFileChooser fcSelector) {
        this.fcSelector = fcSelector;
    }

    public javax.swing.JButton getJbFiltrar() {
        return jbFiltrar;
    }

    public void setJbFiltrar(javax.swing.JButton jbFiltrar) {
        this.jbFiltrar = jbFiltrar;
    }

    public javax.swing.JButton getJbGenerar() {
        return jbGenerar;
    }

    public void setJbGenerar(javax.swing.JButton jbGenerar) {
        this.jbGenerar = jbGenerar;
    }

    public javax.swing.JButton getJbSeleccionar() {
        return jbSeleccionar;
    }

    public void setJbSeleccionar(javax.swing.JButton jbSeleccionar) {
        this.jbSeleccionar = jbSeleccionar;
    }

    public javax.swing.JList<String> getJlLista() {
        return jlLista;
    }

    public void setJlLista(javax.swing.JList jlLista) {
        this.jlLista = jlLista;
    }

    public javax.swing.JTextField getTfBuscar() {
        return tfBuscar;
    }

    public void setTfBuscar(javax.swing.JTextField tfBuscar) {
        this.tfBuscar = tfBuscar;
    }

    public javax.swing.JTextField getTfRuta() {
        return tfRuta;
    }

    public void setTfRuta(javax.swing.JTextField tfRuta) {
        this.tfRuta = tfRuta;
    }

}
