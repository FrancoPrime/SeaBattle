package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.jugador.ListaJugadores;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

import java.util.List;

public class FaseColocacion implements FaseJuego{

    public FaseJuego siguienteFase(Juego juego){
        if(juego.cantidadAColocar() > 1) {
            juego.seColocoUnBarco();
            return this;
        }
        if(!juego.alFinalDeLaListaDeJugadores()){
            juego.invisibilizarMapa();
            juego.avanzarJugador();
            juego.establecerColocacionDeBarcos();
            return this;
        }
        juego.invisibilizarMapa();
        juego.avanzarJugador();
        return new FaseAtaque();
    }

    public void realizarJugada(ListaJugadores listaJugadores, Jugada jugada){
        Jugador jugadorARealizar = listaJugadores.jugadorNoActual();
        jugadorARealizar.realizarJugada(jugada);
    }

    public Mapa obtenerMapaActual(ListaJugadores listaJugadores){
        return listaJugadores.jugadorNoActual().obtenerMapa();
    }

}
