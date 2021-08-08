package edu.fiuba.francoprime.controlador;

import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class ControladorVistaCasillero {
    private static ControladorVistaCasillero instancia;
    private Juego juego;

    private ControladorVistaCasillero(Juego juego){
        this.juego = juego;
    }

    public static void inicializar(Juego juego){
        instancia = new ControladorVistaCasillero(juego);
    }

    public static ControladorVistaCasillero obtenerInstancia(){
        return instancia;
    }

    public void realizarJugada(int fila, int columna){
        if(this.juego.faseActual() instanceof FaseColocacion){
            Jugada jugada = new JugadaColocar(fila, columna, Mapa.HORIZONTAL);
            this.juego.realizarJugada(jugada);
            this.juego.notifyObservers();
        }
        else{
            Jugada jugada = new JugadaTocar(fila, columna);
            this.juego.realizarJugada(jugada);
            this.juego.avanzarFase();
            this.juego.notifyObservers();
        }
    }

}
