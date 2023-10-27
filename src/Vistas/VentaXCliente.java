
package Vistas;

import AccesoADatos.ClienteData;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.Producto;
import Entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class VentaXCliente extends javax.swing.JInternalFrame {
    
    private VentaData vData=new VentaData();
    private ClienteData clienteData=new ClienteData();
    private ProductoData proData=new ProductoData();
    private List<Cliente> listaC;
    
    
    private DefaultTableModel modelo;
    
   
    
    public VentaXCliente() {
        initComponents();
        modelo= new DefaultTableModel();
        listaC= (List<Cliente>)clienteData.listarClientes();
        armarCabecera();
        cargarComboBox();
        
        
    }

    @SuppressWarnings("unchecked")
    
    
     private void cargarComboBox(){
        for (Cliente cliente : listaC) {
            jCBClientes.addItem(cliente);
            
        }
        
            
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBClientes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTAR VENTAS POR CLIENTE:");

        jCBClientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCBClientes.setForeground(new java.awt.Color(255, 255, 255));
        jCBClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClientesActionPerformed(evt);
            }
        });

        jTabla.setBackground(new java.awt.Color(102, 102, 102));
        jTabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jBSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBSalir)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID Venta");
        filaCabecera.add("Fecha de Venta");
//        filaCabecera.add("Producto");
//        filaCabecera.add("Cantidad");
//        filaCabecera.add("Precio de Venta");
        
        
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    private void jCBClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClientesActionPerformed
       Cliente clienteSeleccionado =  (Cliente) jCBClientes.getSelectedItem();
        List <Venta> lista1=  vData.buscarVentasPorCliente(clienteSeleccionado.getIdCliente());
        
        modelo.setRowCount(0);
        for (Venta v : lista1) {
            modelo.addRow(new Object[] {v.getIdVenta(),v.getFechaVenta()});
           
            
        }  
        
        

    
    }//GEN-LAST:event_jCBClientesActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed
  
    
    
    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                          
         
        
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Cliente> jCBClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
