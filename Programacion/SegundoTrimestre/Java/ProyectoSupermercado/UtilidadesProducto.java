package utilidades;
import modelos.Almacen;

import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;

import java.util.List;
public class UtilidadesProducto {
    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){
        List<Producto>productosPorTipo=new ArrayList<>();
        for(Producto producto:productos){
            if(producto.getTipoProducto()==tipo){
                productosPorTipo.add(producto);
            }
        }return productosPorTipo;
    }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto>productosPorAlmacen=new ArrayList<>();
        for(Producto producto:productos){
            if(producto.getAlmacen()==almacen){
                productosPorAlmacen.add(producto);
            }
        }return productosPorAlmacen;
    }
}
