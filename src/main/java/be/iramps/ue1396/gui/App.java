package be.iramps.ue1396.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    String op = null;
    double n1 = 0;
    double n2 = 0;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Calcul v0.2");
        Insets insets = new Insets(10, 10, 10, 10);
        VBox vBox = new VBox(20);

        TextField tFScreen = new TextField("");
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
        bPlus.setDisable(true);
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
        bMoins.setDisable(true);
        hBox456.getChildren().addAll(b4, b5, b6, bMoins);
        hBox456.setPadding(insets);

        HBox hBox123 = new HBox(20);
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button bMult = new Button("*");
        bMult.setDisable(true);
        b1.setMinSize(40, 40);
        b2.setMinSize(40, 40);
        b3.setMinSize(40, 40);
        bMult.setMinSize(40, 40);
        hBox123.getChildren().addAll(b1, b2, b3, bMult);
        hBox123.setPadding(insets);

        HBox hBox0 = new HBox(20);
        Button bPoint = new Button(".");
        Button b0 = new Button("0");
        Button bCE = new Button("CE");
        Button bDiv = new Button("/");
        bPoint.setMinSize(40, 40);
        b0.setMinSize(40, 40);
        bCE.setMinSize(40, 40);
        bDiv.setMinSize(40, 40);
        b0.setDisable(true);
        bCE.setDisable(true);
        bDiv.setDisable(true);
        hBox0.getChildren().addAll(bPoint, b0, bCE, bDiv);
        hBox0.setPadding(insets);

        HBox hBoxEgal = new HBox(20);
        Button bPlusMoins = new Button("+/-");
        Button bEgal = new Button("=");
        bPlusMoins.setMinSize(40, 40);
        bEgal.setMinSize(160, 40);
        hBoxEgal.getChildren().addAll(bPlusMoins, bEgal);
        bEgal.setDisable(true);
        hBoxEgal.setPadding(insets);


        /**
         * Opérations
         */
        bPlusMoins.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getText().isEmpty() || (!tFScreen.getText().isEmpty() && !tFScreen.getText().contains("-"))) {
                    tFScreen.setText("-" + tFScreen.getText());
                }
                else if (!tFScreen.getText().isEmpty() && tFScreen.getText().contains("-")) {
                    tFScreen.setText(tFScreen.getText().substring(1));
                }
                bCE.setDisable(false);
            }
        });

        bPoint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getText().isEmpty()) {
                    tFScreen.setText("0.");
                } else if (tFScreen.getLength() == 1 && tFScreen.getText().contains("-")) {
                    tFScreen.setText("-0.");
                } else {
                    tFScreen.setText(tFScreen.getText() + ".");
                }

                bPoint.setDisable(true);
                b0.setDisable(false);
                bPlus.setDisable(false);
                bMoins.setDisable(false);
                bMult.setDisable(false);
                bDiv.setDisable(false);
                bCE.setDisable(false);
                bEgal.setDisable(false);
            }
        });

        bEgal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double result = 0;
                Boolean estDecimal = false;
                if (op == null) {
                    result = Double.parseDouble(tFScreen.getText());
                    estDecimal = result % 1 == 0;
                    if(estDecimal) {
                        tFScreen.setText(Integer.toString((int)result));
                        bPoint.setDisable(false);
                    } else tFScreen.setText(Double.toString(result));
                }
                bEgal.setDisable(true);
            }
        });

        bCE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                op = null;
                n1 = 0;
                n2 = 0;
                tFScreen.setText("");
                bPlus.setDisable(true);
                bMoins.setDisable(true);
                bMult.setDisable(true);
                bDiv.setDisable(true);
                bPoint.setDisable(false);
                b0.setDisable(true);
                bCE.setDisable(true);
                bEgal.setDisable(true);
            }
        });

        /**
         * Nombres
         */

        b0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tFScreen.setText(tFScreen.getText() + "0");
            }
        });

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "1");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "2");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });
        
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "3");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "4");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "5");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "6");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "7");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "8");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        b9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tFScreen.getLength() >= 0) {
                    tFScreen.setText(tFScreen.getText() + "9");
                    bPlus.setDisable(false);
                    bMoins.setDisable(false);
                    bMult.setDisable(false);
                    bDiv.setDisable(false);
                    b0.setDisable(false);
                    bCE.setDisable(false);
                    bEgal.setDisable(false);
                    if (!tFScreen.getText().contains(".")) {
                        bPoint.setDisable(false);
                    }
                }
            }
        });

        vBox.getChildren().addAll(tFScreen, hBox789, hBox456, hBox123, hBox0, hBoxEgal);
        scene = new Scene(vBox, 240, 440);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}