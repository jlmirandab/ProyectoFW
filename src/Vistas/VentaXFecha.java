
package Vistas;

import AccesoADatos.ClienteData;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Producto;
import Entidades.Venta;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentaXFecha extends javax.swing.JInternalFrame {
    
    private VentaData vData=new VentaData();
    private ClienteData clienteData=new ClienteData();
    private ProductoData proData=new ProductoData();
    JDateChooser jDFecha = new JDateChooser();
    
    
    
    
    private DefaultTableModel modelo;
   
    public VentaXFecha() {
        initComponents();
        modelo= new DefaultTableModel();
        armarCabecera();
        
        jDCalendar.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // La fecha se ha seleccionado o cambiado
                    java.util.Date selectedDate = (java.util.Date) evt.getNewValue();
                    java.sql.Date selectedSqlDate = new java.sql.Date(selectedDate.getTime());
                    List<Venta> lista1 = vData.buscarVentasPorFecha(selectedSqlDate);
                   
                    modelo.setRowCount(0);
                    
                    for (Venta v : lista1) {
                        modelo.addRow(new Object[] {v.getIdVenta(), v.getFechaVenta(), v.getCliente()});
                    }
                }
            }
        });
     
    }

    
    @SuppressWarnings("unchecked")
    
    
    
    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID Venta");
        filaCabecera.add("Fecha de Venta");
        filaCabecera.add("Cliente");
       
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jDCalendar = new com.toedter.calendar.JDateChooser();

        jTabla.setBackground(new java.awt.Color(102, 102, 102));
        jTabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabla.setForeground(new java.awt.Color(255, 255, 255));
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
        jScrollPane1.setViewportView(jTabla);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTAR VENTAS POR FECHA");

        jBSalir.setBackground(new java.awt.Color(255, 255, 255));
        jBSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(51, 51, 51));
        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78)
                        .addComponent(jDCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jBSalir)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed
    
       
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCalendar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
