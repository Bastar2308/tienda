/*
 * Coded by David Vazquez using NetBeans.
 */
package gui;

import guiif.JfPuntoDeVentaIf;
import javax.swing.JButton;
import controladores.PuntoDeVentaControlador;
import java.awt.Color;

/**
 *
 * @author BurnKill
 */
public class JfPuntoDeVenta extends javax.swing.JFrame implements JfPuntoDeVentaIf {

    private PuntoDeVentaControlador controlador;

    /**
     * Creates new form JfPuntoDeVenta
     */
    public JfPuntoDeVenta() {
        initComponents();
        getContentPane().setBackground(new Color(51, 51, 51));
        controlador = new PuntoDeVentaControlador(this);
        setLocationRelativeTo(null);
        auxiliares.GuiTools.getInstance().config(this);
    }

    public static JfPuntoDeVenta getInstance() {
        return JfPuntoDeVentaHolder.INSTANCE;
    }

    public javax.swing.JButton getJbAgregar() {
        return jbAgregar;
    }

    public void setJbAgregar(javax.swing.JButton jbAgregar) {
        this.jbAgregar = jbAgregar;
    }

    public javax.swing.JButton getJbEliminar() {
        return jbEliminar;
    }

    public void setJbEliminar(javax.swing.JButton jbEliminar) {
        this.jbEliminar = jbEliminar;
    }

    public javax.swing.JButton getJbLimpiar() {
        return jbLimpiar;
    }

    public void setJbLimpiar(javax.swing.JButton jbLimpiar) {
        this.jbLimpiar = jbLimpiar;
    }

    public javax.swing.JButton getJbRegresar() {
        return jbRegresar;
    }

    public void setJbRegresar(javax.swing.JButton jbRegresar) {
        this.jbRegresar = jbRegresar;
    }

    public javax.swing.JLabel getJlProductos() {
        return jlProductos;
    }

    public void setJlProductos(javax.swing.JLabel jlProductos) {
        this.jlProductos = jlProductos;
    }

    public javax.swing.JLabel getJlTotal() {
        return jlTotal;
    }

    public void setJlTotal(javax.swing.JLabel jlTotal) {
        this.jlTotal = jlTotal;
    }

    public javax.swing.JTable getJtProductos() {
        return jtProductos;
    }

    public void setJtProductos(javax.swing.JTable jtProductos) {
        this.jtProductos = jtProductos;
    }

    public javax.swing.JTable getJtProductosSeleccionados() {
        return jtProductosSeleccionados;
    }

    public void setJtProductosSeleccionados(javax.swing.JTable jtProductosSeleccionados) {
        this.jtProductosSeleccionados = jtProductosSeleccionados;
    }

    public javax.swing.JTextField getTfFiltrar() {
        return tfFiltrarProductos;
    }

    public void setTfFiltrar(javax.swing.JTextField tfFiltrar) {
        this.tfFiltrarProductos = tfFiltrar;
    }

    public javax.swing.JButton getJbConfirmaVenta() {
        return jbConfirmaVenta;
    }

    public void setJbConfirmaVenta(javax.swing.JButton jbConfirmaVenta) {
        this.jbConfirmaVenta = jbConfirmaVenta;
    }

    public javax.swing.JButton getJbSeleccionaCliente() {
        return jbSeleccionaCliente;
    }

    public void setJbSeleccionaCliente(javax.swing.JButton jbSeleccionaCliente) {
        this.jbSeleccionaCliente = jbSeleccionaCliente;
    }

    public javax.swing.JLabel getJlFoto() {
        return jlFoto;
    }

    public void setJlFoto(javax.swing.JLabel jlFoto) {
        this.jlFoto = jlFoto;
    }

    public javax.swing.JTable getJtClientes() {
        return jtClientes;
    }

    public void setJtClientes(javax.swing.JTable jtClientes) {
        this.jtClientes = jtClientes;
    }

    public javax.swing.JTextField getTfFiltrarClientes() {
        return tfFiltrarClientes;
    }

    public void setTfFiltrarClientes(javax.swing.JTextField tfFiltrarClientes) {
        this.tfFiltrarClientes = tfFiltrarClientes;
    }

    public javax.swing.JTextField getTfFiltrarProductos() {
        return tfFiltrarProductos;
    }

    public void setTfFiltrarProductos(javax.swing.JTextField tfFiltrarProductos) {
        this.tfFiltrarProductos = tfFiltrarProductos;
    }

    public javax.swing.JLabel getJlGrupo() {
        return jlGrupo;
    }

    public void setJlGrupo(javax.swing.JLabel jlGrupo) {
        this.jlGrupo = jlGrupo;
    }

    public javax.swing.JLabel getJlId() {
        return jlId;
    }

    public void setJlId(javax.swing.JLabel jlId) {
        this.jlId = jlId;
    }

