package edu.fiuba.francoprime.modelo;

public class Celda {

    ContenidoCelda contenido;
    Visibilidad visibilidad;

    public Celda(){
        this.contenido = new CeldaSinBarco();
        this.visibilidad = new CeldaVisible();
    }

    void tocarCelda(){
        if(this.visibilidad.estaTocada())
            throw new CeldaYaTocadaException();
        this.contenido.tocarCelda();
        this.visibilidad = new CeldaTocada();
    }

    void asignarABarco(Barco barco){
        if(!this.contenido.esAsignable())
            throw new CeldaOcupadaException();
        this.contenido = new CeldaConBarco(barco);
    }
}
