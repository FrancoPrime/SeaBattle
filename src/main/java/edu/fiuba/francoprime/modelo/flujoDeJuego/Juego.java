package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.jugador.Jugador;

import java.util.ArrayList;

public class Juego {

    private FaseJuego fase;
    private Jugador primerJugador;
    private Jugador segundoJugador;
    private int jugadorActual;
    private ArrayList<Barco> barcosAColocar;

    public Juego(){
        this.primerJugador = new Jugador();
        this.segundoJugador = new Jugador();
        this.jugadorActual = 1;
        this.fase = new FaseColocacion();
        establecerColocacionDeBarcos();
    }

    public FaseJuego faseActual(){
        return this.fase;
    }

    public Jugador jugadorActual(){
        if(this.jugadorActual == 1)
            return this.primerJugador;
        return this.segundoJugador;
    }

    public void realizarJugada(Jugada jugada){
        this.fase.realizarJugada(primerJugador, segundoJugador, this.jugadorActual, jugada);
        this.fase = this.fase.siguienteFase(this);
    }

    public void avanzarJugador(){
        this.jugadorActual++;
        if(this.jugadorActual > 2)
            this.jugadorActual = 1;
    }

    public int cantidadAColocar(){
        return this.barcosAColocar.size();
    }

    public void seColocoUnBarco(){
        this.barcosAColocar.remove(0);
        siguienteBarcoAColocar();
    }

    public void establecerColocacionDeBarcos(){
        this.barcosAColocar = new ArrayList<>();
        this.barcosAColocar.add(new Barco(5));
        this.barcosAColocar.add(new Barco(4));
        this.barcosAColocar.add(new Barco(3));
        this.barcosAColocar.add(new Barco(2));
        this.barcosAColocar.add(new Barco(2));
        siguienteBarcoAColocar();
    }

    public void siguienteBarcoAColocar(){
        Barco barcoAColocar = this.barcosAColocar.get(0);
        Jugada jugada = new JugadaEstablecerBarco(barcoAColocar);
        this.fase.realizarJugada(this.primerJugador, this.segundoJugador, this.jugadorActual, jugada);
    }

}
