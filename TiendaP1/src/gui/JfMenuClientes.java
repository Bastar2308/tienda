/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import guiif.JfMenuClientesIf;
import javax.swing.JButton;
import controladores.MenuClientesControlador;
import java.awt.Color;

/**
 *
 * @author BurnKill
 */
public class JfMenuClientes extends javax.swing.JFrame implements JfMenuClientesIf {

    MenuClientesControlador controlador;
    String ruta = null;

    /**
     * Creates new form MenuClientes
     */
    public JfMenuClientes() {
        initComponents();
        controlador = new MenuClientesControlador(this);
        getContentPane().setBackground(new Color(51, 51, 51));
        jdAgregar.getContentPane().setBackground(new Color(51, 51, 51));
        jdEditar.getContentPane().setBackground(new Color(51, 51, 51));
        setLocationRelativeTo(null);
        //auxiliares.GuiTools.getInstance().config(this);
    }

    public static JfMenuClientes getInstance() {
        return JfMenuClientesHolder.INSTANCE;
    }

    @Override
    public javax.swing.JButton getJbVer() {
        return jbVer;
    }

    @Override
    public void setJbVer(javax.swing.JButton jbVer) {
        this.jbVer = jbVer;
    }

    @Override
    public javax.swing.JComboBox<pojo.Grupo> getJcbVerGrupo() {
        return jcbVerGrupo;
    }

    @Override
    public void setJcbVerGrupo(javax.swing.JComboBox<pojo.Grupo> jcbVerGrupo) {
        this.jcbVerGrupo = jcbVerGrupo;
    }

    public javax.swing.JDialog getJdVer() {
        return jdVer;
    }

    public void setJdVer(javax.swing.JDialog jdVer) {
        this.jdVer = jdVer;
    }

    @Override
    public javax.swing.JLabel getJlVerImagen() {
        return jlVerImagen;
    }

    @Override
    public void setJlVerImagen(javax.swing.JLabel jlVerImagen) {
        this.jlVerImagen = jlVerImagen;
    }

    @Override
    public javax.swing.JSpinner getJsVerSaldo() {
        return jsVerSaldo;
    }

    @Override
    public void setJsVerSaldo(javax.swing.JSpinner jsVerSaldo) {
        this.jsVerSaldo = jsVerSaldo;
    }

    @Override
    public javax.swing.JTextField getTfVerCorreo() {
        return tfVerCorreo;
    }

    @Override
    public void setTfVerCorreo(javax.swing.JTextField tfVerCorreo) {
        this.tfVerCorreo = tfVerCorreo;
    }

    @Override
    public javax.swing.JTextField getTfVerNombre() {
        return tfVerNombre;
    }

    @Override
    public void setTfVerNombre(javax.swing.JTextField tfVerNombre) {
        this.tfVerNombre = tfVerNombre;
    }

    @Override
    public javax.swing.JTextField getTfVerQr() {
        return tfVerQr;
    }

    @Override
    public void setTfVerQr(javax.swing.JTextField tfVerQr) {
        this.tfVerQr = tfVerQr;
    }

    @Override
    public javax.swing.JTextField getTfVerTelefono() {
        return tfVerTelefono;
    }

    @Override
    public void setTfVerTelefono(javax.swing.JTextField tfVerTelefono) {
        this.tfVerTelefono = tfVerTelefono;
    }

    @Override
    public javax.swing.JTextField getTfVerTutor() {
        return tfVerTutor;
    }

    @Override
    public void setTfVerTutor(javax.swing.JTextField tfVerTutor) {
        this.tfVerTutor = tfVerTutor;
    }

    @Override
    public String getSRuta() {
        return ruta;
    }

    @Override
    public void setSRuta(String ruta) {
        this.ruta = ruta;
    }

    public javax.swing.JSpinner getJsAgregarLimite() {
        return jsAgregarLimite;
    }

    public void setJsAgregarLimite(javax.swing.JSpinner jsAgregarLimite) {
        this.jsAgregarLimite = jsAgregarLimite;
    }

    public javax.swing.JSpinner getJsEditarLimite() {
        return jsEditarLimite;
    }

