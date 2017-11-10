/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Cancion;
import java.util.ArrayList;

/**
 *
 * @author matia
 */
public interface IListaCancionesService {

    public String getDuracionTotalLista(ArrayList<Cancion> canciones) throws NumberFormatException;

    public ArrayList<Cancion> ordenarCancionPorDuracion(ArrayList<Cancion> canciones) throws NumberFormatException;
}
