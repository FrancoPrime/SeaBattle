package edu.fiuba.francoprime.controlador;

import edu.fiuba.francoprime.modelo.Jugada;
import edu.fiuba.francoprime.modelo.JugadaTocar;

public class ControladorJugada {

    public static final int TOCAR = 1;

    public Jugada obtenerJugada(){
        return new JugadaTocar(2,2);
    }

}
