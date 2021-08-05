package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class JugadaEstablecerBarco implements Jugada{

    private Barco barco;

    public JugadaEstablecerBarco(Barco barco){
        this.barco = barco;
    }

    @Override
    public void ejecutar(Mapa mapa) {
        mapa.establecerBarcoEnColocacion(this.barco);
    }

}