    public javax.swing.JLabel getJlNombre() {
        return jlNombre;
    }

    public void setJlNombre(javax.swing.JLabel jlNombre) {
        this.jlNombre = jlNombre;
    }

    public javax.swing.JLabel getJlSaldo() {
        return jlSaldo;
    }

    public void setJlSaldo(javax.swing.JLabel jlSaldo) {
        this.jlSaldo = jlSaldo;
    }

    public javax.swing.JLabel getJlVigencia() {
        return jlVigencia;
    }

    public void setJlVigencia(javax.swing.JLabel jlVigencia) {
        this.jlVigencia = jlVigencia;
    }

    private static class JfPuntoDeVentaHolder {

        private static final JfPuntoDeVenta INSTANCE = new JfPuntoDeVenta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jlProductos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlTotal1 = new javax.swing.JLabel();
        jbConfirmaVenta = new javax.swing.JButton();
        tfFiltrarProductos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProductosSeleccionados = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jlFoto = new javax.swing.JLabel();
        tfFiltrarClientes = new javax.swing.JTextField();
        jbSeleccionaCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlSaldo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlGrupo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlVigencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Punto de Venta");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jtProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Detalles", "Categoría", "Marca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductos.setColumnSelectionAllowed(true);
        jtProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtProductos);
        jtProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtProductos.getColumnModel().getColumnCount() > 0) {
            jtProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total:");

        jlTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("0.00");

        jlProductos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlProductos.setForeground(new java.awt.Color(255, 255, 255));
        jlProductos.setText("0");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Productos:");

        jlTotal1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlTotal1.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal1.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTotal1))
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlTotal)
                    .addComponent(jlTotal1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlProductos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbConfirmaVenta.setBackground(new java.awt.Color(102, 102, 102));
        jbConfirmaVenta.setText("Confirmar venta");

        tfFiltrarProductos.setToolTipText("Filtrar...");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Productos");

        jtProductosSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtProductosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
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
        jtProductosSeleccionados.setColumnSelectionAllowed(true);
        jtProductosSeleccionados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtProductosSeleccionados);
        jtProductosSeleccionados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtProductosSeleccionados.getColumnModel().getColumnCount() > 0) {
            jtProductosSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtProductosSeleccionados.getColumnModel().getColumn(1).setPreferredWidth(240);
        }

        jbAgregar.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Forward_Arrow_25px.png"))); // NOI18N

        jbEliminar.setBackground(new java.awt.Color(102, 102, 102));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Delete_25px_1.png"))); // NOI18N

        jbLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_Delete_Table_25px.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Saldo", "Grupo", "Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
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
        jtClientes.setColumnSelectionAllowed(true);
        jtClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtClientes);
        jtClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtClientes.getColumnModel().getColumnCount() > 0) {
            jtClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            jtClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtClientes.getColumnModel().getColumn(3).setPreferredWidth(130);
            jtClientes.getColumnModel().getColumn(4).setPreferredWidth(90);
        }

        jlFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_User_64px_1.png"))); // NOI18N

        jbSeleccionaCliente.setBackground(new java.awt.Color(102, 102, 102));
        jbSeleccionaCliente.setText("Seleccionar cliente");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");

        jlId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlId.setForeground(new java.awt.Color(255, 255, 255));
        jlId.setText("999");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");

        jlNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setText("999");

        jlSaldo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jlSaldo.setText("999");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Saldo:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Grupo:");

        jlGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlGrupo.setForeground(new java.awt.Color(255, 255, 255));
        jlGrupo.setText("999");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Vigencia:");

        jlVigencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlVigencia.setForeground(new java.awt.Color(255, 255, 255));
        jlVigencia.setText("999");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(tfFiltrarClientes)
                    .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSeleccionaCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlId, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFiltrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlSaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlVigencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSeleccionaCliente)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(1244, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFiltrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbConfirmaVenta)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(tfFiltrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbLimpiar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbConfirmaVenta)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Punto de venta");

        jbRegresar.setBackground(new java.awt.Color(51, 51, 51));
        jbRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"))); // NOI18N
        jbRegresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegresar)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
            java.util.logging.Logger.getLogger(JfPuntoDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfPuntoDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfPuntoDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfPuntoDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfPuntoDeVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbConfirmaVenta;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbRegresar;
    private javax.swing.JButton jbSeleccionaCliente;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JLabel jlGrupo;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlProductos;
    private javax.swing.JLabel jlSaldo;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlTotal1;
    private javax.swing.JLabel jlVigencia;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTable jtProductosSeleccionados;
    private javax.swing.JTextField tfFiltrarClientes;
    private javax.swing.JTextField tfFiltrarProductos;
    // End of variables declaration//GEN-END:variables

}
