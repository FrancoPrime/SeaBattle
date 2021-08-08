package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.mapa.CeldaOcupadaException;
import edu.fiuba.francoprime.modelo.mapa.Coordenada;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import edu.fiuba.francoprime.modelo.mapa.Visibilidad;
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
    public void test06seColocaUnBarcoHorizontalmenteEnElMapaYTieneLasCoordenadasEsperadas(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(3);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(0, 7, Mapa.HORIZONTAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,7);
        mapa.realizarJugada(0,8);
        assertFalse(barco.estaDestruido());
        mapa.realizarJugada(0,9);
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test07seIntentaColocarUnBarcoHorizontalmenteEnElMapaEnPosicionIncorrectaYLoColocaAlPrincipio(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(3);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(0, 8, Mapa.HORIZONTAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,0);
        mapa.realizarJugada(0,1);
        assertFalse(barco.estaDestruido());
        mapa.realizarJugada(0,2);
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test08seIntentaColocarUnBarcoVerticalmenteEnElMapaYSeColocaEnLasCasillasEsperadas(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(4);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(0, 8, Mapa.VERTICAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,8);
        mapa.realizarJugada(1,8);
        mapa.realizarJugada(2,8);
        assertFalse(barco.estaDestruido());
        mapa.realizarJugada(3,8);
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test09seIntentaColocarUnBarcoVerticalmenteEnElMapaEnElMapaEnPosicionIncorrectaYLoColocaAlPrincipio(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(4);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(7, 8, Mapa.VERTICAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,0);
        mapa.realizarJugada(1,0);
        mapa.realizarJugada(2,0);
        assertFalse(barco.estaDestruido());
        mapa.realizarJugada(3,0);
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test09seIntentaColocarUnBarcoSolapandoAOtroYaColocadoYSeColocaEnLaPrimerPosicionValida(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(4);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(7, 2, Mapa.HORIZONTAL);
        mapa.finalizarColocacion();
        barco = new Barco(3);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(5, 2, Mapa.VERTICAL);
        mapa.finalizarColocacion();
        mapa.realizarJugada(0,0);
        mapa.realizarJugada(1,0);
        assertFalse(barco.estaDestruido());
        mapa.realizarJugada(2,0);
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test10sePideLaVisibilidadDeUnMapaVacioYDevuelveLaEsperada(){
        Mapa mapa = new Mapa();
        Visibilidad visibilidad = mapa.visibilidadCelda(2,2);
        assertEquals("NoVisible", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test11sePideLaVisibilidadDeUnMapaEnUnBarcoEnColocacionYDevuelveLaEsperada(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(4);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(2, 7, Mapa.VERTICAL);
        Visibilidad visibilidad = mapa.visibilidadCelda(4,7);
        assertEquals("Barco", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test12sePideLaVisibilidadDeUnMapaEnUnBarcoColocadoYDevuelveLaEsperada(){
        Mapa mapa = new Mapa();
        Barco barco = new Barco(4);
        mapa.establecerBarcoEnColocacion(barco);
        mapa.coordenadasBarcoEnColocacion(2, 7, Mapa.VERTICAL);
        mapa.finalizarColocacion();
        Visibilidad visibilidad = mapa.visibilidadCelda(4,7);
        assertEquals("Barco", visibilidad.nombreVisibilidad());
    }
}
