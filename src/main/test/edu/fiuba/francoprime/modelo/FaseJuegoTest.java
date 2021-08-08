package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class FaseJuegoTest {

    @Test
    public void test01FaseColocacionSeDevuelveASiMismaSiHayBarcosPorColocar(){
        Juego juego = mock(Juego.class);
        when(juego.cantidadAColocar()).thenReturn(2);
        FaseJuego fase = new FaseColocacion();
        assertTrue(fase.siguienteFase(juego) instanceof FaseColocacion);
    }

    @Test
    public void test02FaseColocacionSeDevuelveASiMismaSiAhoraElTurnoEsDelSegundoJugador(){
        Juego juego = mock(Juego.class);
        when(juego.cantidadAColocar()).thenReturn(2);
        when(juego.alFinalDeLaListaDeJugadores()).thenReturn(false);
        FaseJuego fase = new FaseColocacion();
        assertTrue(fase.siguienteFase(juego) instanceof FaseColocacion);
    }

    @Test
    public void test03FaseColocacionDevuelveFaseAtaqueSiAmbosJugadoresColocaronSusBarcos(){
        Juego juego = mock(Juego.class);
        when(juego.cantidadAColocar()).thenReturn(1);
        when(juego.alFinalDeLaListaDeJugadores()).thenReturn(true);
        FaseJuego fase = new FaseColocacion();
        assertTrue(fase.siguienteFase(juego) instanceof FaseAtaque);
    }

    @Test
    public void test04FaseAtaqueSiempreCambiaDeJugadorYSeDevuelveASiMisma(){
        Juego juego = mock(Juego.class);
        FaseJuego fase = new FaseAtaque();
        assertTrue(fase.siguienteFase(juego) instanceof FaseAtaque);
        verify(juego, times(1)).avanzarJugador();
    }

    @Test
    public void test05FaseJuegoTerminadoSiempreSeDevuelveASiMisma(){
        Juego juego = mock(Juego.class);
        FaseJuego fase = new FaseJuegoTerminado();
        assertTrue(fase.siguienteFase(juego) instanceof FaseJuegoTerminado);
    }

}
