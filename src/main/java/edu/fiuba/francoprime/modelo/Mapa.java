package edu.fiuba.francoprime.modelo;

import java.util.ArrayList;

public class Mapa {

    public static final int MAXIMAS_FILAS_COLUMNAS = 10;
    Celda[][] celdas;

    public Mapa(){
        celdas = new Celda[MAXIMAS_FILAS_COLUMNAS][MAXIMAS_FILAS_COLUMNAS];
        for(int i=0; i<MAXIMAS_FILAS_COLUMNAS; i++){
            for(int j=0; j<MAXIMAS_FILAS_COLUMNAS; j++){
                celdas[i][j] = new Celda();
            }
        }
    }

    public void agregarBarco(Barco barco, ArrayList<Coordenada> coordenadas){
        for (Coordenada coordenada : coordenadas){
            int fila = coordenada.getFila();
            int columna = coordenada.getColumna();
            this.celdas[fila][columna].asignarABarco(barco);
        }
    }

    public void realizarJugada(int fila, int columna){
        this.celdas[fila][columna].tocarCelda();
    }

}
