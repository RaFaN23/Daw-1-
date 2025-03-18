package utilidades;

import modelos.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesFeria {


    /**
     * Devuelve los productos que devuelve los productos comunes entre todos los caterings pasados (1.5 puntos)
     *
     * @param caterings
     * @return
     */
    public static List<Producto> getProductosCoincidente(List<Catering> caterings) {
        if (caterings.isEmpty()) {
            return new ArrayList<>();
        }
        List<Producto> productosComunes = new ArrayList<>(caterings.get(0).getProductos());

        for (Catering catering : caterings) {
            productosComunes.retainAll(catering.getProductos());
        }
        return productosComunes;
    }


    /**
     * Agrupa los productos del catering de una caseta por tipo (1 punto)
     *
     * @param caseta
     * @return
     */
    public static Map<TipoProducto, List<Producto>> getProductosPorTipo(Caseta caseta){
        Map<TipoProducto,List<Producto>> ProductosPorTipo =new HashMap<>();
        for (Producto producto : caseta.getCatering().getProductos()){
            TipoProducto tipo = producto.getProducto();
            if (!ProductosPorTipo.containsKey(tipo)){
                ProductosPorTipo.put(tipo,new ArrayList<>());
            }
            ProductosPorTipo.get(tipo).add(producto);
        }
        return ProductosPorTipo;
    }


    /**
     * Filtra los asistentes obteniendo los mayores de edad, es decir los que tienen más de 18 años,
     * agrupándolos por año de nacimiento (2 puntos)
     *
     * @param asistentes
     * @return
     */
    public static Map<Integer, List<Asistente>> getMayoresDeEdadPorAnyoNacimiento(List<Asistente> asistentes){
        Map<Integer,List<Asistente>> mayorPorAnyio = new HashMap<>();
        for (Asistente asistente : asistentes){
            int edad = Period.between(asistente.getFechaNacimiento(), LocalDate.now()).getYears();
            if (edad>=18){
                int anyoNacimiento = asistente.getFechaNacimiento().getYear();
                if (mayorPorAnyio.containsKey(anyoNacimiento)){
                    mayorPorAnyio.get(anyoNacimiento).add(asistente);
                }
                mayorPorAnyio.put(anyoNacimiento,new ArrayList<>());
            }
        }
        return mayorPorAnyio;
    }


    /**
     * Devuelve la lista de asistentes de la feria que son de alguno de los tipos pasados,
     * y que son socios de más de una caseta. (1.5 puntos)
     *
     * @param feria
     * @return
     */
    public static List<Asistente> getPorTipoYSocios(Feria feria, List<TipoAsistente> tipoAsistentes) {
        List<Asistente> asistentesFiltrados = new ArrayList<>();

        for (Asistente asistente : feria.getAsistentes()) {
            if (tipoAsistentes.contains(asistente.getTipoAsistente()) && asistente.getCasetasMiembro().size() > 1) {
                asistentesFiltrados.add(asistente);
            }
        }

        return asistentesFiltrados;
    }


    /**
     * Devuelve el total de la suma de productos por cada Catering (1 punto)
     *
     * @param caterings
     * @return
     */
    public static Map<Catering, Double> sumImporteProductosCaterind(List<Catering> caterings){
        Map<Catering, Double>importeProductoCaterin = new HashMap<>();
        for (Catering catering : caterings){
            double total = 0;
            for (Producto producto : catering.getProductos()) {
                total+= producto.getPrecio();
            }
            importeProductoCaterin.put(catering,total);
        }
        return importeProductoCaterin;
    }


    /**
     * Rellena los datos del resumen del día del asistente (3 puntos)
     *
     * @param asistente
     * @param consumo
     * @param viajesAtraccion
     * @return
     */
    public static  ResumenDia obtenerResumenDia(Asistente asistente, Map<Producto, Integer> consumo, Map<Atraccion, Integer> viajesAtraccion){

          return null;

    }



}
