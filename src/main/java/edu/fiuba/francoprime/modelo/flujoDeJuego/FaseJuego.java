package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Jugador;

public interface FaseJuego {

    FaseJuego siguienteFase(Juego juego);
    void realizarJugada(Jugador primerJugador, Jugador segundoJugador, int jugadorActual, Jugada jugada);

}
