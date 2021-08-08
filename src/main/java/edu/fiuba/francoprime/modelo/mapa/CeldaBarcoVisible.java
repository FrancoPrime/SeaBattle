package edu.fiuba.francoprime.modelo.mapa;

public class CeldaBarcoVisible implements Visibilidad{

    public boolean estaTocada() {
        return false;
    }

    public String nombreVisibilidad(){
        return "Barco";
    }
}
