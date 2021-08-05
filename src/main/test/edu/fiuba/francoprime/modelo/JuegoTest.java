package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
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
        jugada = new JugadaConfirmarColocacion();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaColocar(0,1,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaConfirmarColocacion();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaColocar(0,2,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaConfirmarColocacion();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaColocar(0,3,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaConfirmarColocacion();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
        jugada = new JugadaColocar(0,4,Mapa.VERTICAL);
        juego.realizarJugada(jugada);
        jugada = new JugadaConfirmarColocacion();
        juego.realizarJugada(jugada);
        juego.avanzarFase();
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

}
