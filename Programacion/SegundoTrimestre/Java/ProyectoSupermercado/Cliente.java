package modelos;

import java.util.Objects;

public class Cliente {
    private int identificador;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private TipoCliente tipoCliente;

    // Constructor vacío
    public Cliente() {}

    // Constructor completo
    public Cliente(int identificador, String dni, String nombre, String apellidos, String direccion, TipoCliente tipoCliente) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    // Métodos get y set
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Cliente [identificador=" + identificador + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", tipoCliente=" + tipoCliente + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return identificador == cliente.identificador &&
                dni.equals(cliente.dni) &&
                nombre.equals(cliente.nombre) &&
                apellidos.equals(cliente.apellidos) &&
                direccion.equals(cliente.direccion) &&
                tipoCliente == cliente.tipoCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, direccion, tipoCliente);
    }

    public enum TipoCliente {
        PARTICULAR, EMPRESA
    }
}
