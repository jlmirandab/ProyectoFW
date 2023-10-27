/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.ProductoData;
import Entidades.Cliente;
import Entidades.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Win10
 */
public class ProductoView extends javax.swing.JInternalFrame {
    private ProductoData prodData=new ProductoData();
    private Producto productoActual=null;
    private DefaultTableModel modelo;
    private  TableRowSorter trs;
    
    public class NonEditableTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    }
    
    public ProductoView() {
        initComponents();
        modelo= new DefaultTableModel();
        modelo= new NonEditableTableModel();
        armarCabecera();
        
        jBModificar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            guardarCambios();
        }

          
    });
        
        
        cargarProductos();
        
    }
    
    private void cargarProductos(){
        modelo.setRowCount(0);
         List <Producto> lista2=  prodData.listarProductos();
        for (Producto p : lista2) {
            modelo.addRow(new Object[] {p.getIdProducto(), p.getNombreProducto(), p.getDescripcion(),p.getPrecioActual(),p.getStock(), p.isEstado()});
            
        }  
       
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTDescripcion = new javax.swing.JTextField();
        jTPrecio = new javax.swing.JTextField();
        jTStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jTFiltro = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jCEstado = new javax.swing.JCheckBox();
        jBSalir = new javax.swing.JButton();
        jTNombre = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBModificar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTOS");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STOCK:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRECIO:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DESCRIPCIÓN:");

        jTDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioActionPerformed(evt);
            }
        });

        jTStock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTStockActionPerformed(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFiltroKeyTyped(evt);
            }
        });

        jBAgregar.setBackground(new java.awt.Color(255, 255, 255));
        jBAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jBAgregar.setText("AGREGAR");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jBEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(51, 51, 51));
        jBEliminar.setText("ELIMINAR");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jCEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCEstado.setForeground(new java.awt.Color(255, 255, 255));
        jCEstado.setText("ESTADO");

        jBSalir.setBackground(new java.awt.Color(255, 255, 255));
        jBSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(51, 51, 51));
        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jBLimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(51, 51, 51));
        jBLimpiar.setText("LIMPIAR");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Filtrar:");

        jBModificar.setBackground(new java.awt.Color(255, 255, 255));
        jBModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBModificar.setForeground(new java.awt.Color(51, 51, 51));
        jBModificar.setText("MODIFICAR PRODUCTO");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jBLimpiar)
                .addGap(55, 55, 55)
                .addComponent(jBAgregar)
                .addGap(55, 55, 55)
                .addComponent(jBModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBEliminar)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCEstado)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2))
                                    .addGap(60, 60, 60)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                        .addComponent(jTNombre))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(jTStock))
                                    .addGap(22, 22, 22))))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addGap(50, 50, 50)
                        .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir)
                        .addGap(235, 235, 235))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jCEstado)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpiar)
                    .addComponent(jBEliminar)
                    .addComponent(jBAgregar)
                    .addComponent(jBModificar))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jBSalir))
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrecioActionPerformed

    private void jTStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTStockActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
    try {
        String nombre = jTNombre.getText();
        String descripcion = jTDescripcion.getText();
        double precio = Double.parseDouble(jTPrecio.getText());
        int stock = Integer.parseInt(jTStock.getText());

        // Validar campos vacíos
        if (nombre.isEmpty() || descripcion.isEmpty() || jTPrecio.getText().isEmpty() || jTStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
            return;
        }

       
        if (productoActual == null) {
             boolean estado = jCEstado.isSelected();
            // Establecer estado en false si no está marcada la casilla jCEstado
            if (!jCEstado.isSelected()) {
                estado = false;
            }else{
                estado= jCEstado.isSelected();
            }

            productoActual = new Producto(nombre, descripcion, precio, stock, estado);
            prodData.guardarProducto(productoActual);
            
        } else {
            JOptionPane.showMessageDialog(this, "Error el cliente ya ha sido agregado");
        }
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Revisa los campos");
    }
        limpiarCampos();
        cargarProductos();
        productoActual = null;
     
       
              
    }//GEN-LAST:event_jBAgregarActionPerformed
