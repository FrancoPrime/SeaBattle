package edu.fiuba.francoprime.modelo;

public class CeldaConBarco implements Celda{
    Barco barcoContenido;

    public CeldaConBarco(Barco barco){
        this.barcoContenido = barco;
    }

    public void tocarCelda() {
        this.barcoContenido.tocar();
    }
}
