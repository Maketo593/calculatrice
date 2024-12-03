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
        Insets insets = new Insets(10, 10, 10, 10);
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
        hBox789.setPadding(insets);

        HBox hBox456 = new HBox(20);
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button bMoins = new Button("-");
        b4.setMinSize(40, 40);
        b5.setMinSize(40, 40);
        b6.setMinSize(40, 40);
        bMoins.setMinSize(40, 40);
        hBox456.getChildren().addAll(b4, b5, b6, bMoins);
        hBox456.setPadding(insets);

        HBox hBox123 = new HBox(20);
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button bMult = new Button("*");
        b1.setMinSize(40, 40);
        b2.setMinSize(40, 40);
        b3.setMinSize(40, 40);
        bMult.setMinSize(40, 40);
        hBox123.getChildren().addAll(b1, b2, b3, bMult);
        hBox123.setPadding(insets);

        HBox hBox0 = new HBox(20);
        Button bPoint = new Button(".");
        Button b0 = new Button("0");
        Button bEgale = new Button("=");
        Button bCE = new Button("CE");
        bPoint.setMinSize(40, 40);
        b0.setMinSize(40, 40);
        bEgale.setMinSize(40, 40);
        bCE.setMinSize(40, 40);
        hBox0.getChildren().addAll(bPoint, b0, bEgale, bCE);
        hBox0.setPadding(insets);

        vBox.getChildren().addAll(tFScreen, hBox789, hBox456, hBox123, hBox0);
        scene = new Scene(vBox, 240, 360);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}