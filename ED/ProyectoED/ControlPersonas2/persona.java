package org.example.control_persona2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class persona {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidos;
    private final SimpleIntegerProperty edad;

    public persona(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }


    public String getNombre() { return nombre.get(); }
    public String getApellidos() { return apellidos.get(); }
    public int getEdad() { return edad.get(); }


    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public void setApellidos(String apellidos) { this.apellidos.set(apellidos); }
    public void setEdad(int edad) { this.edad.set(edad); }


    public SimpleStringProperty nombreProperty() { return nombre; }
    public SimpleStringProperty apellidosProperty() { return apellidos; }
    public SimpleIntegerProperty edadProperty() { return edad; }
}
