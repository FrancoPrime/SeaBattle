package edu.fiuba.francoprime.modelo.jugador;

import edu.fiuba.francoprime.modelo.mapa.Mapa;

import java.util.ArrayList;

public class ListaJugadores {

    private ArrayList<Jugador> jugadores;
    private int jugadorActual;

    public ListaJugadores(){
        this.jugadores = new ArrayList<>();
        Jugador primerJugador = new Jugador();
        this.jugadores.add(primerJugador);
        Jugador segundoJugador = new Jugador();
        this.jugadores.add(segundoJugador);
        this.jugadorActual = 1;
    }

    public Jugador jugadorActual(){
        return jugadores.get(jugadorActual-1);
    }

    public Jugador jugadorNoActual(){
        if(this.jugadorActual == 2)
            return jugadores.get(0);
        return this.jugadores.get(1);
    }

    public void avanzarJugador(){
        this.jugadorActual++;
        if(this.jugadorActual > 2)
            this.jugadorActual = 1;
    }

    public Mapa mapaActual(){
        return this.jugadores.get(this.jugadorActual-1).obtenerMapa();
    }

    public boolean estaAlFinal(){
        return this.jugadorActual == 2;
    }

}
