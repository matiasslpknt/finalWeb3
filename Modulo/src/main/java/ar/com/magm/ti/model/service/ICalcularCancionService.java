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
public interface ICalcularCancionService {

    public Cancion CancionMejorPuntuada(ArrayList<Cancion> canciones);

    public Cancion CancionMasReproducida(ArrayList<Cancion> canciones);
}
