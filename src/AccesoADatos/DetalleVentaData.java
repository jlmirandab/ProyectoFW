
package AccesoADatos;

import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DetalleVentaData {
    private ClienteData cData= new ClienteData();
    private VentaData vData= new VentaData();
    private ProductoData pData= new ProductoData();
    private Connection con=null;
    
    Cliente cliente=new Cliente();
    Producto producto=new Producto();
    Venta venta=new Venta();

    public DetalleVentaData() {
        con = AccesoADatos.Conexion.getConexion();
    }
    
            public void guardarDetalleVenta (DetalleVenta detalle){
       String sql = "INSERT INTO detalleventa  (cantidad, idVenta, precioVenta , idProducto) VALUES (?,?,?,?)";
     
        try {
           PreparedStatement ps1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps1.setInt(1, detalle.getCantidad());
           ps1.setInt(2, detalle.getVenta().getIdVenta());
           ps1.setDouble(3, detalle.getPrecioVenta()*detalle.getCantidad());
           ps1.setInt(4, detalle.getProducto().getIdProducto());
           
           ps1.executeUpdate();
           
           ResultSet rs= ps1.getGeneratedKeys();
                    
           if (rs.next()) {
                detalle.setIdDetalleVent(rs.getInt(1));
                
                JOptionPane.showMessageDialog(null, "DetalleVenta Registrado");
                }
                ps1.close();

                }catch (SQLException ex) {
                
                }

            }
   

    
    public List<DetalleVenta> clientesPorProducto(int idProducto){
        
         List<DetalleVenta> detalles= new ArrayList<>();
        
        String sql= "SELECT * FROM detalleventa WHERE idProducto=? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                DetalleVenta detalle1=new DetalleVenta();
                //detalle.
                detalle1.setIdDetalleVent(rs.getInt("idDetalleVent"));
                detalle1.setCantidad(rs.getInt("cantidad"));
                //   Alumno alu= aludata.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Venta venta=vData.buscarVentas(rs.getInt("idVentas"));
                detalle1.setPrecioVenta(rs.getDouble("PrecioVenta"));
                Producto producto=pData.buscarProductoPorId(rs.getInt("idProducto"));
                detalle1.setVenta(venta);
                detalle1.setProducto(producto);

               
                detalles.add(detalle1);
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla DetalleVenta"+ ex.getMessage());
            
        }
        return detalles;
        
    }
        
    

    //listarProductosPorVentas(int idVenta)
        public List<DetalleVenta> listarProductos(int idVenta){
        List<DetalleVenta> detalles1 = new ArrayList<>();
        
        String sql= "SELECT idDetalleVent,cantidad,idVenta,precioVenta,idProducto FROM detalleVenta";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs= ps.executeQuery();
            
            
            while(rs.next()){
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalleVent(rs.getInt("idDetalleVent"));
                detalle.setCantidad(rs.getInt("cantidad"));
                Venta v=vData.buscarVentas(rs.getInt("idVenta"));
                detalle.setVenta(v);
                detalle.setPrecioVenta(rs.getInt("PrecioVenta"));
                Producto p=pData.buscarProductoPorId(rs.getInt("idProducto")); 
                detalle.setProducto(p);
                detalles1.add(detalle);
            
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla producto"+ ex.getMessage());
            
        }
        return detalles1;
        
    }    
      public List<DetalleVenta> mostrarDetalle (Venta venta){
       
        
       List<DetalleVenta> detalles1 = new ArrayList<>();

    String sql = "SELECT idDetalleVent, cantidad, idVenta, precioVenta, idProducto FROM detalleVenta WHERE idVenta = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, venta.getIdVenta()); // Aquí asumo que el ID de venta se obtiene de la venta pasada como parámetro
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setIdDetalleVent(rs.getInt("idDetalleVent"));
            detalle.setCantidad(rs.getInt("cantidad"));
            Venta v = venta; // Utilizamos la venta pasada como parámetro
            detalle.setVenta(v);
            detalle.setPrecioVenta(rs.getInt("precioVenta"));
            Producto p = pData.buscarProductoPorId(rs.getInt("idProducto"));
            detalle.setProducto(p);
            detalles1.add(detalle);
        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla detalleVenta: " + ex.getMessage());
    }
    return detalles1;
        
    }    
        
    }
    
    
    
    
    
    

