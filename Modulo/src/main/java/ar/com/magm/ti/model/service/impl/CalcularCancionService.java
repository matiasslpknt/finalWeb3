/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.service.ICalcularCancionService;
import java.util.ArrayList;

/**
 *
 * @author matia
 */
public class CalcularCancionService implements ICalcularCancionService {

    private ArrayList<Cancion> canciones;

    public CalcularCancionService() {
        this.canciones = canciones;
    }

    @Override
    public Cancion CancionMejorPuntuada(ArrayList<Cancion> canciones) {
        float rep = 0;
        Cancion cc = new Cancion();
        for (Cancion c : canciones) {
            if (c.getRating() > rep) {
                cc = c;
            }
        }
        return cc;
    }

    @Override
    public Cancion CancionMasReproducida(ArrayList<Cancion> canciones) {
        int cant = 0;
        Cancion cc = new Cancion();
        for (Cancion c : canciones) {
            if (c.getReproducciones() > cant) {
                cc = c;
            }
        }
        return cc;
    }
}
