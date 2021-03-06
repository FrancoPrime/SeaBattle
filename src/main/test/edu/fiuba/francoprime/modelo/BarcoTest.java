package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.jugador.Barco;
import edu.fiuba.francoprime.modelo.jugador.BarcoYaDestuidoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {

    @Test
    public void test01seCreaUnBarcoDe5EspaciosSeTocaUnaVezYNoEstaDestruido(){
        Barco barco = new Barco(5);
        barco.tocar();
        assertFalse(barco.estaDestruido());
    }

    @Test
    public void test02seCreaUnBarcoDe5EspaciosSeToca5VecesYEstaDestruido(){
        Barco barco = new Barco(5);
        for(int i=0;i<5;i++) {
            barco.tocar();
        }
        assertTrue(barco.estaDestruido());
    }

    @Test
    public void test03seIntentaTocarUnBarcoDestruidoYLanzaExcepcion(){
        Barco barco = new Barco(1);
        barco.tocar();
        assertThrows(BarcoYaDestuidoException.class, barco::tocar);
    }

}
