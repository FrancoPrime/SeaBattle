package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.controlador.ControladorJugada;

import java.util.ArrayList;

public class Jugador {

    ArrayList<Barco> barcos;
    Mapa mapaContrincante;
    ControladorJugada controlador;

    public Jugador(ControladorJugada controlador){
        this.controlador = controlador;
    }

    public Mapa crearMapa(){
        return new Mapa();
    }

    public void asignarMapaDelContrincante(Mapa mapa){
        this.mapaContrincante = mapa;
    }

    public void realizarJugada(){
        Jugada jugada = this.controlador.obtenerJugada();
        jugada.ejecutar(this.mapaContrincante);
    }

}
