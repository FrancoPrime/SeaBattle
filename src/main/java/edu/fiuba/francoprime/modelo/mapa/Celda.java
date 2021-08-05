package edu.fiuba.francoprime.modelo.mapa;

import edu.fiuba.francoprime.modelo.jugador.Barco;

public class Celda {

    ContenidoCelda contenido;
    Visibilidad visibilidad;

    public Celda(){
        this.contenido = new CeldaSinBarco();
        this.visibilidad = new CeldaVisible();
    }

    public void tocarCelda(){
        if(this.visibilidad.estaTocada())
            throw new CeldaYaTocadaException();
        this.contenido.tocarCelda();
        this.visibilidad = new CeldaTocada();
    }

    public void asignarABarco(Barco barco){
        if(!this.contenido.esAsignable())
            throw new CeldaOcupadaException();
        this.contenido = new CeldaConBarco(barco);
    }
}
