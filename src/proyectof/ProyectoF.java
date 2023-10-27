package proyectof;

import AccesoADatos.DetalleVentaData;
import AccesoADatos.ClienteData;
import AccesoADatos.Conexion;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

public class ProyectoF {

    public static void main(String[] args) {
          Connection conexion = Conexion.getConexion();
          Producto prod = new Producto(1,"telefono alcatel","azul",4000,5,true);
          Producto prod2 = new Producto(4,"telefono alcatel","rosa",4000,5,true);
         
          /*NOTA: Para agregar los productos, NO hace falta el id en los datos del producto tipo Producto,
          pero para modificarlo SI hace falta ¿por que? porque justamente para poder MODIFICAR el producto, la condicion de modificaciión
          es el ID, y ese ID se saca justamente del OBJETO producto tipo Producto que nosotros le introducimos por parámetro, por eso LO TIENE QUE TENER.*/
          ProductoData pdata = new ProductoData();
          ClienteData cData= new ClienteData();
         
        //pdata.modificarProducto(prod2);
          //pdata.buscarProductoPorId(1);
         //pdata.guardarProducto(prod2);
         Cliente cliente1=new Cliente(5,"Miranda Bazualdo", "Jorge Luis", "115648923", "CABA",true);
         Cliente cliente2=new Cliente(1,"Fernandez", "Marcelo", "114897623", "CABA", true);
         Cliente cliente3=new Cliente(6,"Suarez", "Micael", "115987636", "CABA", true);
         Cliente cliente4= new Cliente(3, "Cabral", "Josefina", "3513347562","San Luis", true);
        //cData.guardarCliente(cliente3);
         //cData.buscarClientePorId(1);
         //cData.modificarCliente(cliente4);
         //cData.eliminarClienteporId(1);
        // cData.listarClientes();
         Cliente ultimo=new Cliente(10, "Pedro POR FIN CONSEGUIREMOS?", "juan", "123141", "CABA", true);
         Cliente ultimo2=new Cliente(12, "Finally?", "juan", "123141", "CABA", true);
//         cData.eliminarClienteporId(1);
//         cData.guardarCliente(ultimo2);
        // cData.modificarCliente(ultimo2);
         Venta venta1= new Venta(cliente1, LocalDate.now());
         Venta venta2=new Venta(cliente3, LocalDate.of(2015, Month.MARCH, 10));
         Venta venta3= new Venta(cliente2, LocalDate.of(2015, Month.MARCH, 10));
         Venta venta4=new Venta(cliente1, LocalDate.of(2023, Month.SEPTEMBER, 21));
         
         
         
         VentaData vData= new VentaData();
//         vData.guardarVenta1(venta4, 1, 1);
         
         for (Venta venta : vData.buscarVentasPorProducto(4)) {
             System.out.println("id venta: " + venta.getIdVenta());
             System.out.println("Cliente: " + venta.getCliente().getNombre() );
             System.out.println("Fecha: " + venta.getFechaVenta());
        }
        
       
//         for (Venta venta : vData.buscarVentasPorFecha(Date.valueOf(LocalDate.of(2015, Month.MARCH, 10))) ){
//            
//            System.out.println("id venta: " + venta.getIdVenta());
//            System.out.println("Cliente: " + venta.getCliente());
//            System.out.println("Fecha: " + venta.getFechaVenta());
//        
//        
//         }
//         for(Venta venta: vData.buscarVentasPorCliente(1)){
//             System.out.println("id venta: " + venta.getIdVenta());
//             System.out.println("Cliente: " + venta.getCliente());
//             System.out.println("Fecha: " + venta.getFechaVenta());
//             
//             
//         }

            DetalleVentaData detalleventa=new DetalleVentaData();
            //para usar guardar inscripcion venta y producto tienen que tener ID
            DetalleVenta detalle1=new DetalleVenta(2, venta4, 1000, prod2);
//            detalleventa.guardarDetalleVenta(detalle1);
         
           
//           for (Venta venta: vData.listarVentasPorFecha1(Date.valueOf(LocalDate.of(2023, Month.OCTOBER, 05)))){
//               System.out.println("ID DE VENTA: "+ venta.getIdVenta());
//               
//               
//           }
//           for (DetalleVenta detalles : detalleventa.listarProductos(9)){
//               System.out.println("ID DETALLEVENTA"+ detalles.getIdDetalleVent());
//               System.out.println("CANTIDAD " + detalles.getCantidad());
//               System.out.println("ID VENTA" + detalles.getVenta().getIdVenta());
//               System.out.println("PRECIO VENTA: " + detalles.getPrecioVenta());
//               System.out.println("ID PRODUCTO: "+detalles.getProducto().getIdProducto());
//             

//               
//           }

//                    for (Cliente detalles : cData.listarClientes()){
//                        System.out.println("Nombre"+detalles.getNombre());
//                        System.out.println("Apellido"+detalles.getApellido());
//                        System.out.println("Telefono"+detalles.getTelefono());
//                        System.out.println("Domicilio"+detalles.getDomicilio());
//                        System.out.println("Estado"+ detalles.isEstado());
//               
//               
//               
//           }
    }
    
    
}
