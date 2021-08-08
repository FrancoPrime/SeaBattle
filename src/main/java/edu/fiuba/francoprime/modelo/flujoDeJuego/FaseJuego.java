package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.jugador.ListaJugadores;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public interface FaseJuego {

    FaseJuego siguienteFase(Juego juego);
    void realizarJugada(ListaJugadores listaJugadores, Jugada jugada);
    Mapa obtenerMapaActual(ListaJugadores listaJugadores);

}
