package edu.fiuba.francoprime.modelo;

public class JugadaColocar implements Jugada{
    private int fila;
    private int columna;
    private int orientacion;


    public JugadaColocar(int fila, int columna, int orientacion){
        this.fila = fila;
        this.columna = columna;
        this.orientacion = orientacion;
    }

    public void ejecutar(Mapa mapa){
        mapa.coordenadasBarcoEnColocacion(this.fila, this.columna, this.orientacion);
    }

}
