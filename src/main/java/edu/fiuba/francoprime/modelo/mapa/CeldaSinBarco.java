package edu.fiuba.francoprime.modelo.mapa;

public class CeldaSinBarco implements ContenidoCelda{

    public void tocarCelda() { }

    public boolean esAsignable(){
        return true;
    }

    public Visibilidad visibilidadAlTocar() {
        return new CeldaAguaTocada();
    }
}
