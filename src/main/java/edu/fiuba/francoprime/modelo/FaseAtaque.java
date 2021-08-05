package edu.fiuba.francoprime.modelo;

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
