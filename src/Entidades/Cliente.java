package Entidades;

import javax.swing.JOptionPane;

public class Cliente {
    
    private int idCliente;
    private String apellido;
    private String nombre;
    private String telefono;
    private String domicilio;
    private boolean estado;

    public Cliente(int idCliente, String apellido, String nombre, String telefono, String domicilio, boolean estado) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.estado = estado;
    }

    public Cliente(int idCliente, String apellido, String nombre, String telefono, String domicilio) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public Cliente(String apellido, String nombre, String telefono, String domicilio, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.estado = estado;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    
    @Override
    public String toString() {
        return "ID " + idCliente + ":" + " " + nombre + " " + apellido ;
    }
    
    
}
