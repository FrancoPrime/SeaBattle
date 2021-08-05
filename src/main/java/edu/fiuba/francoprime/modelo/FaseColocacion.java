package edu.fiuba.francoprime.modelo;

public class FaseColocacion implements FaseJuego{

    public FaseColocacion(){

    }

    public FaseJuego siguienteFase(Juego juego){
        if(juego.cantidadAColocar() > 1) {
            juego.seColocoUnBarco();
            return this;
        }
        if(juego.jugadorActual().identificador() == 1){
            juego.avanzarJugador();
            juego.establecerColocacionDeBarcos();
            return new FaseColocacion();
        }
        else
            return new FaseAtaque();
    }

    public void realizarJugada(Jugador primerJugador, Jugador segundoJugador, int jugadorActual, Jugada jugada){
        if(jugadorActual == 1){
            segundoJugador.realizarJugada(jugada);
        }
        else{
            primerJugador.realizarJugada(jugada);
        }
    }

}
