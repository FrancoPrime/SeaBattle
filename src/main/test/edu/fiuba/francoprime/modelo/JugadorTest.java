package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.JugadaTocar;
import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.mapa.Coordenada;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class JugadorTest {

    @Test
    public void test01elJugadorRealizaLaJugadaTocarCorrectamente(){
        JugadaTocar jugada = new JugadaTocar(2,2);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> listaCoordenadas = new ArrayList<>();
        Coordenada coordenada = new Coordenada(2,2);
        listaCoordenadas.add(coordenada);
        Barco barco = new Barco(1);
        mapa.agregarBarco(barco, listaCoordenadas);
        Jugador jugador = new Jugador();
        jugador.asignarMapaDelContrincante(mapa);
        jugador.realizarJugada(jugada);
        assertTrue(barco.estaDestruido());
    }

}
