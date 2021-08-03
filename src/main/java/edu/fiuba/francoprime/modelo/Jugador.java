package edu.fiuba.francoprime.modelo;

import java.util.ArrayList;

public class Jugador {

    ArrayList<Barco> barcos;
    Mapa mapaContrincante;

    public Jugador(){
    }

    public Mapa crearMapa(){
        return new Mapa();
    }

    public void asignarMapaDelContrincante(Mapa mapa){
        this.mapaContrincante = mapa;
    }

    public void realizarJugada(Jugada jugada){
        jugada.ejecutar(this.mapaContrincante);
    }

}
