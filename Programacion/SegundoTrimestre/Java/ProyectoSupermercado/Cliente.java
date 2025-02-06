package modelos;

import java.util.Objects;

public class Cliente {
    //atributos
    private int identificador;
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private TipoCliente tipoCliente;
    //getters y setters

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    //contructores

    public Cliente(int identificador, String dni, String nombre, String apellido, String direccion, TipoCliente tipoCliente) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {
    }
    //equals y hascode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return identificador == cliente.identificador && Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(direccion, cliente.direccion) && tipoCliente == cliente.tipoCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellido, direccion, tipoCliente);
    }
    //toString

    @Override
    public String toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
