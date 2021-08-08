package edu.fiuba.francoprime.vista;

import edu.fiuba.francoprime.controlador.ControladorTurno;
import edu.fiuba.francoprime.controlador.ControladorVistaCasillero;
import edu.fiuba.francoprime.modelo.flujoDeJuego.*;
import edu.fiuba.francoprime.modelo.jugador.Jugador;
import edu.fiuba.francoprime.modelo.mapa.Mapa;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VistaMapa extends Pane implements Observer {

    private ImageView interfazJuegoTerminado;
    private Button botonSiguienteTurno;
    private Button botonConfirmarColocacion;
    private Button botonRotarBarco;
    private Label etiquetaTurnoJugador;
    private Label etiquetaJuegoTerminado;
    private Juego juego;

    public VistaMapa(Juego juego) throws IOException{
        this.juego = juego;
        inicializarBackground();
        agregarVistasCasillero();
        inicializarBotones();
        inicializarInterfazJuegoTerminado();
        inicializarEtiquetas();
    }

    private void inicializarEtiquetas() {
        inicializarEtiquetaTurnoJugador();
        inicializarEtiquetaJuegoTerminado();
    }

    private void inicializarBotones() {
        inicializarBotonSiguienteTurno();
        inicializarBotonConfirmarColocacion();
        inicializarBotonRotarBarco();
    }

    private void inicializarEtiquetaTurnoJugador(){
        this.etiquetaTurnoJugador = new Label("Turno del jugador 1");
        this.etiquetaTurnoJugador.relocate(300, 0);
        this.getChildren().add(this.etiquetaTurnoJugador);
    }

    private void inicializarEtiquetaJuegoTerminado(){
        this.etiquetaJuegoTerminado = new Label("Ganador: jugador X");
        this.etiquetaJuegoTerminado.relocate(300, 300);
        this.getChildren().add(this.etiquetaJuegoTerminado);
        this.etiquetaJuegoTerminado.setVisible(false);
    }

    private void inicializarInterfazJuegoTerminado() throws IOException{
        FileInputStream inputInterfaz = new FileInputStream("./images/interfazJuegoTerminado.png");
        this.interfazJuegoTerminado = new ImageView(new Image(inputInterfaz));
        this.interfazJuegoTerminado.relocate(200, 200);
        this.getChildren().add(this.interfazJuegoTerminado);
        this.interfazJuegoTerminado.setVisible(false);
    }

    private void inicializarBotonSiguienteTurno() {
        this.botonSiguienteTurno = new Button("Avanzar Turno");
        this.botonSiguienteTurno.relocate(300, 455);
        ControladorTurno controladorTurno = ControladorTurno.obtenerInstancia();
        this.botonSiguienteTurno.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controladorTurno.finalizarTurno();
        });
        this.botonSiguienteTurno.setVisible(false);
        this.getChildren().add(this.botonSiguienteTurno);
    }

    private void inicializarBotonConfirmarColocacion() {
        this.botonConfirmarColocacion = new Button("Confirmar colocacion");
        ControladorTurno controladorTurno = ControladorTurno.obtenerInstancia();
        this.botonConfirmarColocacion.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controladorTurno.finalizarColocacion();
        });
        this.botonConfirmarColocacion.relocate(450, 455);
        this.getChildren().add(this.botonConfirmarColocacion);
    }

    private void inicializarBotonRotarBarco() {
        this.botonRotarBarco = new Button("Rotar");
        ControladorVistaCasillero controladorCasillero = ControladorVistaCasillero.obtenerInstancia();
        this.botonRotarBarco.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controladorCasillero.rotarBarco();
        });
        this.botonRotarBarco.relocate(200, 455);
        this.getChildren().add(this.botonRotarBarco);
    }

    private void inicializarBackground() throws FileNotFoundException {
        FileInputStream inputBackground = new FileInputStream("./images/background.png");
        BackgroundImage backgroundimage = new BackgroundImage(new Image(inputBackground),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);
        this.setBackground(background);
    }

    private void agregarVistasCasillero() throws IOException {
        for(int i = 0; i < Mapa.MAXIMAS_FILAS_COLUMNAS; i++){
            for(int j=0; j < Mapa.MAXIMAS_FILAS_COLUMNAS; j++){
                agregarVistaCasillero(i, j);
            }
        }
    }

    private void agregarVistaCasillero(int i, int j) throws IOException {
        VistaCasillero nuevaVista = new VistaCasillero(this.juego, j, i);
        this.juego.addObserver(nuevaVista);
        this.getChildren().add(nuevaVista);
    }

    @Override
    public void update(Observable o, Object arg) {
        FaseJuego faseActual = this.juego.faseActual();
        this.botonConfirmarColocacion.setVisible(false);
        this.botonSiguienteTurno.setVisible(false);
        this.botonRotarBarco.setVisible(false);
        if(faseActual instanceof FaseColocacion) {
            this.botonConfirmarColocacion.setVisible(true);
            this.botonRotarBarco.setVisible(true);
        }
        if(faseActual instanceof FaseAtaque)
            this.botonSiguienteTurno.setVisible(true);
        if(faseActual instanceof FaseJuegoTerminado) {
            Jugador jugadorGanador = this.juego.jugadorGanador();
            this.interfazJuegoTerminado.setVisible(true);
            this.etiquetaJuegoTerminado.setVisible(true);
            this.etiquetaTurnoJugador.setText("Ganador: Jugador " + jugadorGanador.identificador());
            this.etiquetaTurnoJugador.setVisible(false);
        }
        actualizarJugadorActual();
    }

    private void actualizarJugadorActual(){
        Jugador jugadorActual = this.juego.jugadorActual();
        int numeroJugadorActual = jugadorActual.identificador();
        this.etiquetaTurnoJugador.setText("Turno del jugador " + numeroJugadorActual);
    }
}
