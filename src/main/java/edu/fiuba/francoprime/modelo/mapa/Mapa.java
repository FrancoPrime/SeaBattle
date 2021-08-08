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
        this.coordenadasBarcoEnColocacion = new ArrayList<>();
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
        asignarBarcoAPrimeraPosicionValidaHorizontal(barco.tamanio());
    }

    public void coordenadasBarcoEnColocacion(int posFila, int posColumna, int rotacion){
        int tamanioBarco = this.barcoEnColocacion.tamanio();
        if(rotacion == Mapa.HORIZONTAL){
            colocarBarcoHorizontalmente(posFila, posColumna, tamanioBarco);
        }else{
            colocarBarcoVerticalmente(posFila, posColumna, tamanioBarco);
        }
        if(barcoEnColocacionPosicionInvalida())
            asignarBarcoAPrimeraPosicionValidaHorizontal(tamanioBarco);
    }

    private void colocarBarcoVerticalmente(int posFila, int posColumna, int tamanioBarco) {
        if(posFila+tamanioBarco > Mapa.MAXIMAS_FILAS_COLUMNAS){
            asignarBarcoAPrimeraPosicionValidaVertical(tamanioBarco);
            return;
        }
        asignarCoordenadasDeColocacionVerticalmente(posFila, posColumna, tamanioBarco);
    }

    private void asignarCoordenadasDeColocacionVerticalmente(int posFila, int posColumna, int tamanioBarco) {
        this.coordenadasBarcoEnColocacion = new ArrayList<>();
        for(int i = 0; i< tamanioBarco; i++){
            this.coordenadasBarcoEnColocacion.add(new Coordenada(posFila + i, posColumna));
        }
    }

    private boolean barcoEnColocacionPosicionInvalida(){
        boolean posicionValida = true;
        for(int i=0; i < this.coordenadasBarcoEnColocacion.size(); i++){
            int posicionFila = this.coordenadasBarcoEnColocacion.get(i).getFila();
            int posicionColumna = this.coordenadasBarcoEnColocacion.get(i).getColumna();
            if(!this.celdas[posicionFila][posicionColumna].esAsignable()){
                posicionValida = false;
            }
        }
        return (!posicionValida);
    }

    private void colocarBarcoHorizontalmente(int posFila, int posColumna, int tamanioBarco) {
        if(posColumna+tamanioBarco > Mapa.MAXIMAS_FILAS_COLUMNAS){
            asignarBarcoAPrimeraPosicionValidaHorizontal(tamanioBarco);
            return;
        }
        asignarCoordenadasDeColocacionHorizontalmente(posFila, posColumna, tamanioBarco);
    }

    private void asignarCoordenadasDeColocacionHorizontalmente(int posFila, int posColumna, int tamanioBarco) {
        this.coordenadasBarcoEnColocacion = new ArrayList<>();
        for(int i = 0; i< tamanioBarco; i++){
            this.coordenadasBarcoEnColocacion.add(new Coordenada(posFila, posColumna +i));
        }
    }

    private void asignarBarcoAPrimeraPosicionValidaVertical(int tamanioBarco){
        int i=0;
        int j=0;
        boolean colocado = false;
        while(i+tamanioBarco < Mapa.MAXIMAS_FILAS_COLUMNAS && !colocado){
            while(j < Mapa.MAXIMAS_FILAS_COLUMNAS && !colocado){
                asignarCoordenadasDeColocacionVerticalmente(i, j, tamanioBarco);
                if(!barcoEnColocacionPosicionInvalida())
                    colocado = true;
                j++;
            }
            i++;
        }
    }

    private void asignarBarcoAPrimeraPosicionValidaHorizontal(int tamanioBarco){
        int i=0, j=0;
        boolean colocado = false;
        while(i < Mapa.MAXIMAS_FILAS_COLUMNAS && !colocado){
            while(j+tamanioBarco < Mapa.MAXIMAS_FILAS_COLUMNAS && !colocado){
                asignarCoordenadasDeColocacionHorizontalmente(i, j, tamanioBarco);
                if(!barcoEnColocacionPosicionInvalida())
                    colocado = true;
                j++;
            }
            i++;
        }
    }

    public void finalizarColocacion(){
        agregarBarco(this.barcoEnColocacion, this.coordenadasBarcoEnColocacion);
        this.barcoEnColocacion = null;
        this.coordenadasBarcoEnColocacion = new ArrayList<>();
    }

    public Visibilidad visibilidadCelda(int fila, int columna){
        if(estaColocandose(fila, columna))
            return new CeldaBarcoVisible();
        return this.celdas[fila][columna].visibilidad;
    }
    
    private boolean estaColocandose(int fila, int columna){
        for(int i=0;i<this.coordenadasBarcoEnColocacion.size();i++){
            Coordenada coordenadaActual = this.coordenadasBarcoEnColocacion.get(i);
            if(coordenadaActual.getColumna() == columna && coordenadaActual.getFila() == fila)
                return true;
        }
        return false;
    }

    public void invisibilizar(){
        for(int i=0; i<Mapa.MAXIMAS_FILAS_COLUMNAS; i++) {
            for (int j = 0; j < Mapa.MAXIMAS_FILAS_COLUMNAS; j++) {
                this.celdas[i][j].invisibilizar();
            }
        }
    }

}
