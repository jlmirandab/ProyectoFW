package AccesoADatos;

import Entidades.Producto;
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

/**
 *
 * @author 2022
 */
public class ProductoData {
    //productoData lo hacemos con alumnoData
     private Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto){
        if (producto.isEstado()== true) {
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto Agregado Exitosamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la acción");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se puede agregar un producto con estado 0.");
    }

    }
    
     public Producto buscarProductoPorId(int idProducto){
        Producto producto = null;
        String sql= "SELECT nombreProducto, descripcion, precioActual, stock FROM producto WHERE idProducto= ? AND estado=1";
        PreparedStatement ps= null;
        
        try {
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             producto = new Producto();
             producto.setIdProducto(idProducto);             
             producto.setNombreProducto(rs.getString("nombreProducto"));
             producto.setDescripcion(rs.getString("descripcion"));
             producto.setPrecioActual(rs.getDouble("precioActual"));
             producto.setStock(rs.getInt("stock"));
             producto.setEstado(true);
             
            
            }else{
               JOptionPane.showMessageDialog(null, "No se encontró el producto");
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla producto"+ ex.getMessage());
         
        }return producto;
     
    }
     
     public List<Producto> listarProductos(){
        List<Producto> productos = new ArrayList<>();
        
        String sql= "SELECT * FROM producto WHERE estado IN (0,1)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                prod.setEstado(rs.getBoolean("estado"));
                
                productos.add(prod);
                /*Acá está guardando en el ArrayList productos, el producto prod en el que fuimos agregandole los datos que 
                sacabamos del resultset rs*/
               
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla producto"+ ex.getMessage());
            
        }
        return productos;
        /*Este método lo que devuelve es un ArrayList, al que lo definimos en el nombre del método parece y 
        lo terminamos creando en la linea de abajo del nombre*/
        
    }
     
     //list
     
     public void modificarProducto(Producto producto){
        
        String sql= "UPDATE producto SET nombreProducto= ?, descripcion = ?, precioActual =?, stock = ?, estado = ? WHERE idProducto = ? ";
        //NO le pongo para actualizar el ESTADO porque de eso se va a encargar el método de ELIMINAR (eliminado lógico)
        PreparedStatement ps= null;
        /*En el UPDATE le estoy dando datos a mi bd(ps.setString, ps.setInt - le estoy dando a mi ps los datos),
        pero los tengo que sacar del objeto producto que le doy al método(producto.getNombreProducto),
        que en la vista de modificar producto es en donde le voy a pasar los datos.*/
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());
            
            int exito= ps.executeUpdate();
            /*Se pone el uno en la línea siguiente exito==1 porque el executeUpdate, te devuelve un número uno si la acción que vos le pediste
            se cumplió, y un 0 si no se cumplió.*/
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Modificado exitósamente");
               ps.close();
            }else{
              
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto"+ ex.getMessage());
            
        }
     
     }
     
     public void eliminarProductoPorId(int idProducto){
        
        String sql= "UPDATE producto SET estado=0 WHERE idProducto = ? ";
        //NO le pongo para actualizar el ESTADO porque de eso se va a encargar el método de ELIMINAR (eliminado lógico)
        PreparedStatement ps= null;
        /*En el UPDATE le estoy dando datos a mi bd(ps.setString, ps.setInt - le estoy dando a mi ps los datos),
        pero los tengo que sacar del objeto producto que le doy al método(producto.getNombreProducto),
        que en la vista de modificar producto es en donde le voy a pasar los datos.*/
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            int exito= ps.executeUpdate();
            /*Se pone el uno en la línea siguiente exito==1 porque el executeUpdate, te devuelve un número uno si la acción que vos le pediste
            se cumplió, y un 0 si no se cumplió.*/
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto"+ ex.getMessage());
            
        }
        
     
}
     
  public boolean consultarStock (int idProducto, int cantidad) {
        // Consulta para obtener el stock actual del producto
        String consultaStock = "SELECT stock FROM Producto WHERE idProducto = ?";
        
        // Consulta para actualizar el stock después de la compra
        String consultaActualizarStock = "UPDATE Producto SET stock = ? WHERE idProducto = ?";
        
        try {
            // Obtener el stock actual
            PreparedStatement stmt = con.prepareStatement(consultaStock);
            stmt.setInt(1, idProducto);
            
            
            // Ejecutar la consulta y obtener el resultado
            int stockActual = 0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                stockActual = rs.getInt("stock");
            }
            
            // Verificar si hay suficiente stock para la compra
            if (stockActual >= cantidad) {
                // Calcular el nuevo stock después de la compra
                int nuevoStock = stockActual - cantidad;
                
                // Actualizar el stock en la base de datos
                PreparedStatement actualizarStmt = con.prepareStatement(consultaActualizarStock);
                actualizarStmt.setInt(1, nuevoStock);
                actualizarStmt.setInt(2, idProducto);
                actualizarStmt.executeUpdate();
                
                // La compra fue exitosa
                JOptionPane.showMessageDialog(null, "Compra Exitosa");
                return true;
                        
            } else {
                // No hay suficiente stock
                JOptionPane.showMessageDialog(null, "No hay Stock.El stock actual es:"+stockActual);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Ocurrió un error
        return false;
    }

      
}