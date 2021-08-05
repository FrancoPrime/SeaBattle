package edu.fiuba.francoprime.modelo.mapa;

import edu.fiuba.francoprime.modelo.jugador.Barco;

import java.util.ArrayList;

public class Mapa {

    public static final int MAXIMAS_FILAS_COLUMNAS = 10;
    private Celda[][] celdas;
    private Barco barcoEnColocacion;
    private ArrayList<Coordenada> coordenadasBarcoEnColocacion;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

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

    public void establecerBarcoEnColocacion(Barco barco){
        this.barcoEnColocacion = barco;
    }

    public void coordenadasBarcoEnColocacion(int posFila, int posColumna, int rotacion){
        this.coordenadasBarcoEnColocacion = new ArrayList<>();
        int tamanioBarco = this.barcoEnColocacion.tamanio();
        if(rotacion == Mapa.HORIZONTAL){
            for(int i=0; i<tamanioBarco;i++){
                this.coordenadasBarcoEnColocacion.add(new Coordenada(posFila, posColumna+i));
            }
        }else{
            for(int i=0; i<tamanioBarco;i++){
                this.coordenadasBarcoEnColocacion.add(new Coordenada(posFila+i, posColumna));
            }
        }
    }

    public void finalizarColocacion(){
        agregarBarco(this.barcoEnColocacion, this.coordenadasBarcoEnColocacion);
        this.barcoEnColocacion = null;
        this.coordenadasBarcoEnColocacion = null;
    }

}
