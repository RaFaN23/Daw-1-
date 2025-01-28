package utilidades;

import modelos.Producto;
import modelos.Almacen;
import modelos.Producto.TipoProducto;

import java.util.List;
import java.util.stream.Collectors;

public class UtilidadesProducto {

    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo) {
        return productos.stream()
                .filter(producto -> producto.getTipoProducto() == tipo)
                .collect(Collectors.toList());
    }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen) {
        return productos.stream()
                .filter(producto -> producto.getAlmacen().equals(almacen))
                .collect(Collectors.toList());
    }
}
