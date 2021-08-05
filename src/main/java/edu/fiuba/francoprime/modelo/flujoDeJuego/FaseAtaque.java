package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Jugador;

public class FaseAtaque implements FaseJuego{


    public FaseJuego siguienteFase(Juego juego) {
        juego.avanzarJugador();
        return this;
    }

    public void realizarJugada(Jugador primerJugador, Jugador segundoJugador, int jugadorActual, Jugada jugada) {
        if(jugadorActual == 1){
            primerJugador.realizarJugada(jugada);
        }
        else{
            segundoJugador.realizarJugada(jugada);
        }
    }
}
