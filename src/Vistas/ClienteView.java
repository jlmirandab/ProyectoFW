
package Vistas;

import AccesoADatos.ClienteData;
import Entidades.Cliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ClienteView extends javax.swing.JInternalFrame {
    private ClienteData cliData=new ClienteData();
    private Cliente clienteActual=null;
    private DefaultTableModel modelo;
    private  TableRowSorter trs;
    
    public class NonEditableTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
   
    public ClienteView() {
        initComponents();
        
        modelo= new DefaultTableModel();
        modelo = new NonEditableTableModel();
        armarCabecera();
        
        // Asociar el evento de jModificar al método guardarCambios
    jBActualizar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            guardarCambios();
        }

          
    });
    cargarClientes();
        
    }
    
    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Apellido");
        filaCabecera.add("Domicilio");
        filaCabecera.add("Telefono");
        filaCabecera.add("Estado");
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    
    private void limpiarCampos() {
        jTNombre.setText("");
        jTApellido.setText("");
        jTTelefono.setText("");
        jCEstado.setSelected(true);
        jTCiudad.setText("");
         
        
    }                                        

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTCiudad = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jCEstado = new javax.swing.JCheckBox();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jTFiltro = new javax.swing.JTextField();
        jBSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBActualizar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DEL CLIENTE");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ciudad:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono:");

        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });

        jCEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCEstado.setForeground(new java.awt.Color(255, 255, 255));
        jCEstado.setText("Estado");
        jCEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEstadoActionPerformed(evt);
            }
        });

        jBAgregar.setBackground(new java.awt.Color(255, 255, 255));
        jBAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jBAgregar.setText("AGREGAR CLIENTE");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jBEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(51, 51, 51));
        jBEliminar.setText("ELIMINAR CLIENTE");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jTabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabla.setForeground(new java.awt.Color(51, 51, 51));
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        jTFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTFiltro.setForeground(new java.awt.Color(102, 102, 102));
        jTFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFiltroActionPerformed(evt);
            }
        });
        jTFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFiltroKeyTyped(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(255, 255, 255));
        jBSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(51, 51, 51));
        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Filtrar:");

        jBActualizar.setBackground(new java.awt.Color(255, 255, 255));
        jBActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBActualizar.setForeground(new java.awt.Color(51, 51, 51));
        jBActualizar.setText("ACTUALIZAR CLIENTE");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jBLimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(51, 51, 51));
        jBLimpiar.setText("LIMPIAR CAMPOS");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(jBSalir)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jBAgregar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jBLimpiar)
                                    .addGap(46, 46, 46)
                                    .addComponent(jBActualizar)
                                    .addGap(50, 50, 50)
                                    .addComponent(jBEliminar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(46, 46, 46)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTNombre)
                                                .addComponent(jTCiudad)
                                                .addComponent(jTApellido)
                                                .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(92, 92, 92)
                                    .addComponent(jCEstado))))))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCEstado)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBLimpiar)
                    .addComponent(jBActualizar)
                    .addComponent(jBEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalir))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEstadoActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
    try {
        String nombre = jTNombre.getText();
        String apellido = jTApellido.getText();
        String domicilio = jTCiudad.getText();
        String telefono = jTTelefono.getText();

        // Validar campos vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || domicilio.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
            return;
        }

        // Validar que nombre, apellido y domicilio contengan solo letras o espacios
        if (!contieneSoloLetrasYEspacios(nombre) || !contieneSoloLetrasYEspacios(apellido) || !contieneSoloLetrasYEspacios(domicilio) || !contieneSoloNumeros(telefono)) {
            JOptionPane.showMessageDialog(this, "Nombre, apellido y domicilio deben contener solo letras");
            return;
        }
        
        // Obtener el estado del cliente
       

        if (clienteActual == null) {
             boolean estado = jCEstado.isSelected();
            // Establecer estado en false si no está marcada la casilla jCEstado
            if (!jCEstado.isSelected()) {
                estado = false;
            }else{
                estado= jCEstado.isSelected();
            }

            clienteActual = new Cliente(apellido, nombre, telefono, domicilio, estado);
            cliData.guardarCliente(clienteActual);
            
        } else {
            JOptionPane.showMessageDialog(this, "Error el cliente ya ha sido agregado");
        }
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un número válido para el teléfono");
    }
        limpiarCampos();
        cargarClientes();
        clienteActual = null;
     
    }//GEN-LAST:event_jBAgregarActionPerformed
    
    private boolean contieneSoloLetrasYEspacios(String cadena) {
    return cadena.matches("^[a-zA-Z ]+$");
}
   
    private boolean contieneSoloNumeros(String cadena) {
    return cadena.matches("^[0-9]+$");
}
    
    
    private void cargarClientes(){
        modelo.setRowCount(0);
         List <Cliente> lista1=  cliData.listarClientes();
        for (Cliente m : lista1) {
            modelo.addRow(new Object[] {m.getIdCliente(),m.getNombre(),m.getApellido(),m.getDomicilio(), m.getTelefono(), m.isEstado()});
            
        }   
       
    }     
    
  
    private void jTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreActionPerformed
    
    private void borrarFilaTabla(){
        int indice= modelo.getRowCount() -1;
        
        for (int i= indice; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
       int filaSeleccionada= jTabla.getSelectedRow();
        if(filaSeleccionada!=-1){
            
            
            int idCliente= (Integer) modelo.getValueAt(filaSeleccionada, 0);
            cliData.eliminarClienteporId(idCliente);
            borrarFilaTabla();
            
        }else{
             JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista para eliminar");
        }
        cargarClientes();
             
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
         dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltroKeyReleased
       
    }//GEN-LAST:event_jTFiltroKeyReleased

    private void jTFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFiltroActionPerformed
   
    
    private void jTFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltroKeyTyped
      
        
        
        jTFiltro.addKeyListener(new KeyAdapter(){
          
        @Override
        public void keyReleased (KeyEvent ke){
           
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTFiltro.getText(), 0,1,2,3,4,5));
            
            
        }
    });
        cargarClientes();
        trs= new TableRowSorter(jTabla.getModel());
        jTabla.setRowSorter(trs);
    
    }//GEN-LAST:event_jTFiltroKeyTyped

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        if (clienteActual != null) {
        String nombre = jTNombre.getText();
        String apellido = jTApellido.getText();
        String domicilio = jTCiudad.getText();
        String telefono = jTTelefono.getText();
        Boolean estado = jCEstado.isSelected();

        // Actualiza el clienteActual con los valores de los campos de texto
        clienteActual.setNombre(nombre);
        clienteActual.setApellido(apellido);
        clienteActual.setDomicilio(domicilio);
        clienteActual.setTelefono(telefono);
        clienteActual.setEstado(estado);

        cliData.modificarCliente(clienteActual);
        guardarCambios();
        // Actualiza la tabla para reflejar los cambios
        cargarClientes();
        limpiarCampos();
        clienteActual = null;
    } else {
       // JOptionPane.showMessageDialog(this, "Selecciona un cliente primero.");
    
}

    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
         int selectedRow = jTabla.getSelectedRow();
        if (selectedRow != -1) {
            int i = jTabla.getSelectedRow();
            int idCliente = Integer.parseInt(jTabla.getModel().getValueAt(i, 0).toString());
            String nombre = jTabla.getModel().getValueAt(i, 1).toString();
            String apellido = jTabla.getModel().getValueAt(i, 2).toString();
            String domicilio = jTabla.getModel().getValueAt(i, 3).toString();
            String telefono = jTabla.getModel().getValueAt(i, 4).toString();
            Boolean estado = (Boolean) jTabla.getModel().getValueAt(i, 5);

            // Llenar los campos de texto con los datos del cliente
            jTNombre.setText(nombre);
            jTApellido.setText(apellido);
            jTCiudad.setText(domicilio);
            jTTelefono.setText(telefono);
            jCEstado.setSelected(estado);

            // Guarda el cliente seleccionado
            clienteActual = new Cliente(idCliente, apellido, nombre, telefono, domicilio, estado);
        }
    
    }//GEN-LAST:event_jTablaMouseClicked

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCampos();
        clienteActual = null;
    }//GEN-LAST:event_jBLimpiarActionPerformed
    
   private void guardarCambios() {
    if (clienteActual != null) {
        // Actualiza los campos del cliente con los valores de los campos de texto
        clienteActual.setNombre(jTNombre.getText());
        clienteActual.setApellido(jTApellido.getText());
        clienteActual.setDomicilio(jTCiudad.getText());
        clienteActual.setTelefono(jTTelefono.getText());
        clienteActual.setEstado(jCEstado.isSelected());
        // Actualiza el valor del jCEstado para reflejar el nuevo estado del cliente
        jCEstado.setSelected(clienteActual.isEstado());
        // Llama al método para modificar el cliente en la base de datos
        cliData.modificarCliente(clienteActual);
         // Actualiza el valor del jCEstado para reflejar el nuevo estado del cliente
        jCEstado.setSelected(clienteActual.isEstado());


        // Actualiza la tabla para reflejar los cambios
        cargarClientes();

        limpiarCampos();
        clienteActual = null;
    } else {
        
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCiudad;
    private javax.swing.JTextField jTFiltro;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}

