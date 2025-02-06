package modelos;

import java.util.Objects;

public class Almacen {

    //Atributos
    private int identificador;
    private String nombre;
    private int capacidad;

    // Metodos getter y setter


    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //Contructor


    public Almacen(int identificador, String nombre, int capacidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Almacen() {
    }

    // Metodo equals y hashcode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return identificador == almacen.identificador && capacidad == almacen.capacidad && Objects.equals(nombre, almacen.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nombre, capacidad);
    }

    // Metodo toString

    @Override
    public String toString() {
        return "Almacen{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}

