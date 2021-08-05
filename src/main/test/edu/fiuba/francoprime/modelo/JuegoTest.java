package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.FaseColocacion;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Juego;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Jugada;
import edu.fiuba.francoprime.modelo.flujoDeJuego.JugadaColocar;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class JuegoTest {

    @Test
    public void test01unJuegoIniciaYSeEncuentraEnFaseDeColocacion(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        assertTrue(juego.faseActual() instanceof FaseColocacion);
    }

    @Test
    public void test02unJuegoIniciaYElTurnoEsDelPrimerJugador(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        assertEquals(1, juego.jugadorActual().identificador());
    }

    @Test
    public void test03luegoDeColocar5BarcosLaFaseEsDeColocacion(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        Jugada jugada = new JugadaColocar(0,0, Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,1,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,2,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,3,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,4,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        assertTrue(juego.faseActual() instanceof FaseColocacion);
    }

    @Test
    public void test04luegoDeColocar5BarcosElTurnoEsDelSegundoJugador(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        Jugada jugada = new JugadaColocar(0,0,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,1,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,2,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,3,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaColocar(0,4,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        assertEquals(2, juego.jugadorActual().identificador());
    }

}
