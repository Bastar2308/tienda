/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

/**
 *
 * @author BurnKill
 */
public class JfControlDeGrupos extends javax.swing.JFrame {

    /**
     * Creates new form JfControlDeGrupos
     */
    public JfControlDeGrupos() {
        initComponents();
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
        jbAgregarCancelar = new javax.swing.JButton();
        jbAgregarAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfAgregarNivel = new javax.swing.JTextField();
        jdEliminar = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jlGrupo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbEliminarCancelar = new javax.swing.JButton();
        jbEliminarAceptar = new javax.swing.JButton();
        jdEditar = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        tfEditarNombre = new javax.swing.JTextField();
        jbEditarCancelar = new javax.swing.JButton();
        jbEditarAceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfEditarNivel = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();

        jdAgregar.setTitle("Agregar marca");
        jdAgregar.setModal(true);

        jLabel1.setText("Nombre:");

        jbAgregarCancelar.setText("Cancelar");

        jbAgregarAceptar.setText("Aceptar");

        jLabel6.setText("Nivel:");

        javax.swing.GroupLayout jdAgregarLayout = new javax.swing.GroupLayout(jdAgregar.getContentPane());
        jdAgregar.getContentPane().setLayout(jdAgregarLayout);
        jdAgregarLayout.setHorizontalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdAgregarLayout.createSequentialGroup()
                        .addGap(0, 190, Short.MAX_VALUE)
                        .addComponent(jbAgregarCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbAgregarAceptar))
                    .addGroup(jdAgregarLayout.createSequentialGroup()
                        .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAgregarNivel)
                            .addComponent(tfAgregarNombre))))
                .addContainerGap())
        );
        jdAgregarLayout.setVerticalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAgregarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAgregarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarAceptar)
                    .addComponent(jbAgregarCancelar))
                .addContainerGap())
        );

        jdEliminar.setTitle("Eliminar marca");

        jLabel3.setText("¿Reálmente desea eliminar");

        jlGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlGrupo.setText("<grupo>");

        jLabel5.setText("?");

        jbEliminarCancelar.setText("Cancelar");

        jbEliminarAceptar.setText("Aceptar");

        javax.swing.GroupLayout jdEliminarLayout = new javax.swing.GroupLayout(jdEliminar.getContentPane());
        jdEliminar.getContentPane().setLayout(jdEliminarLayout);
        jdEliminarLayout.setHorizontalGroup(
            jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 181, Short.MAX_VALUE))
                    .addGroup(jdEliminarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbEliminarCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminarAceptar)))
                .addContainerGap())
        );
        jdEliminarLayout.setVerticalGroup(
            jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jlGrupo)))
                .addGap(35, 35, 35)
                .addGroup(jdEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminarAceptar)
                    .addComponent(jbEliminarCancelar))
                .addContainerGap())
        );

        jdEditar.setTitle("Agregar marca");
        jdEditar.setModal(true);

        jLabel7.setText("Nombre:");

        jbEditarCancelar.setText("Cancelar");

        jbEditarAceptar.setText("Aceptar");

        jLabel8.setText("Nivel:");

        javax.swing.GroupLayout jdEditarLayout = new javax.swing.GroupLayout(jdEditar.getContentPane());
        jdEditar.getContentPane().setLayout(jdEditarLayout);
        jdEditarLayout.setHorizontalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEditarLayout.createSequentialGroup()
                        .addGap(0, 190, Short.MAX_VALUE)
                        .addComponent(jbEditarCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditarAceptar))
                    .addGroup(jdEditarLayout.createSequentialGroup()
                        .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEditarNivel)
                            .addComponent(tfEditarNombre))))
                .addContainerGap())
        );
        jdEditarLayout.setVerticalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfEditarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfEditarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditarAceptar)
                    .addComponent(jbEditarCancelar))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de grupos");

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
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEliminar)
                .addContainerGap())
        );

        jbRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"))); // NOI18N
        jbRegresar.setText("Regresar");

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDatos.setColumnSelectionAllowed(true);
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDatos);
        jtDatos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(JfControlDeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfControlDeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfControlDeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfControlDeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfControlDeGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAgregarAceptar;
    private javax.swing.JButton jbAgregarCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEditarAceptar;
    private javax.swing.JButton jbEditarCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEliminarAceptar;
    private javax.swing.JButton jbEliminarCancelar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JDialog jdAgregar;
    private javax.swing.JDialog jdEditar;
    private javax.swing.JDialog jdEliminar;
    private javax.swing.JLabel jlGrupo;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfAgregarNivel;
    private javax.swing.JTextField tfAgregarNombre;
    private javax.swing.JTextField tfEditarNivel;
    private javax.swing.JTextField tfEditarNombre;
    // End of variables declaration//GEN-END:variables
}
