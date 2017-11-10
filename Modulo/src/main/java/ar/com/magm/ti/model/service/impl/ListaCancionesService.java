package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.service.IListaCancionesService;
import java.util.ArrayList;

/**
 * Aqui se haran los Calculos correspondientes que nos daran el valor de la
 * sancion que corresponde.
 *
 */
public class ListaCancionesService implements IListaCancionesService {

    @Override
    public ArrayList<Cancion> ordenarCancionPorDuracion(ArrayList<Cancion> canciones) throws NumberFormatException {
        ArrayList<Cancion> listaOrdenada = new ArrayList<Cancion>();
        int tamaño = canciones.size();
        for (int i = 0; i < tamaño; i++) {
            int indice = getIndexDelMayor(canciones);
            if (indice != -1) {
                listaOrdenada.add(canciones.get(indice));
                canciones.remove(indice);
            } else {
                for (Cancion c : canciones) {
                    listaOrdenada.add(c);
                }
            }
        }
        return listaOrdenada;
    }

    @Override
    public String getDuracionTotalLista(ArrayList<Cancion> canciones) throws NumberFormatException {
        String duracion = "0s";
        long sumaSegundos = 0;
        long segAux = 0, minAux = 0, hourAux = 0, daysAux = 0, weeksAux = 0;

        sumaSegundos = calcular(canciones);
        if (sumaSegundos >= 60) {
            minAux = sumaSegundos / 60;
            segAux = sumaSegundos % 60;
            if (minAux >= 60) {
                hourAux = minAux / 60;
                minAux %= 60;
                if (hourAux >= 24) {
                    daysAux = hourAux / 24;
                    hourAux = hourAux % 60;
                    if (daysAux >= 7) {
                        weeksAux = daysAux / 7;
                        daysAux = daysAux % 7;
                    }
                }
            }
        }
        duracion = weeksAux + "w" + daysAux + "d" + hourAux + "h" + minAux + "m" + segAux + "s";
        return duracion;
    }

    private long calcular(ArrayList<Cancion> canciones) {
        long sumaMinutos1 = 0;
        long sumaSegundos1 = 0;
        for (Cancion c : canciones) {
            String[] aux = parser(c.getDuracion());
            long minutos = Long.valueOf(aux[0]).longValue();
            long segundos = Long.valueOf(aux[1]).longValue();
            sumaMinutos1 += minutos;
            sumaSegundos1 += segundos;
            sumaSegundos1 += sumaMinutos1 * 60;
            sumaMinutos1 = 0;
        }
        return sumaSegundos1;
    }

    private String[] parser(String aux) {
        String[] array = aux.split("''");
        aux = array[0];
        array = aux.split("'");
        return array;
    }

    private int getIndexDelMayor(ArrayList<Cancion> canciones) {
        int indice = -1;
        int aux = 0;
        for (int i = 0; i < canciones.size(); i++) {
            String[] tiempo = parser(canciones.get(i).getDuracion());
            long minutos = Long.valueOf(tiempo[0]).longValue();
            long segundos = Long.valueOf(tiempo[1]).longValue();
            segundos += minutos * 60;
            if (segundos > aux) {
                indice = i;
            }
        }
        return indice;
    }
}
