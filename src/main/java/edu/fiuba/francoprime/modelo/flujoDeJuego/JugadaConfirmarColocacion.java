package edu.fiuba.francoprime.modelo.flujoDeJuego;

import edu.fiuba.francoprime.modelo.mapa.Mapa;

public class JugadaConfirmarColocacion implements Jugada{

    @Override
    public void ejecutar(Mapa mapa) {
        mapa.finalizarColocacion();
    }
}
