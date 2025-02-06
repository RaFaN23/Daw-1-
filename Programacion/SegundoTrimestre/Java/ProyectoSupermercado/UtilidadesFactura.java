package utilidades;

import modelos.Factura;
import modelos.LineaFactura;

import java.time.LocalDate;

public class UtilidadesFactura {
    public boolean esFacturaVencida(Factura factura){
        if (factura.getFechaVencimiento().isBefore(LocalDate.now())==true)
            System.out.println("La fecha de vencimiento es apta");
        else {
            System.out.println("La fecha de vencimiento no es apta");
        }
        return esFacturaVencida(factura);
    }
    public double calcularBaseFactura(Factura factura){
        double contador=0;
        for(LineaFactura lineaFactura : factura.getLineaFactura()){
            double precioProducto =lineaFactura.getProducto().getPrecio();
            int cantidad=lineaFactura.getCantidad();
            contador+=precioProducto*cantidad;
        }
        return calcularBaseFactura(factura);
    }

    public double calcularTotalAPagar(Factura factura){
        double totalAPagar = (factura.getImporteBase() - factura.getDescuento()) * factura.getIva();
        return totalAPagar;
    }
}
