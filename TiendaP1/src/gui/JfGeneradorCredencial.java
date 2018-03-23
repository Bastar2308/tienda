/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import auxiliares.QrTools;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import controladores.GeneradorCrendencialControlador;
import guiif.JfGeneradorCredencialIf;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pojo.Cliente;
import test.credencial.CredencialGUI;

/**
 *
 * @author Fernando
 */
public class JfGeneradorCredencial extends javax.swing.JFrame implements JfGeneradorCredencialIf, Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener{
    
    Webcam webcam = Webcam.getDefault();
    WebcamPanel wCpanel = new WebcamPanel(webcam, new Dimension(130, 130), false);
    private WebcamPicker picker = null;
    private GeneradorCrendencialControlador controlador;
    private Cliente cl;
    /**
     * Creates new form JfGeneradorCredencial
     */
    public JfGeneradorCredencial() {
        initComponents();
        setSize(700, 400);
        add(jpContenedorBotones, BorderLayout.WEST);
        add(jpCredencial, BorderLayout.CENTER);
        controlador = new GeneradorCrendencialControlador(this);
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
        run();
    }
    public JfGeneradorCredencial(String nombre, String gradoGrupo, String vigencia, String matricula, Cliente cliente) {
        initComponents();
        setSize(700, 400);
        add(jpContenedorBotones, BorderLayout.WEST);
        add(jpCredencial, BorderLayout.CENTER);
        ImageIcon imagen3 = new ImageIcon(QrTools.getInstance().generarQR("2724899", null, null));
        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(jlQr.getWidth(), jlQr.getHeight(), Image.SCALE_DEFAULT));
        jlQr.setIcon(icono);
        controlador = new GeneradorCrendencialControlador(this);
        cl = cliente;
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
        run();
    }
    
    public static JfGeneradorCredencial getInstance() {
        return JfGeneradorCredencialHolder.INSTANCE;
    }

    @Override
    public JButton getJbTomar() {
        return jbTomar;
    }

    @Override
    public void setJbTomar(JButton bt) {
        this.jbTomar = bt;
    }

    @Override
    public JButton getJbRepetir() {
        return jbRepetir;
    }

    @Override
    public void setJbRepetir(JButton bt) {
        this.jbRepetir = bt;
    }

    @Override
    public JButton getJbGuardar() {
        return jbGuardar;
    }

    @Override
    public void setJbguardar(JButton bt) {
        this.jbGuardar = bt;
    }

    @Override
    public JTextField getJtNombre() {
        return jtNombre;
    }

    @Override
    public void setJtNombre(JTextField tf) {
        this.jtNombre = tf;
    }

    @Override
    public JTextField getJtNivel() {
        return jtNivel;
    }

    @Override
    public void setJtNivel(JTextField tf) {
        this.jtNivel = tf;
    }

    @Override
    public JTextField getJtGradoGrupo() {
        return jtGradoGrupo;
    }

    @Override
    public void setJtGradoGrupo(JTextField tf) {
        this.jtGradoGrupo = tf;
    }

    @Override
    public JTextField getJtVigenciaDD() {
        return jtVigenciaDD;
    }

    @Override
    public void setJtVigenciaDD(JTextField tf) {
        this.jtVigenciaDD = tf;
    }

    @Override
    public JTextField getJtVigenciaMM() {
        return jtVigenciaMM;
    }

    @Override
    public void setJtVigenciaMM(JTextField tf) {
        this.jtVigenciaMM = tf;
    }

    @Override
    public JTextField getJtVigenciaAA() {
        return jtVigenciaAA;
    }

    @Override
    public void setJtVigenciaAA(JTextField tf) {
        this.jtVigenciaAA = tf;
    }

    @Override
    public JTextField getJtMatricula() {
        return jtMatricula;
    }

    @Override
    public void setJtMatricula(JTextField tf) {
        this.jtMatricula = tf;
    }

    @Override
    public JLabel getJlQr() {
        return jlQr;
    }

    @Override
    public void setJlQr(JLabel lb) {
        this.jlQr = lb;
    }

    @Override
    public JPanel getJpCamara() {
        return jpCamara;
    }

    @Override
    public void setJpCamara(JPanel pn) {
        this.jpCamara = pn;
    }

    @Override
    public void run() {
        Webcam.addDiscoveryListener(this);

		//setTitle("Java Webcam Capture POC");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//                setLayout(new BorderLayout());
                

		addWindowListener(this);

		picker = new WebcamPicker();
		picker.addItemListener(this);

		webcam = picker.getSelectedWebcam();
//
//		if (webcam == null) {
//			System.out.println("No webcams found...");
//			System.exit(1);
//		}

//		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.addWebcamListener(JfGeneradorCredencial.this);

		wCpanel = new WebcamPanel(webcam, new Dimension(130, 130),false);
		wCpanel.setFPSDisplayed(false);
                wCpanel.setFillArea(true);

		this.add(picker, BorderLayout.NORTH);
                //add(jPanel1, BorderLayout.CENTER);
		jpCamara.removeAll();
		jpCamara.setLayout(new BorderLayout());
                jpCamara.add(wCpanel, BorderLayout.CENTER);

		pack();
		setVisible(true);

		Thread t = new Thread() {

			@Override
			public void run() {
				//wCpanel.start();
			}
		};
		t.setName("example-starter");
		t.setDaemon(true);
		t.setUncaughtExceptionHandler(this);
		t.start();
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
        
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
        
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
        
    }

    @Override
    public void webcamImageObtained(WebcamEvent we) {
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
        
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

    @Override
    public void uncaughtException(Thread thread, Throwable thrwbl) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItem() != webcam) {
			if (webcam != null) {

				wCpanel.stop();

				remove(wCpanel);

				webcam.removeWebcamListener(this);
				webcam.close();

				webcam = (Webcam) ie.getItem();
//				webcam.setViewSize(WebcamResolution.VGA.getSize());
				webcam.addWebcamListener(this);

				System.out.println("selected " + webcam.getName());

				wCpanel = new WebcamPanel(webcam, new Dimension(130, 130) ,true);
				wCpanel.setFPSDisplayed(false);

				jpCamara.removeAll();
				jpCamara.add(wCpanel, BorderLayout.CENTER);
                                wCpanel.setFillArea(true);
				pack();

				Thread t = new Thread() {

					@Override
					public void run() {
						wCpanel.start();
					}
				};
				t.setName("example-stoper");
				t.setDaemon(true);
				t.setUncaughtExceptionHandler(this);
				t.start();
                        }
        }
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent wde) {
        
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent wde) {
        
    }

    @Override
    public WebcamPanel getWcPanel() {
        return wCpanel;
    }

    @Override
    public void setWcPanel(WebcamPanel wp) {
        this.wCpanel = wp;
    }

    @Override
    public JPanel getJpCredencial() {
        return jpCredencial;
    }

    @Override
    public void setJpCredencial(JPanel pn) {
        this.jpCredencial = pn;
    }

    @Override
    public Cliente getCliente() {
        return cl;
    }

    @Override
    public void setCliente(Cliente cl) {
        this.cl = cl;
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
        jpCredencial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtNombre = new javax.swing.JTextField();
        jtNivel = new javax.swing.JTextField();
        jtGradoGrupo = new javax.swing.JTextField();
        jtVigencia = new javax.swing.JTextField();
        jtMatricula = new javax.swing.JTextField();
        jtVigenciaDD = new javax.swing.JTextField();
        jtVigenciaMM = new javax.swing.JTextField();
        jtVigenciaAA = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jpCamara = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlQr = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpContenedorBotones.setLayout(new java.awt.GridLayout(3, 1));

        jbTomar.setText("Tomar");
        jpContenedorBotones.add(jbTomar);

        jbRepetir.setText("Repetir");
        jpContenedorBotones.add(jbRepetir);

        jbGuardar.setText("Guardar");
        jpContenedorBotones.add(jbGuardar);

        getContentPane().add(jpContenedorBotones, java.awt.BorderLayout.CENTER);

        jpCredencial.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNombre.setText("Nombre");
        jtNombre.setBorder(null);

        jtNivel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNivel.setText("Nivel");
        jtNivel.setBorder(null);

        jtGradoGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtGradoGrupo.setText("Grado y grupo");
        jtGradoGrupo.setBorder(null);

        jtVigencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtVigencia.setText("Vigencia:");
        jtVigencia.setBorder(null);

        jtMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtMatricula.setText("Matrícula");
        jtMatricula.setBorder(null);

        jtVigenciaDD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtVigenciaDD.setText("DD");
        jtVigenciaDD.setBorder(null);

        jtVigenciaMM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtVigenciaMM.setText("MM");
        jtVigenciaMM.setBorder(null);

        jtVigenciaAA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtVigenciaAA.setText("AAAA");
        jtVigenciaAA.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtNombre)
            .addComponent(jtNivel)
            .addComponent(jtGradoGrupo)
            .addComponent(jtMatricula)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtVigenciaDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtVigenciaMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtVigenciaAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtGradoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtVigenciaDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtVigenciaMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtVigenciaAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("www.softwarebastar.com");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("contacto@softwarebastar.com");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("2299 005004");

        jLabel11.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpCamaraLayout = new javax.swing.GroupLayout(jpCamara);
        jpCamara.setLayout(jpCamaraLayout);
        jpCamaraLayout.setHorizontalGroup(
            jpCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jpCamaraLayout.setVerticalGroup(
            jpCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("BÁLTICO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("SISTEMA");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("TARJETA RECARGABLE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("CAFETERÍA");

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
            .addGroup(jpCredencialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                        .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                                .addComponent(jlQr, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGap(10, 10, 10))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpCredencialLayout.setVerticalGroup(
            jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCredencialLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jpCredencialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCredencialLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jpCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCredencialLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpCredencialLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jlQr, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfGeneradorCredencial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbRepetir;
    private javax.swing.JButton jbTomar;
    private javax.swing.JLabel jlQr;
    private javax.swing.JPanel jpCamara;
    private javax.swing.JPanel jpContenedorBotones;
    private javax.swing.JPanel jpCredencial;
    private javax.swing.JTextField jtGradoGrupo;
    private javax.swing.JTextField jtMatricula;
    private javax.swing.JTextField jtNivel;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtVigencia;
    private javax.swing.JTextField jtVigenciaAA;
    private javax.swing.JTextField jtVigenciaDD;
    private javax.swing.JTextField jtVigenciaMM;
    // End of variables declaration//GEN-END:variables
}
