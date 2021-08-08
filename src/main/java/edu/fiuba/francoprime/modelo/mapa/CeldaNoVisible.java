package edu.fiuba.francoprime.modelo.mapa;

public class CeldaNoVisible implements Visibilidad{

    public boolean estaTocada() {
        return false;
    }

    public String nombreVisibilidad(){
        return "NoVisible";
    }

}
