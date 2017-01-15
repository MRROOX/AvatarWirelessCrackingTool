package avatarwirelesscrackingtool;

import javax.swing.JOptionPane;
import java.io.*;

public class Autorizacion extends javax.swing.JFrame {

    String url;
    String texto;

    public Autorizacion() {
        initComponents();
        setLocationRelativeTo(null);
        TerminosInicio();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAutorizacion = new javax.swing.JTextArea();
        checkTerminos = new javax.swing.JRadioButton();
        BotonAceptar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autorizacion Avatar Wireless Testing");

        jPanel1.setBackground(new java.awt.Color(1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Gaposis Solid BRK", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 125));
        jLabel1.setText("Avatar Wireless Cracking Tool");

        txtAutorizacion.setEditable(false);
        txtAutorizacion.setBackground(new java.awt.Color(1, 1, 1));
        txtAutorizacion.setColumns(20);
        txtAutorizacion.setForeground(new java.awt.Color(254, 254, 254));
        txtAutorizacion.setRows(5);
        jScrollPane1.setViewportView(txtAutorizacion);

        checkTerminos.setBackground(new java.awt.Color(1, 1, 1));
        checkTerminos.setFont(new java.awt.Font("Mad's Scrawl BRK", 1, 18)); // NOI18N
        checkTerminos.setForeground(new java.awt.Color(0, 178, 255));
        checkTerminos.setText("Acepto los  Terminos y Condiciones");
        checkTerminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTerminosActionPerformed(evt);
            }
        });

        BotonAceptar.setText("Aceptar");
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(checkTerminos)
                        .addGap(386, 386, 386)
                        .addComponent(BotonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkTerminos)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonAceptar)
                            .addComponent(BotonSalir))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkTerminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTerminosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_checkTerminosActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        // TODO add your handling code here:
        if (checkTerminos.isSelected()) {
            OkTerminos();
        } else {
            JOptionPane.showMessageDialog(BotonAceptar, "Para continuar por favor acepte los Terminos y Condiciones de Avatar Wireless Testing");
        }
    }//GEN-LAST:event_BotonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autorizacion().setVisible(true);
            }
        });
    }

    private void OkTerminos() {

        String homeUsuario = System.getProperty("user.home");
        String cmd = homeUsuario + "/.AWCTool";
        File directorio1 = new File(cmd);
        directorio1.mkdirs();
        //Se procede a crear el archivo recidual de primera ejecucion y 
        //configuracion de AWCTool
        File fichero = new File(homeUsuario + "/.AWCTool/AWCrakingTool");
        try {
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
                AuthRoot ARoot = new AuthRoot();
                this.setVisible(false);
                ARoot.setVisible(true); //Gui AuthRoot   

            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Error " + ioe);
        }

    }

    private void TerminosInicio() {
        String homeUsuario = System.getProperty("user.home");
        txtAutorizacion.append(
                "                                                          Términos y condiciones de Avatar Wireless Testing.\n"
                + "1. ACEPTACIÓN \n"
                + "\n"
                + " En el presente documento se establecen los términos y condiciones de Avatar Wireless Testing. Le rogamos leer\n"
                + "atentamente el presente documento. \n"
                + " Al aceptar los términos y condiciones de Avatar Wireless Testing, el usuario se compromete a utilizar esta herramienta\n" + ""
                + "bajo su propia responsabilidad y acceder a implementar las modificaciones descritas en este documento. En caso\n" + ""
                + "de que usted no acepte quedar vinculado por los presentes términos y condiciones, no podrá acceder a utilizar\n"
                + "Avatar Wireless Testing. \n"
                + "\n"
                + "2. REQUISITOS RELATIVOS AL USUARIO Y AL SISTEMA OPERATIVO\n"
                + "\n"
                + " El USUARIO asume y acepta toda la responsabilidad legal por la mala utilización de la herramienta de auditoria de\n"
                + "redes wireless Avatar Wireless Testing.\n"
                + " Avatar Wireless Testing SOLO es compatible con Sistemas Operativos basados en GNU/Linux.\n"
                + " Avatar Wireless Testing necesita estrictamente ejecutarse con privilegio de superadministrador, por lo que se solicitara\n"
                + "la clave de usuario root al momento después de aceptar los términos y condiciones de uso.\n"
                + "\n"
                + " Al momento de ejecutarse, Avatar Wireless Testing necesitara realizar modificaciones importantes dentro de los\n"
                + "componentes del Sistema Operativo, específicamente en el sistema de asignación de nombres de las\n"
                + "Networks Interfaces (Interfaces de Red), en las nuevas actualizaciones de GNU/Linux se modificó este sistema por lo que\n"
                + "es necesario restablecer esta configuración a la versión tradicional de asignación (Para más información\n"
                + "Visitar este Link: www.rooxfloyd.blogspot.com/Sistema deAsignaciondeNetworkInterfaces).\n"
                + "\n"
                + " Avatar Wireless Testing necesita realizar esta modificación para su real funcionamiento, debido a que las herramientas\n"
                + "integradas necesitan acceder a los nombres de asignacion de Interfaces de Red estándar (wlan0,eth0).\n"
                + "\n"
                + " Avatar Wireles Testing instalara las herramientas, Aircrack-n, Reaver y Pixiewps, Bully y MKD3 en caso de que no estén\n"
                + "en el Sistema Operativo. Se implementara el Script Katoolin que realiza la integración de los repositorios de KALI Linux\n"
                + "(Un poderoso Sistema Operativo Para Seguridad Informática) para la posterior instalación de las últimas versiones de\n"
                + "estas herramientas.\n"
                + "\n"
                + "  Avatar Wireless Testing creara un directorio temporal en el cual se guardaran archivos esenciales para su buen\n"
                + "funcionamiento, este se encontrara en: " + homeUsuario + ".\n"
                + "\n"
                + "\n"
                + "3. CONTACTO\n"
                + "\n"
                + "Si desea más información o tiene algun problema sobre Avatar Wireless Testing por favor contactar a:\n"
                + "\n"
                + "\n"
                + "Felipe Hernan Quezada Gajardo (MrRoox)                                       f.quezada01@ufromail.cl\n"
                + "Sebastian Gonzalez Burdiles (Seba)                                                s.gonzalez11@ufromail.cl\n"
                + "\n"
                + "\n"
        );

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton checkTerminos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAutorizacion;
    // End of variables declaration//GEN-END:variables
}
