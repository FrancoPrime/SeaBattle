package edu.fiuba.francoprime.vista;

import edu.fiuba.francoprime.controlador.ControladorVistaCasillero;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Juego;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import edu.fiuba.francoprime.modelo.mapa.Visibilidad;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class VistaCasillero extends StackPane implements Observer {

    private int fila;
    private int columna;
    private ImageView imagenCasillero;
    private HashMap<String, Image> imagenes;
    private Juego juego;

    public VistaCasillero(Juego juego, int fila, int columna) throws IOException {
        establecerParametrosIniciales(juego, fila, columna);
        inicializarImagenes();
        this.imagenCasillero = new ImageView(this.imagenes.get("NoVisible"));
        ControladorVistaCasillero controladorVistaCasillero = ControladorVistaCasillero.obtenerInstancia();
        this.imagenCasillero.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controladorVistaCasillero.realizarJugada(this.fila, this.columna);
        });
        this.getChildren().add(this.imagenCasillero);
    }

    private void inicializarImagenes() throws FileNotFoundException {
        this.imagenes = new HashMap<>();
        FileInputStream inputImagenBarco = new FileInputStream("./images/Barco.png");
        this.imagenes.put("Barco", new Image(inputImagenBarco));
        FileInputStream inputImagenBarcoTocado = new FileInputStream("./images/BarcoTocado.png");
        this.imagenes.put("BarcoTocado", new Image(inputImagenBarcoTocado));
        FileInputStream inputImagenAguaTocada = new FileInputStream("./images/AguaTocada.png");
        this.imagenes.put("AguaTocada", new Image(inputImagenAguaTocada));
        FileInputStream inputImagenNoVisible = new FileInputStream("./images/NoVisible.png");
        this.imagenes.put("NoVisible", new Image(inputImagenNoVisible));
    }

    private void establecerParametrosIniciales(Juego juego, int fila, int columna) {
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
        relocate(50+this.fila*52.8,22+this.columna*43);
    }

    @Override
    public void update(Observable o, Object arg) {
        Mapa mapaActual = this.juego.obtenerMapaActual();
        Visibilidad visibilidadCasilla = mapaActual.visibilidadCelda(this.fila, this.columna);
        actualizarVisibilidad(visibilidadCasilla);
    }

    private void actualizarVisibilidad(Visibilidad visibilidadCasilla){
        this.imagenCasillero.setImage(this.imagenes.get(visibilidadCasilla.nombreVisibilidad()));
    }
}
