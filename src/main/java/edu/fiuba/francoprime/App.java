package edu.fiuba.francoprime;

import edu.fiuba.francoprime.controlador.ControladorTurno;
import edu.fiuba.francoprime.controlador.ControladorVistaCasillero;
import edu.fiuba.francoprime.modelo.flujoDeJuego.Juego;
import edu.fiuba.francoprime.vista.VistaMapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    private void mostrarJuego(Stage stage) throws IOException {
        Juego juego = inicializarModelo();
        VistaMapa panelPrincipal = new VistaMapa(juego);
        juego.addObserver(panelPrincipal);
        Scene scene = new Scene(panelPrincipal, 640, 480);
        stage.setTitle("Sea Battle");
        stage.setScene(scene);
        stage.show();
    }

    private Juego inicializarModelo() {
        Juego juego = new Juego();
        ControladorVistaCasillero.inicializar(juego);
        ControladorTurno.inicializar(juego);
        return juego;
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