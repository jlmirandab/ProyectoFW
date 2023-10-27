
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


public class VentaXProducto extends javax.swing.JInternalFrame {

    private VentaData vData=new VentaData();
    private ClienteData clienteData=new ClienteData();
    private ProductoData proData=new ProductoData();
     private List<Producto> listaP;
     
    
    
    private DefaultTableModel modelo;
    
    
    public VentaXProducto() {
        initComponents();
        modelo= new DefaultTableModel();
        listaP= (List<Producto>)proData.listarProductos();
        armarCabecera();
        cargarComboBox();
     
        
       
    }

    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID Venta");
        filaCabecera.add("Cliente");
       
        filaCabecera.add("Fecha de Venta");
        
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    @SuppressWarnings("unchecked")
    
    private void cargarComboBox(){
        for (Producto producto : listaP) {
            jCBProductos.addItem(producto);
            
        }
      
    }
    
    private void borrarFilaTabla(){
        int indice= modelo.getRowCount() -1;
        
        for (int i= indice; i>=0; i--){
            modelo.removeRow(i);
        }
    }
//    private void cargarVentas(){
//        modelo.setRowCount(0);
//        selecciono un producto y lo guardo en la variable productoSeleccionado
//        Producto productoSeleccionado =  (Producto) jCBProductos.getSelectedItem();
//        creo una lista de ventas que tengan el productoSeleccionado 
//        List <Venta> lista1=  vData.buscarVentasPorProducto(productoSeleccionado.getIdProducto());
//        los muestro en la tabla
//        for (Venta v : lista1) {
//            modelo.addRow(new Object[] {v.getIdVenta(),v.getCliente(),v.getFechaVenta()});
//            
//        }   
//       
//    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTAR VENTAS POR PRODUCTO:");

        jCBProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCBProductos.setForeground(new java.awt.Color(255, 255, 255));
        jCBProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProductosActionPerformed(evt);
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
        jTabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTablaFocusGained(evt);
            }
        });
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(jCBProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jBSalir)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTablaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaFocusGained

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
       dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProductosActionPerformed
       Producto productoSeleccionado =  (Producto) jCBProductos.getSelectedItem();
//        if (productoSeleccionado != null) {
//        int idProductoSelec = productoSeleccionado.getIdProducto();
        List<Venta> lista1 = vData.buscarVentasPorProducto(productoSeleccionado.getIdProducto());
        modelo.setRowCount(0);
        for (Venta v : lista1) {
            modelo.addRow(new Object[] {v.getIdVenta(), v.getCliente(), v.getFechaVenta()});
        }
     
        // Manejo de error: No se ha seleccionado ningún producto
    
    }//GEN-LAST:event_jCBProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Producto> jCBProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
