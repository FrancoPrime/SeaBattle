package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.jugador.ListaJugadores;

public class FaseAtaque implements FaseJuego{

    public FaseJuego siguienteFase(Juego juego) {
        juego.avanzarJugador();
        return this;
    }

    public void realizarJugada(ListaJugadores listaJugadores, Jugada jugada) {
        Jugador jugadorARealizarJugada = listaJugadores.jugadorActual();
        jugadorARealizarJugada.realizarJugada(jugada);
    }
}