private boolean contieneSoloLetrasYEspacios(String cadena) {
    return cadena.matches("^[a-zA-Z ]+$");
}
   
    private boolean contieneSoloNumeros(String cadena) {
    return cadena.matches("^[0-9]+$");
}
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
        try{
    
            Integer id=Integer.parseInt(JOptionPane.showInputDialog(""));
            productoActual=prodData.buscarProductoPorId(id);
                    if (id!=null) {
            
                        JOptionPane.showMessageDialog(null, "Ingrese un id Valido");
            if(productoActual!=null){
                jTNombre.setText(productoActual.getNombreProducto());
                jTDescripcion.setText(productoActual.getDescripcion());

                jTPrecio.setText(String.valueOf(productoActual.getPrecioActual()));
                jTStock.setText(String.valueOf(productoActual.getStock()));
                jCEstado.setSelected(productoActual.isEstado());
//                jREstado.setSelected(alumnoActual.isEstado());
                
                
                
            }
                    }else{
                        
                    }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido");
        }

       
    }//GEN-LAST:event_jbBuscarActionPerformed
    
    private void armarCabecera(){
        ArrayList<Object> filaCabecera= new ArrayList();
        filaCabecera.add("ID");
        filaCabecera.add("Nombre");
        filaCabecera.add("Descripción");
        filaCabecera.add("Precio Actual");
        filaCabecera.add("Stock");
        filaCabecera.add("Estado");
        
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
       
    }
    
    
    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCampos();
        productoActual=null;
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFiltroKeyTyped
        jTFiltro.addKeyListener(new KeyAdapter(){
          
        @Override
        public void keyReleased (KeyEvent ke){
           
            trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTFiltro.getText(), 0,1,2,3,4,5));
            
            
        }
    });
        cargarProductos();
        trs= new TableRowSorter(jTabla.getModel());
        jTabla.setRowSorter(trs);
        
    }//GEN-LAST:event_jTFiltroKeyTyped

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
       int selectedRow = jTabla.getSelectedRow();
            if (selectedRow != -1){
        
        if (productoActual != null) {
            
        String nombre = jTNombre.getText();
        String Descripcion = jTDescripcion.getText();
        double precio = Double.parseDouble(jTPrecio.getText());
        int stock = Integer.parseInt(jTStock.getText());
        Boolean estado= jCEstado.isSelected();

        // Actualiza el clienteActual con los valores de los campos de texto
        productoActual.setNombreProducto(nombre);
        productoActual.setDescripcion(Descripcion);
        productoActual.setPrecioActual(precio);
        productoActual.setStock(stock);
        productoActual.setEstado(estado);

        prodData.modificarProducto(productoActual);
        guardarCambios();
        // Actualiza la tabla para reflejar los cambios
        cargarProductos();
        limpiarCampos();
        productoActual = null;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un producto primero.");
            } 
    
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
    int filaSeleccionada = jTabla.getSelectedRow();
    if (filaSeleccionada != -1) {
        // Obtener el ID o cualquier otro dato necesario para identificar la fila
        int idProducto = (int) jTabla.getModel().getValueAt(filaSeleccionada, 0);

        // Actualizar el estado en la base de datos a 0 o false
        prodData.eliminarProductoPorId(idProducto);
         modelo.removeRow(filaSeleccionada);
        if (productoActual.isEstado()) {
            // Eliminar la fila del modelo de la tabla
          
            modelo.removeRow(filaSeleccionada);

            JOptionPane.showMessageDialog(this, "Producto eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.");
    }
    cargarProductos();
    }
    
    private void guardarCambios() {
    if (productoActual != null) {
        // Actualiza los campos del producto con los valores de los campos de texto
        productoActual.setNombreProducto(jTNombre.getText());
        productoActual.setDescripcion(jTDescripcion.getText());

        // Convierte y establece el precio
        try {
            double precio = Double.parseDouble(jTPrecio.getText());
            productoActual.setPrecioActual(precio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio válido.");
            return;
        }

        // Convierte y establece el stock
        try {
            int stock = Integer.parseInt(jTStock.getText());
            productoActual.setStock(stock);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un stock válido.");
            return;
        }

        productoActual.setEstado(jCEstado.isSelected());
        // Actualiza el valor del jCEstado para reflejar el nuevo estado del producto
        jCEstado.setSelected(productoActual.isEstado());

        // Llama al método para modificar el producto en la base de datos
        prodData.modificarProducto(productoActual);
        // Actualiza el valor del jCEstado para reflejar el nuevo estado del producto

        // Actualiza la tabla para reflejar los cambios
        cargarProductos();

        limpiarCampos();
        productoActual = null;
    } else {
        
    }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jTFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFiltroActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
        int selectedRow = jTabla.getSelectedRow();
        if (selectedRow != -1) {
            int i = jTabla.getSelectedRow();
            int idProducto = Integer.parseInt(jTabla.getModel().getValueAt(i, 0).toString());
            String nombre = jTabla.getModel().getValueAt(i, 1).toString();
            String descripcion = jTabla.getModel().getValueAt(i, 2).toString();
            double precio = Double.parseDouble(jTabla.getModel().getValueAt(i, 3).toString());
            int stock = Integer.parseInt(jTabla.getModel().getValueAt(i, 4).toString());
            boolean estado = (boolean) jTabla.getModel().getValueAt(i, 5);

        // Llenar los campos de texto con los datos del producto
        jTNombre.setText(nombre);
        jTDescripcion.setText(descripcion);
        jTPrecio.setText(Double.toString(precio));
        jTStock.setText(Integer.toString(stock));
        jCEstado.setSelected(estado);

        productoActual = new Producto(idProducto, nombre, descripcion, precio, stock, estado);
        }
    }//GEN-LAST:event_jTablaMouseClicked
    private void limpiarCampos() {
        jTNombre.setText("");
        jTDescripcion.setText("");
        jTPrecio.setText("");
        jCEstado.setSelected(false);
        jTStock.setText("");
        jTFiltro.setText("");
    
         
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDescripcion;
    private javax.swing.JTextField jTFiltro;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JTextField jTStock;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
