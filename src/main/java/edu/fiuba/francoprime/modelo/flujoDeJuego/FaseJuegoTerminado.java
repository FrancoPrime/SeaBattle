package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.ListaJugadores;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class FaseJuegoTerminado implements FaseJuego{

    public FaseJuego siguienteFase(Juego juego) {
        return this;
    }

    public void realizarJugada(ListaJugadores listaJugadores, Jugada jugada) {
    }

    public Mapa obtenerMapaActual(ListaJugadores listaJugadores) {
        return listaJugadores.jugadorNoActual().obtenerMapa();
    }

}
