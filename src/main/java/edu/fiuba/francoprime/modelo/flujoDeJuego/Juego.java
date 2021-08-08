package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.jugador.ListaJugadores;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.Observable;

public class Juego extends Observable {

    private FaseJuego fase;
    private ListaJugadores listaJugadores;
    private ArrayList<Barco> barcosAColocar;

    public Juego(){
        this.fase = new FaseColocacion();
        this.listaJugadores = new ListaJugadores();
        establecerColocacionDeBarcos();
    }

    public Mapa obtenerMapaActual(){
        return this.fase.obtenerMapaActual(this.listaJugadores);
    }

    public FaseJuego faseActual(){
        return this.fase;
    }

    public Jugador jugadorActual(){
        return this.listaJugadores.jugadorActual();
    }

    public boolean alFinalDeLaListaDeJugadores(){
        return this.listaJugadores.estaAlFinal();
    }

    public void realizarJugada(Jugada jugada){
        this.fase.realizarJugada(this.listaJugadores, jugada);
        setChanged();
    }

    public boolean hayGanador() {
        return this.listaJugadores.hayGanador();
    }

    public void finalizarColocacion() {
        this.obtenerMapaActual().finalizarColocacion();
        this.avanzarFase();
    }

    public void avanzarFase(){
        this.fase = this.fase.siguienteFase(this);
        setChanged();
    }

    public void avanzarJugador(){
        this.listaJugadores.avanzarJugador();
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
        this.fase.realizarJugada(this.listaJugadores, jugada);
        this.listaJugadores.jugadorActual().agregarBarco(barcoAColocar);
        setChanged();
    }

    public void invisibilizarMapa(){
        Mapa mapaActual = this.obtenerMapaActual();
        mapaActual.invisibilizar();
    }

}
