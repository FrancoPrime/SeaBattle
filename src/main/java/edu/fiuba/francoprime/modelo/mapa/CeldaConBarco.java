package edu.fiuba.francoprime.modelo.mapa;

import edu.fiuba.francoprime.modelo.jugador.Barco;

public class CeldaConBarco implements ContenidoCelda{
    Barco barcoContenido;

    public CeldaConBarco(Barco barco){
        this.barcoContenido = barco;
    }

    public void tocarCelda() {
        this.barcoContenido.tocar();
    }

    public boolean esAsignable(){
        return false;
    }

    public Visibilidad visibilidadAlTocar(){
        return new CeldaBarcoTocado();
    }
}
