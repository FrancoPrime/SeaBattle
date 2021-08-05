package edu.fiuba.francoprime.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapaTest {

    @Test
    public void test01seColocaUnBarcoDe1EspacioYSeTocaElBarco(){
        Barco barco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        coordenadas.add(coordenada1);
        mapa.agregarBarco(barco, coordenadas);
        mapa.realizarJugada(2,2);
        verify(barco, times(1)).tocar();
    }

    @Test
    public void test02seColocaUnBarcoDe5EspaciosYSeTocaElBarco4Veces(){
        Barco barco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        Coordenada coordenada2 = new Coordenada(3,2);
        Coordenada coordenada3 = new Coordenada(4,2);
        Coordenada coordenada4 = new Coordenada(5,2);
        Coordenada coordenada5 = new Coordenada(6,2);
        coordenadas.add(coordenada1);
        coordenadas.add(coordenada2);
        coordenadas.add(coordenada3);
        coordenadas.add(coordenada4);
        coordenadas.add(coordenada5);
        mapa.agregarBarco(barco, coordenadas);
        mapa.realizarJugada(2,2);
        mapa.realizarJugada(3,2);
        mapa.realizarJugada(4,2);
        mapa.realizarJugada(5,2);
        verify(barco, times(4)).tocar();
    }

    @Test
    public void test03seColocaUnBarcoDe2EspaciosYSeRealizanJugadasNingunaTocaAlBarco(){
        Barco barco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        Coordenada coordenada2 = new Coordenada(3,2);
        coordenadas.add(coordenada1);
        coordenadas.add(coordenada2);
        mapa.agregarBarco(barco, coordenadas);
        mapa.realizarJugada(4,2);
        mapa.realizarJugada(1,2);
        mapa.realizarJugada(2,3);
        verify(barco, times(0)).tocar();
    }

    @Test
    public void test04seIntentaColocarUnBarcoEnDosPosicionesRepetidasYLanzaExcepcion(){
        Barco barco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        Coordenada coordenada2 = new Coordenada(2,2);
        coordenadas.add(coordenada1);
        coordenadas.add(coordenada2);
        assertThrows(CeldaOcupadaException.class, () -> mapa.agregarBarco(barco, coordenadas));
    }

    @Test
    public void test05seIntentanColocarDosBarcosEnLaMismaPosicionYLanzaExcepcion(){
        Barco unBarco = mock(Barco.class);
        Barco otroBarco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        coordenadas.add(coordenada1);
        mapa.agregarBarco(unBarco, coordenadas);
        assertThrows(CeldaOcupadaException.class, () -> mapa.agregarBarco(otroBarco, coordenadas));
    }

    @Test
    public void test06seColocaUnBarcoEnElMapaYTieneLasCoordenadasEsperadas(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(3);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(0, 0, Mapa.HORIZONTAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,0);
        mapa.realizarJugada(0,1);
        mapa.realizarJugada(0,2);
        assertTrue(barco.estaDestruido());
    }

}
