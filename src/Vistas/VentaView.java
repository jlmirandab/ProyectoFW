
package Vistas;

import AccesoADatos.ClienteData;
import AccesoADatos.DetalleVentaData;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.awt.PopupMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class VentaView extends javax.swing.JInternalFrame {
    
    private VentaData vData=new VentaData();
    private ClienteData clienteData=new ClienteData();
    private ProductoData proData=new ProductoData();
    private Venta venta= new Venta();
     private Producto productoActual=null;
    
  
    
    
    private DefaultTableModel modelo;
    private TableRowSorter trs;
    private List<Cliente> listaC;
    
    
    public VentaView() {
        initComponents();
        List<Cliente> ArrayList;
        List<Cliente> Cliente;
        
        listaC= (List<Cliente>)clienteData.listarClientes();
        modelo= new DefaultTableModel();
        armarCabecera();
        cargarProductos();
        
        cargarComboBox();
        
        
                }
    
                

    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID Producto");
        filaCabecera.add("Nombre Producto");
        filaCabecera.add("Descripción");
        filaCabecera.add("Precio Actual");
        filaCabecera.add("Stock");
        filaCabecera.add("Estado");
        
        
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    
   
     private void cargarProductos(){
         
         List <Producto> lista1=  proData.listarProductos();
        for (Producto p : lista1) {
            if (p.isEstado())
            modelo.addRow(new Object[] {p.getIdProducto(), p.getNombreProducto(), p.getDescripcion(),p.getPrecioActual(),p.getStock(), p.isEstado()});
            
        }   
       
    } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBClientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFiltro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSCantidad = new javax.swing.JSpinner();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRACIÓN DE VENTAS");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLIENTE:");

        jCBClientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCBClientes.setForeground(new java.awt.Color(255, 255, 255));
        jCBClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClientesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SELECCIONE UN PRODUCTO:");

        jDFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDFecha.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELECCIONE UNA FECHA:");

        jTabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabla.setForeground(new java.awt.Color(102, 102, 102));
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

        jBAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jBAgregar.setText("AGREGAR VENTA");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(51, 51, 51));
        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Filtrar:");

        jTFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFiltroKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SELECCIONE CANTIDAD DE PRODUCTO:");

        jSCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(jSCantidad))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(39, 39, 39)
                            .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(293, 293, 293))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBAgregar)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBSalir)
                        .addGap(194, 194, 194))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jBAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jBSalir)
                        .addGap(69, 69, 69))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClientesActionPerformed
        
    }//GEN-LAST:event_jCBClientesActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed
    private void cargarComboBox(){
        
        for (Cliente cliente : listaC) {
            if(cliente.isEstado())
            jCBClientes.addItem(cliente);
            
        }
        
            
        
    }
    private void jTFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltroKeyTyped
       jTFiltro.addKeyListener(new KeyAdapter(){
          
        @Override
        public void keyReleased (KeyEvent ke){
           
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTFiltro.getText(), 0,1,2,3,4,5));
            
            
        }
    });
        trs= new TableRowSorter(jTabla.getModel());
        jTabla.setRowSorter(trs);
    }//GEN-LAST:event_jTFiltroKeyTyped

    
    private void borrarFilaTabla(){
        int indice= modelo.getRowCount() -1;
        
        for (int i= indice; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
   int filaSeleccionada = jTabla.getSelectedRow();

    if (filaSeleccionada != -1) {
        // Paso 1: Obtener el cliente seleccionado del ComboBox
        Cliente clienteSeleccionado = (Cliente) jCBClientes.getSelectedItem();

        // Paso 2: Obtener los detalles del producto seleccionado en la jTabla
        int idProducto = (Integer) modelo.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modelo.getValueAt(filaSeleccionada, 1);
        String descripcion = (String) modelo.getValueAt(filaSeleccionada, 2);
        Double precioActual = (Double) modelo.getValueAt(filaSeleccionada, 3);
        int stock = (Integer) modelo.getValueAt(filaSeleccionada, 4);

        Producto productoSeleccionado = new Producto(idProducto, nombre, descripcion, precioActual, stock);

        // Obtener cantidad del producto seleccionado
        int cantidad = (int) jSCantidad.getValue();

        // Validar que la cantidad sea mayor que 0
        if (cantidad > 0) {
            // Obtener la fecha del JDFecha
            java.util.Date fechaSeleccionada = jDFecha.getDate(); // Asegúrate de que jDFecha sea el nombre correcto de tu componente JDateChooser

            if (clienteSeleccionado != null && fechaSeleccionada != null) {
                // Convertir la fecha a LocalDate
                LocalDate fechaLocal = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                // Crear la venta con los datos obtenidos
                int cantidadAComprar = (int) jSCantidad.getValue();
                Venta ventaRealizada = new Venta(venta.getIdVenta(), clienteSeleccionado, fechaLocal);
                vData.guardarVenta1(ventaRealizada, idProducto, cantidadAComprar);

                // Crear el detalle de la venta
                DetalleVenta detalle = new DetalleVenta(cantidad, ventaRealizada, precioActual, productoSeleccionado);
                DetalleVentaData detalleData = new DetalleVentaData();
                detalleData.guardarDetalleVenta(detalle);

               borrarFilaTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente y una fecha válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
    } 
    cargarProductos();
    
    }//GEN-LAST:event_jBAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Cliente> jCBClientes;
    private com.toedter.calendar.JDateChooser jDFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSCantidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFiltro;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
