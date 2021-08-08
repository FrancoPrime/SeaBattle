package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import edu.fiuba.francoprime.modelo.mapa.Visibilidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    public void colocacionDeBarcosEstandar(Juego juego){
        Jugada jugada = new JugadaColocar(0,0, Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
        jugada = new JugadaColocar(0,1,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
        jugada = new JugadaColocar(0,2,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
        jugada = new JugadaColocar(0,3,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
        jugada = new JugadaColocar(0,4,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
    }

    @Test
    public void test03luegoDeColocar5BarcosLaFaseEsDeColocacion(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        assertTrue(juego.faseActual() instanceof FaseColocacion);
    }

    @Test
    public void test04luegoDeColocar5BarcosElTurnoEsDelSegundoJugador(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        assertEquals(2, juego.jugadorActual().identificador());
    }

    @Test
    public void test05luegoDeColocar10BarcosElTurnoEsDelPrimerJugadorYLaFaseEsDeAtaque(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        assertEquals(1, juego.jugadorActual().identificador());
        assertTrue(juego.faseActual() instanceof FaseAtaque);
    }

    @Test
    public void test06enFaseAtaqueSeRealizaUnToqueYElTurnoPasaAlSegundoJugador(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        Jugada jugada = new JugadaTocar(0,0);
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        assertEquals(2, juego.jugadorActual().identificador());
        assertTrue(juego.faseActual() instanceof FaseAtaque);
    }

    @Test
    public void test07enFaseColocacionSeRealizaUnaColocacionYElBarcoEstaDondeSeEspera(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        Jugada jugada = new JugadaColocar(0,0, Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        juego.finalizarColocacion();
        Mapa mapaActual = juego.obtenerMapaActual();
        Visibilidad visibilidad = mapaActual.visibilidadCelda(1,0);
        assertEquals("Barco", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test08enFaseAtaqueSeRealizaUnToqueYElBarcoEsTocado(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        Jugada jugada = new JugadaTocar(0,0);
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        Mapa mapaActual = juego.obtenerMapaActual();
        Visibilidad visibilidad = mapaActual.visibilidadCelda(0,0);
        assertEquals(1, juego.jugadorActual().identificador());
        assertEquals("BarcoTocado", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test09seTocanTodosLosBarcosDeUnJugadorYLaFaseDeJuegoEsTerminado(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < (5-j); i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        for(int j = 3; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        assertTrue(juego.faseActual() instanceof FaseJuegoTerminado);
    }

    @Test
    public void test10seTocanTodosLosBarcosDelJugador2YElGanadorEsEl1(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < (5-j); i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        for(int j = 3; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        assertEquals(1, juego.jugadorGanador().identificador());
    }

    @Test
    public void test11seTocanTodosLosBarcosDelJugador1YElGanadorEsEl2(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < (5-j); i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        for(int j = 3; j < 5; j++) {
            for (int i = 0; i < 1; i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        Jugada jugada = new JugadaTocar(1, 3);
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaTocar(1, 7);
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaTocar(1, 4);
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        assertEquals(2, juego.jugadorGanador().identificador());
    }

    @Test
    public void test12ningunJugadorGanoPorLoQueNoHayGanador(){
        Jugador.reiniciarClase();
        Juego juego = new Juego();
        colocacionDeBarcosEstandar(juego);
        colocacionDeBarcosEstandar(juego);
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < (5-j); i++) {
                Jugada jugada = new JugadaTocar(i, j);
                juego.realizarJugada(jugada);
                juego.avanzarFase();
                juego.realizarJugada(jugada);
                juego.avanzarFase();
            }
        }
        assertTrue(juego.jugadorGanador() == null);
    }
}
