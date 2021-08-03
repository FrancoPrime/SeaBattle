package edu.fiuba.francoprime;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("Sea Battle");
            Pane hbox = new Pane();
            Scene scene = new Scene(hbox, 640, 480);
            FileInputStream input = new FileInputStream("./images/background.png");
            Image imageBackground = new Image(input);
            BackgroundImage backgroundimage = new BackgroundImage(imageBackground,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            Background background = new Background(backgroundimage);
            hbox.setBackground(background);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}