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

    public boolean estaAlFinal(){
        return this.jugadorActual == 2;
    }

    public boolean hayGanador(){
        boolean hayGanador = false;
        for(Jugador jugador : this.jugadores){
            if(jugador.todosSusBarcosDestruidos())
                hayGanador = true;
        }
        return hayGanador;
    }

    public Jugador jugadorGanador(){
        if(!this.hayGanador())
            return null;
        if(this.jugadores.get(0).todosSusBarcosDestruidos())
            return this.jugadores.get(1);
        return this.jugadores.get(0);
    }

}
