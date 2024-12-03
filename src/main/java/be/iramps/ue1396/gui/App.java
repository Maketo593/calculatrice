package be.iramps.ue1396.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        VBox vBox = new VBox(20);
        TextField tFScreen = new TextField("Entrez Chiffre");
        tFScreen.setDisable(true);
        HBox hBox789 = new HBox(20);
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button bPlus = new Button("+");
        b7.setMinSize(40, 40);
        b8.setMinSize(40, 40);
        b9.setMinSize(40, 40);
        bPlus.setMinSize(40, 40);
        hBox789.getChildren().addAll(b7, b8, b9, bPlus);
        Insets insets = new Insets(20, 20, 20, 20);
        hBox789.setPadding(insets);
        vBox.getChildren().addAll(tFScreen, hBox789);
        scene = new Scene(vBox, 260, 220);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}