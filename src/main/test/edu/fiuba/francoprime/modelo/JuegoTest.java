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

}
