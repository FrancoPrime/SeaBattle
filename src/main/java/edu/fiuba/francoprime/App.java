package edu.fiuba.francoprime;

import edu.fiuba.francoprime.controlador.ControladorVistaCasillero;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Juego;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Jugada;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import edu.fiuba.francoprime.vista.VistaCasillero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application {

    private Juego juego;

    private void mostrarJuego(Stage stage) throws IOException {
        stage.setTitle("Sea Battle");
        Pane panelPrincipal = inicializarPanelPrincipal();
        this.juego = new Juego();
        ControladorVistaCasillero.inicializar(this.juego);
        for(int i=0; i < Mapa.MAXIMAS_FILAS_COLUMNAS; i++){
            for(int j=0; j < Mapa.MAXIMAS_FILAS_COLUMNAS; j++){
                VistaCasillero nuevaVista = new VistaCasillero(this.juego, i, j);
                juego.addObserver(nuevaVista);
                panelPrincipal.getChildren().add(nuevaVista);
            }
        }
        Button botonConfirmarColocacion = new Button("Confirmar colocacion");
        botonConfirmarColocacion.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            this.juego.finalizarColocacion();
            this.juego.notifyObservers();
        });
        botonConfirmarColocacion.relocate(450, 455);
        panelPrincipal.getChildren().add(botonConfirmarColocacion);
        Scene scene = new Scene(panelPrincipal, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private Pane inicializarPanelPrincipal() throws IOException {
        Pane hbox = new Pane();
        inicializarBackground(hbox);
        return hbox;
    }

    private void inicializarBackground(Pane hbox) throws FileNotFoundException {
        FileInputStream inputBackground = new FileInputStream("./images/background.png");
        BackgroundImage backgroundimage = new BackgroundImage(new Image(inputBackground),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);
        hbox.setBackground(background);
    }

    @Override
    public void start(Stage stage) {
        try {
            mostrarJuego(stage);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}