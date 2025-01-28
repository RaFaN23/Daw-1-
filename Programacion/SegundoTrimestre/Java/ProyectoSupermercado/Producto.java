package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
    private int identificador;
    private String codigo;
    private String descripcion;
    private LocalDate fechaCaducidad;
    private TipoProducto tipoProducto;
    private Almacen almacen;
    private double precio;

    // Constructor vacío
    public Producto() {}

    // Constructor completo
    public Producto(int identificador, String codigo, String descripcion, LocalDate fechaCaducidad, TipoProducto tipoProducto, Almacen almacen, double precio) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
        this.tipoProducto = tipoProducto;
        this.almacen = almacen;
        this.precio = precio;
    }

    // Métodos get y set
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(LocalDate fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }

    public TipoProducto getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(TipoProducto tipoProducto) { this.tipoProducto = tipoProducto; }

    public Almacen getAlmacen() { return almacen; }
    public void setAlmacen(Almacen almacen) { this.almacen = almacen; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Producto [identificador=" + identificador + ", codigo=" + codigo + ", descripcion=" + descripcion + ", fechaCaducidad=" + fechaCaducidad + ", tipoProducto=" + tipoProducto + ", almacen=" + almacen + ", precio=" + precio + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return identificador == producto.identificador &&
                Double.compare(producto.precio, precio) == 0 &&
                codigo.equals(producto.codigo) &&
                descripcion.equals(producto.descripcion) &&
                fechaCaducidad.equals(producto.fechaCaducidad) &&
                tipoProducto == producto.tipoProducto &&
                almacen.equals(producto.almacen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigo, descripcion, fechaCaducidad, tipoProducto, almacen, precio);
    }

    public enum TipoProducto {
        ALIMENTACION, BEBIDA, DROGUERIA
    }
}
