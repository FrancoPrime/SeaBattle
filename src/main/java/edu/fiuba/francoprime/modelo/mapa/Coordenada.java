package edu.fiuba.francoprime.modelo.mapa;

public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }
}
