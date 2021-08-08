package edu.fiuba.francoprime.modelo.mapa;

public class CeldaBarcoTocado implements Visibilidad{

    public boolean estaTocada() {
        return true;
    }

    public String nombreVisibilidad(){
        return "BarcoTocado";
    }

}
