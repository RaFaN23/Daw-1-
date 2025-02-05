package modelos;

import java.util.Objects;

public class Empleado {
    private int identificador;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String numTelefono;
    private Empresa empresa;
    private Contrato contrato;

    // Constructor vacío
    public Empleado() {}

    // Constructor copia
    public Empleado(Empleado e) {
        this.identificador = e.identificador;
        this.dni = e.dni;
        this.nombre = e.nombre;
        this.apellidos = e.apellidos;
        this.direccion = e.direccion;
        this.numTelefono = e.numTelefono;
        this.empresa = e.empresa;
        this.contrato = e.contrato;
    }

    // Constructor completo
    public Empleado(int identificador, String dni, String nombre, String apellidos, String direccion, String numTelefono, Empresa empresa, Contrato contrato) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.empresa = empresa;
        this.contrato = contrato;
    }

    // Getters y Setters
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
    public String getNumTelefono() { return numTelefono; }
    public void setNumTelefono(String numTelefono) { this.numTelefono = numTelefono; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public Contrato getContrato() { return contrato; }
    public void setContrato(Contrato contrato) { this.contrato = contrato; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Empleado{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", empresaId=" + (empresa != null ? empresa.getIdentificador() : "null") + // Evitar recursión
                ", contrato=" + contrato +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return identificador == empleado.identificador && dni.equals(empleado.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni);
    }
}
