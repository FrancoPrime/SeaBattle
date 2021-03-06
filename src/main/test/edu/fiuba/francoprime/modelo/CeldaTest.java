package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.mapa.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CeldaTest {

    @Test
    public void test01seCreaUnaCeldaConBarcoYCuandoSeLaTocaEllaTocaAlBarco(){
        Barco barco = mock(Barco.class);
        Celda celda = new Celda();
        celda.asignarABarco(barco);
        celda.tocarCelda();
        verify(barco, times(1)).tocar();
    }

    @Test
    public void test02seIntentaTocarUnaCeldaDosVecesYLanzaExcepcion(){
        Barco barco = mock(Barco.class);
        Celda celda = new Celda();
        celda.asignarABarco(barco);
        celda.tocarCelda();
        assertThrows(CeldaYaTocadaException.class, celda::tocarCelda);
    }

    @Test
    public void test03laVisibilidadAlTocarDeUnaCeldaSinBarcoEsAguaTocada(){
        ContenidoCelda contenido = new CeldaSinBarco();
        Visibilidad visibilidadAlTocar = contenido.visibilidadAlTocar();
        assertTrue(visibilidadAlTocar instanceof CeldaAguaTocada);
    }

}
