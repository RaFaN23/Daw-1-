package utilidades;

import modelos.Factura;
import modelos.LineaFactura;
import java.time.LocalDate;

public class UtilidadesFactura {

    public boolean esFacturaVencida(Factura factura) {
        return factura.getFechaVencimiento().isBefore(LocalDate.now()) || factura.getFechaVencimiento().isEqual(LocalDate.now());
    }

    public double calcularBaseFactura(Factura factura) {
        double baseFactura = 0;
        for (LineaFactura linea : factura.getLineaFactura()) {
            baseFactura += linea.getProducto().getPrecio() * linea.getCantidad();
        }
        return baseFactura;
    }

    public double calcularTotalAPagar(Factura factura) {
        double importeBase = calcularBaseFactura(factura);
        return (importeBase - factura.getDescuento()) * factura.getIva();
    }
}
