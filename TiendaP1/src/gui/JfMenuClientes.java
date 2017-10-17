/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import guiif.JfMenuClientesIf;
import javax.swing.JButton;
import controladores.MenuClientesControlador;

/**
 *
 * @author BurnKill
 */
public class JfMenuClientes extends javax.swing.JFrame implements JfMenuClientesIf {

    MenuClientesControlador controlador;

    /**
     * Creates new form MenuClientes
     */
    public JfMenuClientes() {
        initComponents();
        controlador = new MenuClientesControlador(this);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdAgregar = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        tfAgregarNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jsAgregarSaldo = new javax.swing.JSpinner();
        jbAgregarCancelar = new javax.swing.JButton();
        jbAgregarAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbAgregarGrupo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        tfAgregarQr = new javax.swing.JTextField();
        jbAgregarTomarFoto = new javax.swing.JButton();
        jlAgregarImagen = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfAgregarTutor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfAgregarTelefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfAgregarCorreo = new javax.swing.JTextField();
        jsAgregarComprasSinCredencial = new javax.swing.JSpinner();
        jdEditar = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        tfEditarNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jsEditarSaldo = new javax.swing.JSpinner();
        jbEditarCancelar = new javax.swing.JButton();
        jbEditarAceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbEditarGrupo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        tfEditarQr = new javax.swing.JTextField();
        jbEditarTomarFoto = new javax.swing.JButton();
        jlEditarImagen = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfEditarTutor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfEditarTelefono = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfEditarCorreo = new javax.swing.JTextField();
        jsEditarComprasSinCredencial = new javax.swing.JSpinner();
        jbRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jbControlDeGrupos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();

        jdAgregar.setTitle("Agregar producto");
        jdAgregar.setModal(true);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Saldo:");

        jsAgregarSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jbAgregarCancelar.setText("Cancelar");

        jbAgregarAceptar.setText("Aceptar");

        jLabel7.setText("Compras sin credencial:");

        jLabel3.setText("Grupo:");

        jcbAgregarGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("QR:");

        jbAgregarTomarFoto.setText("Tomar foto");

        jlAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png"))); // NOI18N

        jLabel17.setText("Tutor:");

        jLabel18.setText("Teléfono:");

        jLabel19.setText("Correo:");

        jsAgregarComprasSinCredencial.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jdAgregarLayout = new javax.swing.GroupLayout(jdAgregar.getContentPane());
        jdAgregar.getContentPane().setLayout(jdAgregarLayout);
        jdAgregarLayout.setHorizontalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdAgregarLayout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addComponent(jbAgregarCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAgregarAceptar))
                    .addGroup(jdAgregarLayout.createSequentialGroup()
                        .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jbAgregarTomarFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsAgregarSaldo)
                            .addComponent(tfAgregarNombre)
                            .addComponent(jcbAgregarGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAgregarQr)
                            .addComponent(tfAgregarTutor)
                            .addComponent(tfAgregarTelefono)
                            .addComponent(jsAgregarComprasSinCredencial, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfAgregarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlAgregarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jdAgregarLayout.setVerticalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAgregarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbAgregarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jsAgregarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfAgregarQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbAgregarTomarFoto)
                    .addComponent(jlAgregarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfAgregarTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tfAgregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdAgregarLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(jsAgregarComprasSinCredencial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarAceptar)
                    .addComponent(jbAgregarCancelar))
                .addContainerGap())
        );

        jdEditar.setTitle("Agregar producto");
        jdEditar.setModal(true);

        jLabel4.setText("Nombre:");

        jLabel5.setText("Saldo:");

        jsEditarSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jbEditarCancelar.setText("Cancelar");

        jbEditarAceptar.setText("Aceptar");

        jLabel8.setText("Compras sin credencial:");

        jLabel6.setText("Grupo:");

        jcbEditarGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("QR:");

        jbEditarTomarFoto.setText("Tomar foto");

        jlEditarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png"))); // NOI18N

        jLabel20.setText("Tutor:");

        jLabel21.setText("Teléfono:");

        jLabel22.setText("Correo:");

        jsEditarComprasSinCredencial.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jdEditarLayout = new javax.swing.GroupLayout(jdEditar.getContentPane());
        jdEditar.getContentPane().setLayout(jdEditarLayout);
        jdEditarLayout.setHorizontalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEditarLayout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addComponent(jbEditarCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditarAceptar))
                    .addGroup(jdEditarLayout.createSequentialGroup()
                        .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jbEditarTomarFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsEditarSaldo)
                            .addComponent(tfEditarNombre)
                            .addComponent(jcbEditarGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditarQr)
                            .addComponent(tfEditarTutor)
                            .addComponent(tfEditarTelefono)
                            .addComponent(jsEditarComprasSinCredencial, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfEditarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlEditarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jdEditarLayout.setVerticalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEditarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbEditarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jsEditarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfEditarQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbEditarTomarFoto)
                    .addComponent(jlEditarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tfEditarTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tfEditarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEditarLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jsEditarComprasSinCredencial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditarAceptar)
                    .addComponent(jbEditarCancelar))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");

        jbRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"))); // NOI18N
        jbRegresar.setText("Regresar");

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        jbControlDeGrupos.setText("Control de grupos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        jbAgregar.setText("Agregar");

        jbEliminar.setText("Eliminar");

        jbEditar.setText("Editar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jbEliminar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbControlDeGrupos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                        .addComponent(jbRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegresar)
                    .addComponent(jbControlDeGrupos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(JfMenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenuClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAgregarAceptar;
    private javax.swing.JButton jbAgregarCancelar;
    private javax.swing.JButton jbAgregarTomarFoto;
    private javax.swing.JButton jbControlDeGrupos;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEditarAceptar;
    private javax.swing.JButton jbEditarCancelar;
    private javax.swing.JButton jbEditarTomarFoto;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JComboBox<String> jcbAgregarGrupo;
    private javax.swing.JComboBox<String> jcbEditarGrupo;
    private javax.swing.JDialog jdAgregar;
    private javax.swing.JDialog jdEditar;
    private javax.swing.JLabel jlAgregarImagen;
    private javax.swing.JLabel jlEditarImagen;
    private javax.swing.JSpinner jsAgregarComprasSinCredencial;
    private javax.swing.JSpinner jsAgregarSaldo;
    private javax.swing.JSpinner jsEditarComprasSinCredencial;
    private javax.swing.JSpinner jsEditarSaldo;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfAgregarCorreo;
    private javax.swing.JTextField tfAgregarNombre;
    private javax.swing.JTextField tfAgregarQr;
    private javax.swing.JTextField tfAgregarTelefono;
    private javax.swing.JTextField tfAgregarTutor;
    private javax.swing.JTextField tfEditarCorreo;
    private javax.swing.JTextField tfEditarNombre;
    private javax.swing.JTextField tfEditarQr;
    private javax.swing.JTextField tfEditarTelefono;
    private javax.swing.JTextField tfEditarTutor;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getJbRegresar() {
        return jbRegresar;
    }

    @Override
    public void setJbRegresar(JButton jb) {
        this.jbRegresar = jb;
    }

    public javax.swing.JButton getJbAgregar() {
        return jbAgregar;
    }

    public void setJbAgregar(javax.swing.JButton jbAgregar) {
        this.jbAgregar = jbAgregar;
    }

    public javax.swing.JButton getJbAgregarAceptar() {
        return jbAgregarAceptar;
    }

    public void setJbAgregarAceptar(javax.swing.JButton jbAgregarAceptar) {
        this.jbAgregarAceptar = jbAgregarAceptar;
    }

    public javax.swing.JButton getJbAgregarCancelar() {
        return jbAgregarCancelar;
    }

    public void setJbAgregarCancelar(javax.swing.JButton jbAgregarCancelar) {
        this.jbAgregarCancelar = jbAgregarCancelar;
    }

    public javax.swing.JButton getJbAgregarTomarFoto() {
        return jbAgregarTomarFoto;
    }

    public void setJbAgregarTomarFoto(javax.swing.JButton jbAgregarTomarFoto) {
        this.jbAgregarTomarFoto = jbAgregarTomarFoto;
    }

    public javax.swing.JButton getJbControlDeGrupos() {
        return jbControlDeGrupos;
    }

    public void setJbControlDeGrupos(javax.swing.JButton jbControlDeGrupos) {
        this.jbControlDeGrupos = jbControlDeGrupos;
    }

    public javax.swing.JButton getJbEditar() {
        return jbEditar;
    }

    public void setJbEditar(javax.swing.JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    public javax.swing.JButton getJbEditarAceptar() {
        return jbEditarAceptar;
    }

    public void setJbEditarAceptar(javax.swing.JButton jbEditarAceptar) {
        this.jbEditarAceptar = jbEditarAceptar;
    }

    public javax.swing.JButton getJbEditarCancelar() {
        return jbEditarCancelar;
    }

    public void setJbEditarCancelar(javax.swing.JButton jbEditarCancelar) {
        this.jbEditarCancelar = jbEditarCancelar;
    }

    public javax.swing.JButton getJbEditarTomarFoto() {
        return jbEditarTomarFoto;
    }

    public void setJbEditarTomarFoto(javax.swing.JButton jbEditarTomarFoto) {
        this.jbEditarTomarFoto = jbEditarTomarFoto;
    }

    public javax.swing.JButton getJbEliminar() {
        return jbEliminar;
    }

    public void setJbEliminar(javax.swing.JButton jbEliminar) {
        this.jbEliminar = jbEliminar;
    }

    public javax.swing.JComboBox<String> getJcbAgregarGrupo() {
        return jcbAgregarGrupo;
    }

    public void setJcbAgregarGrupo(javax.swing.JComboBox jcbAgregarGrupo) {
        this.jcbAgregarGrupo = jcbAgregarGrupo;
    }

    public javax.swing.JComboBox<String> getJcbEditarGrupo() {
        return jcbEditarGrupo;
    }

    public void setJcbEditarGrupo(javax.swing.JComboBox jcbEditarGrupo) {
        this.jcbEditarGrupo = jcbEditarGrupo;
    }

    public javax.swing.JDialog getJdAgregar() {
        return jdAgregar;
    }

    public void setJdAgregar(javax.swing.JDialog jdAgregar) {
        this.jdAgregar = jdAgregar;
    }

    public javax.swing.JDialog getJdEditar() {
        return jdEditar;
    }

    public void setJdEditar(javax.swing.JDialog jdEditar) {
        this.jdEditar = jdEditar;
    }

    public javax.swing.JLabel getJlAgregarImagen() {
        return jlAgregarImagen;
    }

    public void setJlAgregarImagen(javax.swing.JLabel jlAgregarImagen) {
        this.jlAgregarImagen = jlAgregarImagen;
    }

    public javax.swing.JLabel getJlEditarImagen() {
        return jlEditarImagen;
    }

    public void setJlEditarImagen(javax.swing.JLabel jlEditarImagen) {
        this.jlEditarImagen = jlEditarImagen;
    }

    public javax.swing.JSpinner getJsAgregarComprasSinCredencial() {
        return jsAgregarComprasSinCredencial;
    }

    public void setJsAgregarComprasSinCredencial(javax.swing.JSpinner jsAgregarComprasSinCredencial) {
        this.jsAgregarComprasSinCredencial = jsAgregarComprasSinCredencial;
    }

    public javax.swing.JSpinner getJsAgregarSaldo() {
        return jsAgregarSaldo;
    }

    public void setJsAgregarSaldo(javax.swing.JSpinner jsAgregarSaldo) {
        this.jsAgregarSaldo = jsAgregarSaldo;
    }

    public javax.swing.JSpinner getJsEditarComprasSinCredencial() {
        return jsEditarComprasSinCredencial;
    }

    public void setJsEditarComprasSinCredencial(javax.swing.JSpinner jsEditarComprasSinCredencial) {
        this.jsEditarComprasSinCredencial = jsEditarComprasSinCredencial;
    }

    public javax.swing.JSpinner getJsEditarSaldo() {
        return jsEditarSaldo;
    }

    public void setJsEditarSaldo(javax.swing.JSpinner jsEditarSaldo) {
        this.jsEditarSaldo = jsEditarSaldo;
    }

    public javax.swing.JTable getJtDatos() {
        return jtDatos;
    }

    public void setJtDatos(javax.swing.JTable jtDatos) {
        this.jtDatos = jtDatos;
    }

    public javax.swing.JTextField getTfAgregarCorreo() {
        return tfAgregarCorreo;
    }

    public void setTfAgregarCorreo(javax.swing.JTextField tfAgregarCorreo) {
        this.tfAgregarCorreo = tfAgregarCorreo;
    }

    public javax.swing.JTextField getTfAgregarNombre() {
        return tfAgregarNombre;
    }

    public void setTfAgregarNombre(javax.swing.JTextField tfAgregarNombre) {
        this.tfAgregarNombre = tfAgregarNombre;
    }

    public javax.swing.JTextField getTfAgregarQr() {
        return tfAgregarQr;
    }

    public void setTfAgregarQr(javax.swing.JTextField tfAgregarQr) {
        this.tfAgregarQr = tfAgregarQr;
    }

    public javax.swing.JTextField getTfAgregarTelefono() {
        return tfAgregarTelefono;
    }

    public void setTfAgregarTelefono(javax.swing.JTextField tfAgregarTelefono) {
        this.tfAgregarTelefono = tfAgregarTelefono;
    }

    public javax.swing.JTextField getTfAgregarTutor() {
        return tfAgregarTutor;
    }

    public void setTfAgregarTutor(javax.swing.JTextField tfAgregarTutor) {
        this.tfAgregarTutor = tfAgregarTutor;
    }

    public javax.swing.JTextField getTfEditarCorreo() {
        return tfEditarCorreo;
    }

    public void setTfEditarCorreo(javax.swing.JTextField tfEditarCorreo) {
        this.tfEditarCorreo = tfEditarCorreo;
    }

    public javax.swing.JTextField getTfEditarNombre() {
        return tfEditarNombre;
    }

    public void setTfEditarNombre(javax.swing.JTextField tfEditarNombre) {
        this.tfEditarNombre = tfEditarNombre;
    }

    public javax.swing.JTextField getTfEditarQr() {
        return tfEditarQr;
    }

    public void setTfEditarQr(javax.swing.JTextField tfEditarQr) {
        this.tfEditarQr = tfEditarQr;
    }

    public javax.swing.JTextField getTfEditarTelefono() {
        return tfEditarTelefono;
    }

    public void setTfEditarTelefono(javax.swing.JTextField tfEditarTelefono) {
        this.tfEditarTelefono = tfEditarTelefono;
    }

    public javax.swing.JTextField getTfEditarTutor() {
        return tfEditarTutor;
    }

    public void setTfEditarTutor(javax.swing.JTextField tfEditarTutor) {
        this.tfEditarTutor = tfEditarTutor;
    }
}
