package edu.fiuba.francoprime.modelo;

public interface FaseJuego {

    FaseJuego siguienteFase(Juego juego);
    void realizarJugada(Jugador primerJugador, Jugador segundoJugador, int jugadorActual, Jugada jugada);

}
