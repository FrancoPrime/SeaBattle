package edu.fiuba.francoprime.modelo.jugador;

import edu.fiuba.francoprime.modelo.flujoDeJuego.Jugada;
import edu.fiuba.francoprime.modelo.mapa.Mapa;

import java.util.ArrayList;

public class Jugador {

    private ArrayList<Barco> barcos;
    private Mapa mapaContrincante;
    private int identificador;
    private static int identificadorJugadores = 1;

    public Jugador(){
        this.identificador = identificadorJugadores;
        identificadorJugadores++;
        this.mapaContrincante = new Mapa();
    }

    public static void reiniciarClase(){
        identificadorJugadores = 1;
    }

    public void asignarMapaDelContrincante(Mapa mapa){
        this.mapaContrincante = mapa;
    }

    public void realizarJugada(Jugada jugada){
        jugada.ejecutar(this.mapaContrincante);
    }

    public Mapa obtenerMapa(){
        return this.mapaContrincante;
    }

    public int identificador(){
        return this.identificador;
    }

}
