package AccesoADatos;
import Entidades.Producto;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author 2022
 */
public class ClienteData {
    private Connection con = null;
    
    public ClienteData(){
        con = Conexion.getConexion();
    }
    
    public void guardarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (apellido,nombre,telefono,domicilio,estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString (3, cliente.getTelefono());
            ps.setString (4,cliente.getDomicilio()); 
            ps.setBoolean(5, cliente.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                cliente.setIdCliente(1);
                JOptionPane.showMessageDialog(null, "Cliente Agregado Exitosamente!");           
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la accion");
        }
    }
    
        public Cliente buscarClientePorId(int idCliente){
        Cliente cliente= null;
        String sql= "SELECT apellido, nombre, telefono,domicilio FROM cliente WHERE idCliente=? AND estado=1";
        PreparedStatement ps= null;
        
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             cliente= new Cliente();
             cliente.setIdCliente(idCliente);
             cliente.setApellido(rs.getString("apellido"));
             cliente.setNombre(rs.getString("nombre"));
             cliente.setTelefono(rs.getString("telefono"));
             cliente.setDomicilio(rs.getString("domicilio"));
             cliente.setEstado(true);
             
                
            }else{
             
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla cliente"+ ex.getMessage());
         
        }return cliente;
     
    }
        public List<Cliente> listarClientes(){
        List<Cliente> clientes= new ArrayList<>();
        
        String sql= "SELECT * FROM cliente WHERE estado IN (0,1)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Cliente cliente= new Cliente();
                
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDomicilio(rs.getString("domicilio"));
                
                cliente.setEstado(rs.getBoolean("estado"));
                clientes.add(cliente);
                
                
            
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla cleinte"+ ex.getMessage());
            
        }
        return clientes;
        
    }
        public void modificarCliente(Cliente cliente) {
    String sql = "UPDATE cliente SET apellido = ?, nombre = ?, domicilio = ?, telefono = ?, estado = ? WHERE idCliente = ?";

    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, cliente.getApellido());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getDomicilio());
        ps.setString(4, cliente.getTelefono());
        ps.setBoolean(5, cliente.isEstado());
        ps.setInt(6, cliente.getIdCliente());

        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Modificado exitósamente");
        } else {
            // Manejar el caso de error de actualización si lo deseas.
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente: " + ex.getMessage());
    }
}
//        public void modificarCliente(Cliente cliente){
//        
//        String sql= "UPDATE cliente SET apellido= ?, nombre= ?, domicilio=?, telefono = ? WHERE idCliente=? ";
//        
//        PreparedStatement ps= null;
//        
//        try {
//            ps= con.prepareStatement(sql);
//            ps.setString(1, cliente.getApellido());
//            ps.setString(2, cliente.getNombre());
//            ps.setString(3, cliente.getDomicilio());
//            ps.setString(4, cliente.getTelefono());
//            ps.setInt(5, cliente.getIdCliente());
//            
//            int exito= ps.executeUpdate();
//            
//            if(exito==1){
//                JOptionPane.showMessageDialog(null, "Modificado exitósamente");
//            }else{
//                
//                
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente"+ ex.getMessage());
//            
//        }       
    
        
            public void eliminarClienteporId (int idCliente){       
        try {
            String sql= "UPDATE cliente SET estado =0 WHERE idCliente=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idCliente);
           
            int fila= ps.executeUpdate();
            
            
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se elimino el cliente, ID: " + idCliente);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        
        
    }
}
