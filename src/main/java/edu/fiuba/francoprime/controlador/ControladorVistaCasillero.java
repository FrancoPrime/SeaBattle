package edu.fiuba.francoprime.controlador;

import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class ControladorVistaCasillero {
    private static ControladorVistaCasillero instancia;
    private Juego juego;
    private int rotacion;
    private boolean seRealizoJugada;

    private ControladorVistaCasillero(Juego juego){
        this.juego = juego;
        this.rotacion = Mapa.HORIZONTAL;
        this.seRealizoJugada = false;
    }

    public static void inicializar(Juego juego){
        instancia = new ControladorVistaCasillero(juego);
    }

    public static ControladorVistaCasillero obtenerInstancia(){
        return instancia;
    }

    public void realizarJugada(int fila, int columna){
        if(this.juego.faseActual() instanceof FaseColocacion){
            Jugada jugada = new JugadaColocar(fila, columna, this.rotacion);
            this.juego.realizarJugada(jugada);
            this.juego.notifyObservers();
            this.seRealizoJugada = false;
        }
        else if(!this.seRealizoJugada){
            Jugada jugada = new JugadaTocar(fila, columna);
            this.juego.realizarJugada(jugada);
            this.juego.notifyObservers();
            this.seRealizoJugada = true;
        }
    }

    public void seAvanzoElTurno(){
        this.seRealizoJugada = false;
    }

    public boolean sePuedeAvanzarElTurno(){
        return this.seRealizoJugada;
    }

    public void rotarBarco(){
        if(this.rotacion == Mapa.HORIZONTAL)
            this.rotacion = Mapa.VERTICAL;
        else
            this.rotacion = Mapa.HORIZONTAL;
    }

}
