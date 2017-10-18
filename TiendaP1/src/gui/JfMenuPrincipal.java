/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import controladores.MenuPrincipalControlador;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author BurnKill
 */
public class JfMenuPrincipal extends javax.swing.JFrame implements guiif.JfMenuPrincipalIf {

    /**
     * Creates new form MenuPrincipal
     */
    private MenuPrincipalControlador controlador;

    public JfMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(51, 51, 51));
        controlador = new MenuPrincipalControlador(this);
    }

    public static JfMenuPrincipal getInstance() {
        return JfMenuPrincipalHolder.INSTANCE;
    }

    private static class JfMenuPrincipalHolder {

        private static final JfMenuPrincipal INSTANCE = new JfMenuPrincipal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbPuntoDeVista = new javax.swing.JButton();
        jbCargarSaldo = new javax.swing.JButton();
        jbGeneradorDeCredenciales = new javax.swing.JButton();
        jbFinanzas = new javax.swing.JButton();
        jbClientes = new javax.swing.JButton();
        jbMenuProductos = new javax.swing.JButton();
        jbAyuda = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/menuIcono.png"))); // NOI18N
        jLabel1.setText("  Menú principal");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jbPuntoDeVista.setBackground(new java.awt.Color(204, 204, 204));
        jbPuntoDeVista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbPuntoDeVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/puntoDeVenta.png"))); // NOI18N
        jbPuntoDeVista.setText("Punto de Venta");
        jbPuntoDeVista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbPuntoDeVista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbPuntoDeVista.setIconTextGap(15);
        jbPuntoDeVista.setMargin(new java.awt.Insets(30, 20, 30, 20));
        jbPuntoDeVista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbCargarSaldo.setBackground(new java.awt.Color(204, 204, 204));
        jbCargarSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbCargarSaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregarSaldo.png"))); // NOI18N
        jbCargarSaldo.setText("Cargar Saldo");
        jbCargarSaldo.setBorder(null);
        jbCargarSaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCargarSaldo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCargarSaldo.setIconTextGap(15);
        jbCargarSaldo.setMargin(new java.awt.Insets(30, 90, 10, 80));
        jbCargarSaldo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbGeneradorDeCredenciales.setBackground(new java.awt.Color(204, 204, 204));
        jbGeneradorDeCredenciales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbGeneradorDeCredenciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/generador.png"))); // NOI18N
        jbGeneradorDeCredenciales.setText("Generador de credenciales");
        jbGeneradorDeCredenciales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbGeneradorDeCredenciales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGeneradorDeCredenciales.setIconTextGap(15);
        jbGeneradorDeCredenciales.setMargin(new java.awt.Insets(30, 10, 30, 10));
        jbGeneradorDeCredenciales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbFinanzas.setBackground(new java.awt.Color(204, 204, 204));
        jbFinanzas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbFinanzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/finanzas.png"))); // NOI18N
        jbFinanzas.setText("Finanzas");
        jbFinanzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbFinanzas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFinanzas.setIconTextGap(15);
        jbFinanzas.setMargin(new java.awt.Insets(30, 10, 30, 10));
        jbFinanzas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbClientes.setBackground(new java.awt.Color(204, 204, 204));
        jbClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/clientes.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbClientes.setIconTextGap(15);
        jbClientes.setMargin(new java.awt.Insets(30, 10, 30, 10));
        jbClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbMenuProductos.setBackground(new java.awt.Color(204, 204, 204));
        jbMenuProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbMenuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/productos.png"))); // NOI18N
        jbMenuProductos.setText("Menu Productos");
        jbMenuProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMenuProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMenuProductos.setIconTextGap(15);
        jbMenuProductos.setMargin(new java.awt.Insets(30, 20, 30, 20));
        jbMenuProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbGeneradorDeCredenciales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbPuntoDeVista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCargarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbMenuProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCargarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMenuProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbGeneradorDeCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPuntoDeVista, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jbAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda.png"))); // NOI18N
        jbAyuda.setBorder(null);
        jbAyuda.setBorderPainted(false);
        jbAyuda.setContentAreaFilled(false);
        jbAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAyuda.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayudamenor.png"))); // NOI18N

        jlUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuario.setText("[USUARIO ACTUAL]");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAyuda)
                .addGap(28, 28, 28))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAyuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAyuda;
    private javax.swing.JButton jbCargarSaldo;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbFinanzas;
    private javax.swing.JButton jbGeneradorDeCredenciales;
    private javax.swing.JButton jbMenuProductos;
    private javax.swing.JButton jbPuntoDeVista;
    private javax.swing.JLabel jlUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public JLabel getJlUsuario() {
        return jlUsuario;
    }

    @Override
    public void setJlUsuario(JLabel jl) {
        this.jlUsuario = jl;
    }

    @Override
    public JButton getJbAyuda() {
        return jbAyuda;
    }

    @Override
    public void setJbAyuda(JButton jb) {
        this.jbAyuda = jb;
    }

    @Override
    public JButton getJbCargarSaldo() {
        return jbCargarSaldo;
    }

    @Override
    public void setJbCargarSaldo(JButton jb) {
        this.jbCargarSaldo = jb;
    }

    @Override
    public JButton getJbFinanzas() {
        return jbFinanzas;
    }

    @Override
    public void setJbFinanzas(JButton jb) {
        this.jbFinanzas = jb;
    }

    @Override
    public JButton getJbClientes() {
        return jbClientes;
    }

    public JButton getJbMenuProductos() {
        return jbMenuProductos;
    }

    public void setJbMenuProductos(JButton jbMenuProductos) {
        this.jbMenuProductos = jbMenuProductos;
    }

    @Override
    public void setJbClientes(JButton jb) {
        this.jbClientes = jb;
    }

    @Override
    public JButton getJbGeneradorDeCredenciales() {
        return jbGeneradorDeCredenciales;
    }

    @Override
    public void setJbGeneradorDeCredenciales(JButton jb) {
        this.jbGeneradorDeCredenciales = jb;
    }

    @Override
    public JButton getJbPuntoDeVentas() {
        return jbPuntoDeVista;
    }

    @Override
    public void setJbPuntoDeVentas(JButton jb) {
        this.jbPuntoDeVista = jb;
    }

}
