package edu.fiuba.francoprime.modelo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class JugadaTest {

    @Test
    public void test01unaJugadaTocarLlamaATocarLaCeldaPedida(){
        Mapa mapa = mock(Mapa.class);
        JugadaTocar jugada = new JugadaTocar(2,2);
        jugada.ejecutar(mapa);
        verify(mapa, times(1)).realizarJugada(2,2);
    }

}
