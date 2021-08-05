package edu.fiuba.francoprime.modelo;

public class JugadaEstablecerBarco implements Jugada{

    private Barco barco;

    public JugadaEstablecerBarco(Barco barco){
        this.barco = barco;
    }

    @Override
    public void ejecutar(Mapa mapa) {
        mapa.establecerBarcoEnColocacion(this.barco);
    }

}
