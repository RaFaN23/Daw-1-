package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Factura {
    private int identificador;
    private String codigoFactura;
    private double importeBase;
    private double descuento;
    private double iva;
    private double totalAPagar;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private boolean pagada;
    private List<LineaFactura> lineaFactura;
    private Cliente cliente;

    // Constructor vacío
    public Factura() {}

    // Constructor completo
    public Factura(int identificador, String codigoFactura, double importeBase, double descuento, double iva, double totalAPagar, LocalDate fechaEmision, LocalDate fechaVencimiento, boolean pagada, List<LineaFactura> lineaFactura, Cliente cliente) {
        this.identificador = identificador;
        this.codigoFactura = codigoFactura;
        this.importeBase = importeBase;
        this.descuento = descuento;
        this.iva = iva;
        this.totalAPagar = totalAPagar;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
        this.lineaFactura = lineaFactura;
        this.cliente = cliente;
    }

    // Métodos get y set
    public int getIdentificador() { return identificador; }
    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public String getCodigoFactura() { return codigoFactura; }
    public void setCodigoFactura(String codigoFactura) { this.codigoFactura = codigoFactura; }

    public double getImporteBase() { return importeBase; }
    public void setImporteBase(double importeBase) { this.importeBase = importeBase; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    public double getIva() { return iva; }
    public void setIva(double iva) { this.iva = iva; }

    public double getTotalAPagar() { return totalAPagar; }
    public void setTotalAPagar(double totalAPagar) { this.totalAPagar = totalAPagar; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean isPagada() { return pagada; }
    public void setPagada(boolean pagada) { this.pagada = pagada; }

    public List<LineaFactura> getLineaFactura() { return lineaFactura; }
    public void setLineaFactura(List<LineaFactura> lineaFactura) { this.lineaFactura = lineaFactura; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    // Métodos toString, equals y hashcode
    @Override
    public String toString() {
        return "Factura [identificador=" + identificador + ", codigoFactura=" + codigoFactura + ", importeBase=" + importeBase + ", descuento=" + descuento + ", iva=" + iva + ", totalAPagar=" + totalAPagar + ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento + ", pagada=" + pagada + ", lineaFactura=" + lineaFactura + ", cliente=" + cliente + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Factura factura = (Factura) obj;
        return identificador == factura.identificador &&
                Double.compare(factura.importeBase, importeBase) == 0 &&
                Double.compare(factura.descuento, descuento) == 0 &&
                Double.compare(factura.iva, iva) == 0 &&
                Double.compare(factura.totalAPagar, totalAPagar) == 0 &&
                pagada == factura.pagada &&
                codigoFactura.equals(factura.codigoFactura) &&
                fechaEmision.equals(factura.fechaEmision) &&
                fechaVencimiento.equals(factura.fechaVencimiento) &&
                lineaFactura.equals(factura.lineaFactura) &&
                cliente.equals(factura.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoFactura, importeBase, descuento, iva, totalAPagar, fechaEmision, fechaVencimiento, pagada, lineaFactura, cliente);
    }
}
