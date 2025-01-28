package modelos;

import java.util.Objects;

public class Almacen {
    private int identificador;
    private String nombre;
    private int capacidad;

    // Constructor vacío
    public Almacen() {}

    // Constructor completo
    public Almacen(int identificador, String nombre, int capacidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Métodos get y set
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Almacen [identificador=" + identificador + ", nombre=" + nombre + ", capacidad=" + capacidad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Almacen almacen = (Almacen) obj;
        return identificador == almacen.identificador &&
                capacidad == almacen.capacidad &&
                nombre.equals(almacen.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nombre, capacidad);
    }
}
