package edu.fiuba.francoprime.modelo.mapa;

import edu.fiuba.francoprime.modelo.jugador.Barco;

public class Celda {

    ContenidoCelda contenido;
    Visibilidad visibilidad;

    public Celda(){
        this.contenido = new CeldaSinBarco();
        this.visibilidad = new CeldaNoVisible();
    }

    public void tocarCelda(){
        if(this.visibilidad.estaTocada())
            throw new CeldaYaTocadaException();
        this.contenido.tocarCelda();
        this.visibilidad = this.contenido.visibilidadAlTocar();
    }

    public void asignarABarco(Barco barco){
        if(!this.contenido.esAsignable())
            throw new CeldaOcupadaException();
        this.contenido = new CeldaConBarco(barco);
        this.visibilidad = new CeldaBarcoVisible();
    }

    public boolean esAsignable(){
        return this.contenido.esAsignable();
    }

    public void invisibilizar(){
        this.visibilidad = new CeldaNoVisible();
    }
}
