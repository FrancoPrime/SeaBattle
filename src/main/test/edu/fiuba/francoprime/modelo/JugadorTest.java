package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.controlador.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class JugadorTest {

    @Test
    public void test01elJugadorRealizaLaJugadaTocarCorrectamente(){
        ControladorJugada controlador = mock(ControladorJugada.class);
        ArrayList<Object> jugada = new ArrayList<>();
        jugada.add(ControladorJugada.TOCAR);
        jugada.add(2);
        jugada.add(2);
        when(controlador.obtenerJugada()).thenReturn(jugada);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> listaCoordenadas = new ArrayList<>();
        Coordenada coordenada = new Coordenada(2,2);
        listaCoordenadas.add(coordenada);
        Barco barco = new Barco(1);
        mapa.agregarBarco(barco, listaCoordenadas);
        Jugador jugador = new Jugador(controlador);
        jugador.asignarMapaDelContrincante(mapa);
        jugador.realizarJugada();
        assertTrue(barco.estaDestruido());
    }

}
