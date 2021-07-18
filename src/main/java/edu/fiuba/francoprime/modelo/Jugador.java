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
        ArrayList<Object> jugada = this.controlador.obtenerJugada();
        if((int) jugada.get(0) == ControladorJugada.TOCAR){
            int fila = (int) jugada.get(1);
            int columna = (int) jugada.get(2);
            Coordenada coordenada = new Coordenada(fila, columna);
            this.mapaContrincante.realizarJugada(coordenada);
        }
    }

}
