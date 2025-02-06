package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
        //atributos
    private int identificador;
    private String codigo;
    private String descripcion;
    private LocalDate fechaCaducidad;
    private TipoProducto tipoProducto;
    private Almacen almacen;
    private double precio;

    //getter y setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //contructores


    public Producto(int identificador, String codigo, String descripcion, LocalDate fechaCaducidad, TipoProducto tipoProducto, Almacen almacen, double precio) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
        this.tipoProducto = tipoProducto;
        this.almacen = almacen;
        this.precio = precio;
    }

    public Producto() {
    }

    //metodo equals y hashcode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return identificador == producto.identificador && Double.compare(precio, producto.precio) == 0 && Objects.equals(codigo, producto.codigo) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fechaCaducidad, producto.fechaCaducidad) && tipoProducto == producto.tipoProducto && Objects.equals(almacen, producto.almacen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigo, descripcion, fechaCaducidad, tipoProducto, almacen, precio);
    }


    //tostring


    @Override
    public String toString() {
        return "Producto{" +
                "identificador=" + identificador +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCaducidad=" + fechaCaducidad +
                ", tipoProducto=" + tipoProducto +
                ", almacen=" + almacen +
                ", precio=" + precio +
                '}';
    }
}
