package edu.fiuba.francoprime.modelo;

import edu.fiuba.francoprime.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisibilidadTest {

    @Test
    public void test01laVisibilidadAguaTocadaEstaTocada(){
        Visibilidad visibilidad = new CeldaAguaTocada();
        assertTrue(visibilidad.estaTocada());
    }

    @Test
    public void test02laVisibilidadBarcoTocadoEstaTocada(){
        Visibilidad visibilidad = new CeldaBarcoTocado();
        assertTrue(visibilidad.estaTocada());
    }

    @Test
    public void test03laVisibilidadBarcoVisibleNoEstaTocada(){
        Visibilidad visibilidad = new CeldaBarcoVisible();
        assertFalse(visibilidad.estaTocada());
    }

    @Test
    public void test04laVisibilidadNoVisibleNoEstaTocada(){
        Visibilidad visibilidad = new CeldaNoVisible();
        assertFalse(visibilidad.estaTocada());
    }

    @Test
    public void test05laVisibilidadNoVisibleRetornaSuNombreEsperado(){
        Visibilidad visibilidad = new CeldaNoVisible();
        assertEquals("NoVisible", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test06laVisibilidadBarcoVisibleRetornaSuNombreEsperado(){
        Visibilidad visibilidad = new CeldaBarcoVisible();
        assertEquals("Barco", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test07laVisibilidadAguaTocadaRetornaSuNombreEsperado(){
        Visibilidad visibilidad = new CeldaAguaTocada();
        assertEquals("AguaTocada", visibilidad.nombreVisibilidad());
    }

    @Test
    public void test08laVisibilidadBarcoTocadoRetornaSuNombreEsperado(){
        Visibilidad visibilidad = new CeldaBarcoTocado();
        assertEquals("BarcoTocado", visibilidad.nombreVisibilidad());
    }

}
