package edu.fiuba.francoprime.modelo;

public class JugadaConfirmarColocacion implements Jugada{

    @Override
    public void ejecutar(Mapa mapa) {
        mapa.finalizarColocacion();
    }
}
