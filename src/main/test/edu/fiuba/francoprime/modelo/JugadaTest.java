package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.Jugada;
import edu.fiuba.francoprime.modelo.flujoDeJuego.JugadaColocar;
import edu.fiuba.francoprime.modelo.flujoDeJuego.JugadaConfirmarColocacion;
import edu.fiuba.francoprime.modelo.flujoDeJuego.JugadaTocar;
import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class JugadaTest {

    @Test
    public void test01unaJugadaTocarLlamaATocarLaCeldaPedida(){
        Mapa mapa = mock(Mapa.class);
        Jugada jugada = new JugadaTocar(2,2);
        jugada.ejecutar(mapa);
        verify(mapa, times(1)).realizarJugada(2,2);
    }

    @Test
    public void test02unaJugadaColocarLlamaAColocarEnLaCeldaPedida(){
        Jugada jugada = new JugadaColocar(1, 5, Mapa.HORIZONTAL);
        Mapa mapa = mock(Mapa.class);
        jugada.ejecutar(mapa);
        verify(mapa, times(1)).coordenadasBarcoEnColocacion(1,5, Mapa.HORIZONTAL);
    }

    @Test
    public void test03unaJugadaConfirmarColocacionEstableceElBarcoEnLaCeldaEsperada(){
        Jugada jugada = new JugadaConfirmarColocacion();
        Mapa mapa = mock(Mapa.class);
        jugada.ejecutar(mapa);
        verify(mapa, times(1)).finalizarColocacion();
    }

    @Test
    public void test04seRealizaUnaSerieDeJugadasElBarcoSeColocaYTocaCorrectamente(){
        Barco barco = new Barco(3);
        Jugada jugada = new JugadaColocar(2, 5, Mapa.HORIZONTAL);
        Mapa mapa = new Mapa();
        mapa.establecerBarcoEnColocacion(barco);
        jugada.ejecutar(mapa);
        jugada = new JugadaConfirmarColocacion();
        jugada.ejecutar(mapa);
        jugada = new JugadaTocar(2,6);
        jugada.ejecutar(mapa);
        assertEquals(2, barco.tamanio());
    }

}
