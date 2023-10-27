
package Vistas;

import AccesoADatos.ClienteData;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class VentaXVenta extends javax.swing.JInternalFrame {
    private VentaData vData=new VentaData();
    private ClienteData clienteData=new ClienteData();
    private ProductoData proData=new ProductoData();
    
    private DefaultTableModel modelo;
    
    public class NonEditableTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
   
    public VentaXVenta() {
        initComponents();
        modelo= new DefaultTableModel();
        modelo = new NonEditableTableModel();
        armarCabecera();
        
        
        
        
    }
        private void borrarFilaTabla(){
        int indice=modelo.getRowCount()-1;
        for(int i=indice;i>=0;i--){
            modelo.removeRow(i);
        }
    }
    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID Venta");
        filaCabecera.add("ID Cliente");
        filaCabecera.add("Fecha de Venta");
        
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBListarVentas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jBListarVentas.setBackground(new java.awt.Color(255, 255, 255));
        jBListarVentas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBListarVentas.setForeground(new java.awt.Color(51, 51, 51));
        jBListarVentas.setText("LISTAR VENTAS");
        jBListarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarVentasActionPerformed(evt);
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
        jScrollPane1.setViewportView(jTabla);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jBListarVentas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jButton1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jBListarVentas)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void cargarVentas(){
         List <Venta> lista1=  vData.listarVentas();
        for (Venta v: lista1) {
            modelo.addRow(new Object[] {v.getIdVenta(),v.getCliente(),v.getFechaVenta()});
            
        }   
       
    }  
    private void jBListarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarVentasActionPerformed
        borrarFilaTabla();
        cargarVentas();
    }//GEN-LAST:event_jBListarVentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBListarVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