    public void setJsEditarLimite(javax.swing.JSpinner jsEditarLimite) {
        this.jsEditarLimite = jsEditarLimite;
    }

    public javax.swing.JSpinner getJsVerLimite() {
        return jsVerLimite;
    }

    public void setJsVerLimite(javax.swing.JSpinner jsVerLimite) {
        this.jsVerLimite = jsVerLimite;
    }

    public javax.swing.JTextField getJlFiltro() {
        return JlFiltro;
    }

    public void setJlFiltro(javax.swing.JTextField JlFiltro) {
        this.JlFiltro = JlFiltro;
    }

    public javax.swing.JButton getJbReporte() {
        return JbReporte;
    }

    public void setJbReporte(javax.swing.JButton JbReporte) {
        this.JbReporte = JbReporte;
    }

    public javax.swing.JLabel getJlDesde() {
        return JlDesde;
    }

    public void setJlDesde(javax.swing.JLabel JlDesde) {
        this.JlDesde = JlDesde;
    }

    public javax.swing.JLabel getJlHasta() {
        return JlHasta;
    }

    public void setJlHasta(javax.swing.JLabel JlHasta) {
        this.JlHasta = JlHasta;
    }

    public javax.swing.JTable getJtReporte() {
        return JtReporte;
    }

    public void setJtReporte(javax.swing.JTable JtReporte) {
        this.JtReporte = JtReporte;
    }

    public javax.swing.JDialog getJdReporte() {
        return jdReporte;
    }

    public void setJdReporte(javax.swing.JDialog jdReporte) {
        this.jdReporte = jdReporte;
    }

    public javax.swing.JLabel getJlNombre() {
        return jlNombre;
    }

    public void setJlNombre(javax.swing.JLabel jlNombre) {
        this.jlNombre = jlNombre;
    }

    public javax.swing.JButton getJbEnviar() {
        return JbEnviar;
    }

    public void setJbEnviar(javax.swing.JButton JbEnviar) {
        this.JbEnviar = JbEnviar;
    }

    private static class JfMenuClientesHolder {

        private static final JfMenuClientes INSTANCE = new JfMenuClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdAgregar = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jlAgregarImagen = new javax.swing.JLabel();
        jcbAgregarGrupo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfAgregarCorreo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jbAgregarAceptar = new javax.swing.JButton();
        tfAgregarTelefono = new javax.swing.JTextField();
        jbAgregarCancelar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jsAgregarSaldo = new javax.swing.JSpinner();
        tfAgregarTutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfAgregarNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbAgregarTomarFoto = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jsAgregarLimite = new javax.swing.JSpinner();
        jdEditar = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbEditarTomarFoto = new javax.swing.JButton();
        tfEditarQr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcbEditarGrupo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfEditarCorreo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jbEditarAceptar = new javax.swing.JButton();
        tfEditarTelefono = new javax.swing.JTextField();
        jbEditarCancelar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jsEditarSaldo = new javax.swing.JSpinner();
        tfEditarTutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfEditarNombre = new javax.swing.JTextField();
        jlEditarImagen = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jsEditarLimite = new javax.swing.JSpinner();
        jdVer = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfVerQr = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jcbVerGrupo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfVerCorreo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfVerTelefono = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jsVerSaldo = new javax.swing.JSpinner();
        tfVerTutor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfVerNombre = new javax.swing.JTextField();
        jlVerImagen = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jsVerLimite = new javax.swing.JSpinner();
        jdReporte = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jlVerImagen1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JlDesde = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JlHasta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtReporte = new javax.swing.JTable();
        JbEnviar = new javax.swing.JButton();
        jbRegresar = new javax.swing.JButton();
        jbControlDeGrupos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbVer = new javax.swing.JButton();
        JbReporte = new javax.swing.JButton();
        JlFiltro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jdAgregar.setTitle("Agregar cliente");
        jdAgregar.setModal(true);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Grupo:");

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Correo:");

        jbAgregarAceptar.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregarAceptar.setText("Aceptar");

        jbAgregarCancelar.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregarCancelar.setText("Cancelar");

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Teléfono:");

        jsAgregarSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo:");

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tutor:");

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        jbAgregarTomarFoto.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregarTomarFoto.setText("Tomar foto");

