package edu.fiuba.francoprime.modelo.mapa;

public class CeldaAguaTocada implements Visibilidad{

    public boolean estaTocada() {
        return true;
    }

    public String nombreVisibilidad(){
        return "AguaTocada";
    }

}
