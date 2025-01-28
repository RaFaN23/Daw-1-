package modelos;

import java.util.Objects;

public class LineaFactura {
    private int identificador;
    private Factura factura;
    private Producto producto;
    private int cantidad;

    // Constructor vacío
    public LineaFactura() {}

    // Constructor completo
    public LineaFactura(int identificador, Factura factura, Producto producto, int cantidad) {
        this.identificador = identificador;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Métodos get y set
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "LineaFactura [identificador=" + identificador + ", factura=" + factura + ", producto=" + producto + ", cantidad=" + cantidad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LineaFactura lineaFactura = (LineaFactura) obj;
        return identificador == lineaFactura.identificador &&
                cantidad == lineaFactura.cantidad &&
                factura.equals(lineaFactura.factura) &&
                producto.equals(lineaFactura.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, factura, producto, cantidad);
    }
}