        jLabel27.setBackground(new java.awt.Color(102, 102, 102));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Límite de crédito:");

        jsAgregarLimite.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAgregarCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAgregarAceptar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jbAgregarTomarFoto)
                            .addComponent(jLabel27))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsAgregarSaldo)
                            .addComponent(tfAgregarNombre)
                            .addComponent(jcbAgregarGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAgregarTutor)
                            .addComponent(tfAgregarTelefono)
                            .addComponent(tfAgregarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlAgregarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(jsAgregarLimite))))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAgregarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbAgregarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jsAgregarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbAgregarTomarFoto)
                    .addComponent(jlAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfAgregarTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tfAgregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jsAgregarLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarAceptar)
                    .addComponent(jbAgregarCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdAgregarLayout = new javax.swing.GroupLayout(jdAgregar.getContentPane());
        jdAgregar.getContentPane().setLayout(jdAgregarLayout);
        jdAgregarLayout.setHorizontalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdAgregarLayout.setVerticalGroup(
            jdAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jdEditar.setTitle("Agregar producto");
        jdEditar.setModal(true);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");

        jbEditarTomarFoto.setBackground(new java.awt.Color(102, 102, 102));
        jbEditarTomarFoto.setText("Tomar foto");

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("QR:");

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Grupo:");

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Correo:");

        jbEditarAceptar.setBackground(new java.awt.Color(102, 102, 102));
        jbEditarAceptar.setText("Aceptar");

        jbEditarCancelar.setBackground(new java.awt.Color(102, 102, 102));
        jbEditarCancelar.setText("Cancelar");

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Teléfono:");

        jsEditarSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Saldo:");

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tutor:");

        jLabel28.setBackground(new java.awt.Color(102, 102, 102));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Límite de crédito:");

        jsEditarLimite.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 10));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(44, 44, 44)
                        .addComponent(jsEditarLimite))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbEditarCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditarAceptar)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jbEditarTomarFoto))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsEditarSaldo)
                            .addComponent(tfEditarNombre)
                            .addComponent(jcbEditarGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEditarTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfEditarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfEditarTutor)
                                    .addComponent(jlEditarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                            .addComponent(tfEditarQr, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEditarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbEditarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jsEditarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfEditarQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbEditarTomarFoto)
                    .addComponent(jlEditarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tfEditarTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tfEditarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jsEditarLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditarAceptar)
                    .addComponent(jbEditarCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdEditarLayout = new javax.swing.GroupLayout(jdEditar.getContentPane());
        jdEditar.getContentPane().setLayout(jdEditarLayout);
        jdEditarLayout.setHorizontalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdEditarLayout.setVerticalGroup(
            jdEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEditarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jdVer.setTitle("Agregar producto");
        jdVer.setModal(true);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre:");

        tfVerQr.setEnabled(false);

        jLabel23.setBackground(new java.awt.Color(102, 102, 102));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("QR:");

        jcbVerGrupo.setEnabled(false);

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Grupo:");

        tfVerCorreo.setEnabled(false);

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Correo:");

        tfVerTelefono.setEnabled(false);

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Teléfono:");

        jsVerSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jsVerSaldo.setEnabled(false);

        tfVerTutor.setEnabled(false);

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Saldo:");

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tutor:");

        tfVerNombre.setEnabled(false);

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Límite de crédito:");

        jsVerLimite.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 10));
        jsVerLimite.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(44, 44, 44)
                        .addComponent(jsVerLimite))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsVerSaldo)
                            .addComponent(tfVerNombre)
                            .addComponent(jcbVerGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfVerTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfVerCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfVerTutor)
                                    .addComponent(jlVerImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                            .addComponent(tfVerQr, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfVerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcbVerGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jsVerSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tfVerQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(jlVerImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tfVerTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tfVerTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tfVerCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jsVerLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdVerLayout = new javax.swing.GroupLayout(jdVer.getContentPane());
        jdVer.getContentPane().setLayout(jdVerLayout);
        jdVerLayout.setHorizontalGroup(
            jdVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdVerLayout.setVerticalGroup(
            jdVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdVerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jdReporte.setTitle("Reporte de consumo");
        jdReporte.setModal(true);
        jdReporte.setResizable(false);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consumo de");

        jlNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setText("{nombre}");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("desde el");

        JlDesde.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlDesde.setForeground(new java.awt.Color(255, 255, 255));
        JlDesde.setText("{diaSemana diaMes de mes}");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("hasta el");

        JlHasta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JlHasta.setForeground(new java.awt.Color(255, 255, 255));
        JlHasta.setText("{diaSemana diaMes de mes}");

        JtReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JtReporte.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(JtReporte);

        JbEnviar.setBackground(new java.awt.Color(102, 102, 102));
        JbEnviar.setText("Enviar reporte al correo del tutor");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(JbEnviar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jlVerImagen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlDesde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlHasta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jlVerImagen1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jlNombre)
                            .addComponent(jLabel12)
                            .addComponent(JlDesde)
                            .addComponent(jLabel15)
                            .addComponent(JlHasta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addComponent(JbEnviar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jdReporteLayout = new javax.swing.GroupLayout(jdReporte.getContentPane());
        jdReporte.getContentPane().setLayout(jdReporteLayout);
        jdReporteLayout.setHorizontalGroup(
            jdReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdReporteLayout.setVerticalGroup(
            jdReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdReporteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        jbRegresar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegresar.setText("Regresar");

        jbControlDeGrupos.setBackground(new java.awt.Color(51, 51, 51));
        jbControlDeGrupos.setText("Control de grupos");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Grupo", "Nombre", "Saldo", "Límite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDatos);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jbAgregar.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregar.setText("Agregar");

        jbEliminar.setBackground(new java.awt.Color(102, 102, 102));
        jbEliminar.setText("Eliminar");

        jbEditar.setBackground(new java.awt.Color(102, 102, 102));
        jbEditar.setText("Editar");

        jbVer.setBackground(new java.awt.Color(102, 102, 102));
        jbVer.setText("Ver");

        JbReporte.setBackground(new java.awt.Color(102, 102, 102));
        JbReporte.setText("Reporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVer)
                .addGap(18, 18, 18)
                .addComponent(JbReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jbEliminar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addComponent(JlFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Menú de clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel9)
                .addGap(52, 52, 52)
                .addComponent(jbControlDeGrupos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegresar)
                .addGap(50, 50, 50))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegresar)
                    .addComponent(jbControlDeGrupos)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
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
                if ("Windows".equals(info.getName())) {
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
            @Override
            public void run() {
                new JfMenuClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEnviar;
    private javax.swing.JButton JbReporte;
    private javax.swing.JLabel JlDesde;
    private javax.swing.JTextField JlFiltro;
    private javax.swing.JLabel JlHasta;
    private javax.swing.JTable JtReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JButton jbVer;
    private javax.swing.JComboBox<pojo.Grupo> jcbAgregarGrupo;
    private javax.swing.JComboBox<pojo.Grupo> jcbEditarGrupo;
    private javax.swing.JComboBox<pojo.Grupo> jcbVerGrupo;
    private javax.swing.JDialog jdAgregar;
    private javax.swing.JDialog jdEditar;
    private javax.swing.JDialog jdReporte;
    private javax.swing.JDialog jdVer;
    private javax.swing.JLabel jlAgregarImagen;
    private javax.swing.JLabel jlEditarImagen;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlVerImagen;
    private javax.swing.JLabel jlVerImagen1;
    private javax.swing.JSpinner jsAgregarLimite;
    private javax.swing.JSpinner jsAgregarSaldo;
    private javax.swing.JSpinner jsEditarLimite;
    private javax.swing.JSpinner jsEditarSaldo;
    private javax.swing.JSpinner jsVerLimite;
    private javax.swing.JSpinner jsVerSaldo;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField tfAgregarCorreo;
    private javax.swing.JTextField tfAgregarNombre;
    private javax.swing.JTextField tfAgregarTelefono;
    private javax.swing.JTextField tfAgregarTutor;
    private javax.swing.JTextField tfEditarCorreo;
    private javax.swing.JTextField tfEditarNombre;
    private javax.swing.JTextField tfEditarQr;
    private javax.swing.JTextField tfEditarTelefono;
    private javax.swing.JTextField tfEditarTutor;
    private javax.swing.JTextField tfVerCorreo;
    private javax.swing.JTextField tfVerNombre;
    private javax.swing.JTextField tfVerQr;
    private javax.swing.JTextField tfVerTelefono;
    private javax.swing.JTextField tfVerTutor;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getJbRegresar() {
        return jbRegresar;
    }

    @Override
    public void setJbRegresar(JButton jb) {
        this.jbRegresar = jb;
    }

    @Override
    public javax.swing.JButton getJbAgregar() {
        return jbAgregar;
    }

    @Override
    public void setJbAgregar(javax.swing.JButton jbAgregar) {
        this.jbAgregar = jbAgregar;
    }

    @Override
    public javax.swing.JButton getJbAgregarAceptar() {
        return jbAgregarAceptar;
    }

    @Override
    public void setJbAgregarAceptar(javax.swing.JButton jbAgregarAceptar) {
        this.jbAgregarAceptar = jbAgregarAceptar;
    }

    @Override
    public javax.swing.JButton getJbAgregarCancelar() {
        return jbAgregarCancelar;
    }

    @Override
    public void setJbAgregarCancelar(javax.swing.JButton jbAgregarCancelar) {
        this.jbAgregarCancelar = jbAgregarCancelar;
    }

    @Override
    public javax.swing.JButton getJbAgregarTomarFoto() {
        return jbAgregarTomarFoto;
    }

    @Override
    public void setJbAgregarTomarFoto(javax.swing.JButton jbAgregarTomarFoto) {
        this.jbAgregarTomarFoto = jbAgregarTomarFoto;
    }

    @Override
    public javax.swing.JButton getJbControlDeGrupos() {
        return jbControlDeGrupos;
    }

    @Override
    public void setJbControlDeGrupos(javax.swing.JButton jbControlDeGrupos) {
        this.jbControlDeGrupos = jbControlDeGrupos;
    }

    @Override
    public javax.swing.JButton getJbEditar() {
        return jbEditar;
    }

    @Override
    public void setJbEditar(javax.swing.JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    @Override
    public javax.swing.JButton getJbEditarAceptar() {
        return jbEditarAceptar;
    }

    @Override
    public void setJbEditarAceptar(javax.swing.JButton jbEditarAceptar) {
        this.jbEditarAceptar = jbEditarAceptar;
    }

    @Override
    public javax.swing.JButton getJbEditarCancelar() {
        return jbEditarCancelar;
    }

    @Override
    public void setJbEditarCancelar(javax.swing.JButton jbEditarCancelar) {
        this.jbEditarCancelar = jbEditarCancelar;
    }

    @Override
    public javax.swing.JButton getJbEditarTomarFoto() {
        return jbEditarTomarFoto;
    }

    @Override
    public void setJbEditarTomarFoto(javax.swing.JButton jbEditarTomarFoto) {
        this.jbEditarTomarFoto = jbEditarTomarFoto;
    }

    @Override
    public javax.swing.JButton getJbEliminar() {
        return jbEliminar;
    }

    @Override
    public void setJbEliminar(javax.swing.JButton jbEliminar) {
        this.jbEliminar = jbEliminar;
    }

    @Override
    public javax.swing.JComboBox<pojo.Grupo> getJcbAgregarGrupo() {
        return jcbAgregarGrupo;
    }

    @Override
    public void setJcbAgregarGrupo(javax.swing.JComboBox<pojo.Grupo> jcbAgregarGrupo) {
        this.jcbAgregarGrupo = jcbAgregarGrupo;
    }

    @Override
    public javax.swing.JComboBox<pojo.Grupo> getJcbEditarGrupo() {
        return jcbEditarGrupo;
    }

    @Override
    public void setJcbEditarGrupo(javax.swing.JComboBox<pojo.Grupo> jcbEditarGrupo) {
        this.jcbEditarGrupo = jcbEditarGrupo;
    }

    @Override
    public javax.swing.JDialog getJdAgregar() {
        return jdAgregar;
    }

    @Override
    public void setJdAgregar(javax.swing.JDialog jdAgregar) {
        this.jdAgregar = jdAgregar;
    }

    @Override
    public javax.swing.JDialog getJdEditar() {
        return jdEditar;
    }

    @Override
    public void setJdEditar(javax.swing.JDialog jdEditar) {
        this.jdEditar = jdEditar;
    }

    @Override
    public javax.swing.JLabel getJlAgregarImagen() {
        return jlAgregarImagen;
    }

    @Override
    public void setJlAgregarImagen(javax.swing.JLabel jlAgregarImagen) {
        this.jlAgregarImagen = jlAgregarImagen;
    }

    @Override
    public javax.swing.JLabel getJlEditarImagen() {
        return jlEditarImagen;
    }

    @Override
    public void setJlEditarImagen(javax.swing.JLabel jlEditarImagen) {
        this.jlEditarImagen = jlEditarImagen;
    }

    @Override
    public javax.swing.JSpinner getJsAgregarSaldo() {
        return jsAgregarSaldo;
    }

    @Override
    public void setJsAgregarSaldo(javax.swing.JSpinner jsAgregarSaldo) {
        this.jsAgregarSaldo = jsAgregarSaldo;
    }

  
    @Override
    public javax.swing.JSpinner getJsEditarSaldo() {
        return jsEditarSaldo;
    }

    @Override
    public void setJsEditarSaldo(javax.swing.JSpinner jsEditarSaldo) {
        this.jsEditarSaldo = jsEditarSaldo;
    }

    @Override
    public javax.swing.JTable getJtDatos() {
        return jtDatos;
    }

    @Override
    public void setJtDatos(javax.swing.JTable jtDatos) {
        this.jtDatos = jtDatos;
    }

    @Override
    public javax.swing.JTextField getTfAgregarCorreo() {
        return tfAgregarCorreo;
    }

    @Override
    public void setTfAgregarCorreo(javax.swing.JTextField tfAgregarCorreo) {
        this.tfAgregarCorreo = tfAgregarCorreo;
    }

    @Override
    public javax.swing.JTextField getTfAgregarNombre() {
        return tfAgregarNombre;
    }

    @Override
    public void setTfAgregarNombre(javax.swing.JTextField tfAgregarNombre) {
        this.tfAgregarNombre = tfAgregarNombre;
    }

    @Override
    public javax.swing.JTextField getTfAgregarTelefono() {
        return tfAgregarTelefono;
    }

    @Override
    public void setTfAgregarTelefono(javax.swing.JTextField tfAgregarTelefono) {
        this.tfAgregarTelefono = tfAgregarTelefono;
    }

    @Override
    public javax.swing.JTextField getTfAgregarTutor() {
        return tfAgregarTutor;
    }

    @Override
    public void setTfAgregarTutor(javax.swing.JTextField tfAgregarTutor) {
        this.tfAgregarTutor = tfAgregarTutor;
    }

    @Override
    public javax.swing.JTextField getTfEditarCorreo() {
        return tfEditarCorreo;
    }

    @Override
    public void setTfEditarCorreo(javax.swing.JTextField tfEditarCorreo) {
        this.tfEditarCorreo = tfEditarCorreo;
    }

    @Override
    public javax.swing.JTextField getTfEditarNombre() {
        return tfEditarNombre;
    }

    @Override
    public void setTfEditarNombre(javax.swing.JTextField tfEditarNombre) {
        this.tfEditarNombre = tfEditarNombre;
    }

    @Override
    public javax.swing.JTextField getTfEditarQr() {
        return tfEditarQr;
    }

    @Override
    public void setTfEditarQr(javax.swing.JTextField tfEditarQr) {
        this.tfEditarQr = tfEditarQr;
    }

    @Override
    public javax.swing.JTextField getTfEditarTelefono() {
        return tfEditarTelefono;
    }

    @Override
    public void setTfEditarTelefono(javax.swing.JTextField tfEditarTelefono) {
        this.tfEditarTelefono = tfEditarTelefono;
    }

    @Override
    public javax.swing.JTextField getTfEditarTutor() {
        return tfEditarTutor;
    }

    @Override
    public void setTfEditarTutor(javax.swing.JTextField tfEditarTutor) {
        this.tfEditarTutor = tfEditarTutor;
    }

}
