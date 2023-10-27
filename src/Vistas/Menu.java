
package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Menu extends javax.swing.JFrame {
    private boolean usuarioAutenticado = false;
    private JTextField campoUsuario; // Declarar campoUsuario como variable de instancia
    private JPasswordField campoContrasena; // Declarar campoContrasena como variable de instancia
   

    public Menu() {
        
        
        if (!mostrarDialogoInicioSesion()) {
        // Si el diálogo de inicio de sesión devuelve false (el usuario no se autenticó),
        // entonces no se abrirá el menú.
    } else if (usuarioAutenticado == true) {
        initComponents();
        abrirMenu();
    }
        
    
    }

    private boolean mostrarDialogoInicioSesion() {
        JDialog dialogoInicioSesion = new JDialog(this, "Inicio de Sesión", true);
        dialogoInicioSesion.setLayout(new GridLayout(3, 2)); // Diseño de cuadrícula para organizar componentes.
        
        dialogoInicioSesion.setSize(400,200);
        Font fuenteEtiquetas = new Font("Arial", Font.BOLD, 14); // Cambia la tipografía de las etiquetas
        Color colorFondo = new Color(240, 240, 240); // Cambia el color de fondo del diálogo

        
    // Etiqueta y campo de texto para el usuario.
        JLabel etiquetaUsuario = new JLabel("USUARIO: ");
        campoUsuario = new JTextField(20);
        etiquetaUsuario.setFont(fuenteEtiquetas);
    // Etiqueta y campo de contraseña.
        JLabel etiquetaContrasena = new JLabel("CONTRASEÑA: ");
        campoContrasena = new JPasswordField(20);
        etiquetaContrasena.setFont(fuenteEtiquetas);
        campoUsuario.setFont(fuenteEtiquetas);
        campoContrasena.setFont(fuenteEtiquetas);
        dialogoInicioSesion.getContentPane().setBackground(colorFondo); // Cambia el color de fondo del diálogo
        campoUsuario.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia la tipografía del campo de usuario
        campoContrasena.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia la tipografía del campo de contraseña
        
        JButton botonIniciarSesion = new JButton("INICIAR SESIÓN");
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valida las credenciales ingresadas (por ejemplo, en una base de datos).
                String usuario = obtenerUsuarioDelCampo();
                String contraseña = obtenerContraseñaDelCampo();
                if (validarCredenciales(usuario, contraseña)) {
                    usuarioAutenticado = true;
                    JOptionPane.showMessageDialog(null, "Ingreso Exitóso");
                    dialogoInicioSesion.dispose(); // Cierra el diálogo.
                    abrirMenu();
                } else {
                    // Muestra un mensaje de error o indica credenciales incorrectas.
                    mostrarMensajeError("Credenciales incorrectas. Inténtelo de nuevo.");
                    usuarioAutenticado= false;
                }
            }
        });

        dialogoInicioSesion.add(etiquetaUsuario);
        dialogoInicioSesion.add(campoUsuario);
        dialogoInicioSesion.add(etiquetaContrasena);
        dialogoInicioSesion.add(campoContrasena);
        dialogoInicioSesion.add(botonIniciarSesion);
        
        dialogoInicioSesion.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogoInicioSesion.addWindowListener(new WindowAdapter() {
        
            @Override
        
            public void windowClosing(WindowEvent e) {
            // Cuando se cierra el diálogo, establece usuarioAutenticado en false
            usuarioAutenticado = false;
            // Cierra el diálogo
            dialogoInicioSesion.dispose();
        }
    });

    dialogoInicioSesion.pack();
    dialogoInicioSesion.setLocationRelativeTo(null); // Centra el diálogo en la pantalla.
    dialogoInicioSesion.setVisible(true);
    return usuarioAutenticado;
    }
    
    private void abrirMenu() {
        if (usuarioAutenticado) {
            // Aquí abre el menú, ya que el usuario está autenticado
            // Puedes hacerlo de la siguiente manera o llamando a tu lógica de menú.
            this.setVisible(true);
        }
    }
    

  private String obtenerUsuarioDelCampo() {
    // Obtiene el usuario ingresado in the campoUsuario field.
    return campoUsuario.getText();
}

private String obtenerContraseñaDelCampo() {
    // Obtiene la contraseña ingresada in the campoContrasena field.
    return new String(campoContrasena.getPassword());
}

    private boolean validarCredenciales(String usuario, String contraseña) {
       
        return usuario.equals("admin") && contraseña.equals("admin");
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        ImageIcon icono= new ImageIcon(getClass().getResource("/recursos/frave.png"));
        Image miImagen= icono.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent (Graphics g){

                g.drawImage (miImagen, 0, 0, getWidth (), getHeight(), this );
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cliente.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/productos.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(102, 102, 102));
        jMenu3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/venta.png"))); // NOI18N

        jMenuItem2.setText("Administrar Ventas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu6.setText("Listar Ventas");

        jMenuItem3.setText("Por Fecha");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem1.setText("Por Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem4.setText("Por Venta");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setText("Por Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenu3.add(jMenu6);

        jMenuBar1.add(jMenu3);

        jMenu7.setBackground(new java.awt.Color(102, 102, 102));
        jMenu7.setForeground(new java.awt.Color(255, 255, 255));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/detalle.png"))); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setBackground(new java.awt.Color(102, 102, 102));
        jMenu8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu8.setForeground(new java.awt.Color(255, 255, 255));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salir.png"))); // NOI18N
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       VentaXFecha fecha=new VentaXFecha();
       fecha.setVisible(true);
       fecha.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(fecha);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       VentaXProducto producto=new VentaXProducto();
       producto.setVisible(true);
       producto.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(producto);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       VentaView venta=new VentaView();
       venta.setVisible(true);
       venta.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(venta);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       ClienteView cliente=new ClienteView();
       cliente.setVisible(true);
       cliente.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(cliente);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       ProductoView producto=new ProductoView();
       producto.setVisible(true);
       producto.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(producto);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       VentaXCliente ventaxcliente=new VentaXCliente();
       ventaxcliente.setVisible(true);
       ventaxcliente.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(ventaxcliente);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       VentaXVenta venta=new VentaXVenta();
       venta.setVisible(true);
       venta.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(venta);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       DetalleVentaView venta=new DetalleVentaView();
       venta.setVisible(true);
       venta.getContentPane().setBackground(Color.DARK_GRAY);
       jDesktopPane1.add(venta);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
