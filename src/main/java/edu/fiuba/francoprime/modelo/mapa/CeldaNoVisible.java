package edu.fiuba.francoprime.modelo.mapa;

public class CeldaNoVisible implements Visibilidad{

    public boolean estaTocada() {
        return true;
    }

    public String nombreVisibilidad(){
        return "NoVisible";
    }

}
