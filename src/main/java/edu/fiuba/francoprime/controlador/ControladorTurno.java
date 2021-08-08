package edu.fiuba.francoprime.controlador;

import edu.fiuba.francoprime.modelo.flujoDeJuego.Juego;

public class ControladorTurno {
    private static ControladorTurno instancia;
    private Juego juego;

    private ControladorTurno(Juego juego){
        this.juego = juego;
    }

    public static void inicializar(Juego juego){
        instancia = new ControladorTurno(juego);
    }

    public static ControladorTurno obtenerInstancia(){
        return instancia;
    }

    public void finalizarColocacion(){
        this.juego.finalizarColocacion();
        this.juego.notifyObservers();
    }

    public void finalizarTurno(){
        ControladorVistaCasillero controladorVistaCasillero = ControladorVistaCasillero.obtenerInstancia();
        if(controladorVistaCasillero.sePuedeAvanzarElTurno()) {
            this.juego.avanzarFase();
            this.juego.notifyObservers();
            controladorVistaCasillero.seAvanzoElTurno();
        }
    }

}
