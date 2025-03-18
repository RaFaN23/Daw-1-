package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesF1 {

    public UtilidadesF1() {
    }





    /**
     * Devuelve la lista de pilotos cuya escudería tiene la marca que se pasa como parámetro.
     *
     * @param pilotos
     * @param marca
     * @return
     */
    public static List<Piloto> getPilotosPorMarcaEscuderia(List<Piloto> pilotos, Marca marca){

        List<Piloto>PilotosFiltrados =new ArrayList<>();

        for (Piloto p : pilotos){
            if (p.getEscuderia().getMarca().equals(marca)){
                PilotosFiltrados.add(p);
            }
        }
        return PilotosFiltrados;
    }


    /**
     * Devuelve los pilotos agrupados por escudería
     *
     * @param pilotos
     * @return
     */
    public static Map<Escuderia, List<Piloto>>  pilotosPorEscuderia(List<Piloto> pilotos){
        Map<Escuderia,List<Piloto>> PilotosPorEscuderia= new HashMap<>();
        for (Piloto p : pilotos){
            Escuderia escuderia = p.getEscuderia();
            List<Piloto> ListaPilotos = PilotosPorEscuderia.get(escuderia);
            if (ListaPilotos == null){
                ListaPilotos = new ArrayList<>();
                PilotosPorEscuderia.put(escuderia,ListaPilotos);
            }
            ListaPilotos.add(p);
        }
        return PilotosPorEscuderia;
    }


    /**
     * Devuelvo los coches cuya suma de puntuacion -> (velocidadPunta + aceleracion - tiempoMedioParadaBoxes - probabilidadAveria )
     * es mayor a la que se pasa , ORDENADOR POR PUNTUACIÓN DE MAYOR A MENOR
     *
     * @param coches
     * @param minimoPuntuacionRequerida
     * @return
     */
    public static List<Coche> topMejoresCoches(List<Coche> coches, Double minimoPuntuacionRequerida){

          List<Coche> MejoresCoches= new ArrayList<>();
          for (Coche c : coches){
              Double Punctuation = c.Puntuacion();
              if (Punctuation > minimoPuntuacionRequerida){
                  MejoresCoches.add(c);
              }

          }
          MejoresCoches.sort((c1, c2) -> Double.compare(c2.Puntuacion(), c1.Puntuacion()));
          return MejoresCoches;
    }


    /**
     * Devuelve el porcentaje de victoria de un piloto , que se calcula con la siguiente fórmula:
     *
     * -> puntuación total coche del su escuderia  (velocidadPunta + aceleracion - tiempoMedioParadaBoxes - probabilidadAveria)
     * -> +
     * -> puntosRanking de su escuderia
     * -> +
     * -> puntosRanking piloto
     *
     * @param piloto
     * @return
     */
    public static Double porcentajeVictoriaPiloto(Piloto piloto){
        Double PuntuacionTotal = piloto.getEscuderia().getCoche().Puntuacion();
        Integer PuntuacionEscuderia = piloto.getEscuderia().getPuntosRanking();
        Integer PuntuacionPiloto = piloto.getPuntosRanking();
        Double PosibilidadVicotoria = PuntuacionPiloto + PuntuacionEscuderia +PuntuacionTotal;
        return PosibilidadVicotoria;
    }


    /**
     * Devuelve el piloto con mayor porcentaje de victoria de los dos que se pasa,
     * el porcentaje de victoria se calcula del ejercicio anterior.
     *
     */
     public static Piloto getMejorPiloto(Piloto piloto1, Piloto piloto2){
        Double Piloto1 = porcentajeVictoriaPiloto(piloto1);
        Double Piloto2 = porcentajeVictoriaPiloto(piloto2);
        if (Piloto1 > Piloto2){
            return piloto1;
        }else if (Piloto1 < Piloto2) {
            return piloto2;
        }else {
            return null;
        }

     }


    /**
     * Devuelve el mapa de las posiciones obtenidas por las escuderías del ranking de la temporada que se pasa como parámetro,
     * teniendo en cuenta que sólo hay un ranking por temporada.
     *
     * Las claves del mapa son el orden obtenido de mayor a menor , tras ordenar las temporadas del ranking por su "posicionEnRanking"
     *
     * @param rankingEscuderias
     * @param temporada
     * @return
     */
    public static Map<Integer, Escuderia> getRankigPorEscuderias(List<RankingEscuderias> rankingEscuderias, Integer temporada) {
        Map<Integer, Escuderia> rankingPorEscuderias = new HashMap<>();

        for (RankingEscuderias r : rankingEscuderias) {
            if (r.getTemporada().equals(temporada)) {
                r.getEscuderias().sort(Comparator.comparingInt(Escuderia::getPosicionEnRanking));

                for (Escuderia e : r.getEscuderias()) {
                    rankingPorEscuderias.put(e.getPosicionEnRanking(), e);
                }
                break;
            }
        }

        return rankingPorEscuderias;
    }


    /**
     * Devuelve un mapa de los pilotos con la suma de puntos que tengan de las carreras que se pasa como parámetro.
     * Los puntos se obtienen sacando la posición en la que queda el piloto del mapa de "posiciones" y de los puntos
     * que correspondan a esa posición en el mapa "puntosPorPosicion"
     *
     * @param carreras
     * @return
     */
    public static Map<Piloto, Double> totalPuntuacion(List<Carrera> carreras) {

        Map<Piloto, Double> puntuacionTotal = new HashMap<>();

        for (Carrera c : carreras) {
            Map<Integer, Piloto> posiciones = c.getPosiciones();
            Map<Integer, Double> puntosPorPosicion = c.getPuntosPorPosicion();

            for (Map.Entry<Integer, Piloto> entry : posiciones.entrySet()) {
                Integer posicion = entry.getKey();
                Piloto piloto = entry.getValue();
                Double puntos = puntosPorPosicion.getOrDefault(posicion, 0.0);

                puntuacionTotal.put(piloto, puntuacionTotal.getOrDefault(piloto, 0.0) + puntos);
            }
        }

        return puntuacionTotal;
    }

}
