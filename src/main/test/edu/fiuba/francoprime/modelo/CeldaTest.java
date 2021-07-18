package edu.fiuba.francoprime.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CeldaTest {

    @Test
    public void test01seCreaUnaCeldaConBarcoYCuandoSeLaTocaEllaTocaAlBarco(){
        Barco barco = mock(Barco.class);
        CeldaConBarco celda = new CeldaConBarco(barco);
        celda.tocarCelda();
        verify(barco, times(1)).tocar();
    }

}
