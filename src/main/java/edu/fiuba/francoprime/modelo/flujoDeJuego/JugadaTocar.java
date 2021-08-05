package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.mapa.Coordenada;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class JugadaTocar implements Jugada{

    Coordenada coordenada;
    private int fila;
    private int columna;

    public JugadaTocar(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public void ejecutar(Mapa mapa){
        mapa.realizarJugada(this.fila, this.columna);
    }

}
