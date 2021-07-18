package edu.fiuba.francoprime.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapaTest {

    @Test
    public void test01seCreaUnMapaSeColocaUnBarcoYSeTocaElBarco(){
        Barco barco = mock(Barco.class);
        Mapa mapa = new Mapa();
        ArrayList<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada1 = new Coordenada(2,2);
        coordenadas.add(coordenada1);
        mapa.agregarBarco(barco, coordenadas);
        mapa.realizarJugada(coordenada1);
        verify(barco, times(1)).tocar();
    }

}
