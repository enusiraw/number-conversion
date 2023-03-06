package com.example.numberconversion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberConverterClient extends Application {
    public NumberConverterImp numberConverterImp;
    public String BinaryToDecimal(String binaryString) {
        int decimal = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return String.valueOf(decimal);
    }

    @Override
    public void start(Stage stage) {
        /*try{
            Registry registry = LocateRegistry.getRegistry("localhost",3333);
            NumberRemote numberRemote = (NumberRemote) registry.lookup("NumberServer");
            Naming.rebind("NumberRemote",numberRemote);
            numberConverterImp = (NumberConverterImp) registry.lookup("NumberServer");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }*/

        StackPane root = new StackPane();
        Button Binary, Decimal, Octal, Hexa;
        Binary = new Button("Binary");
        Decimal = new Button("Decimal");
        Octal = new Button("Octal");
        Hexa = new Button("Hexa");

        Binary.setLayoutX(200);
        Binary.setLayoutY(200);
        Binary.setPrefSize(100,50);

        Decimal.setLayoutX(200);
        Decimal.setLayoutY(400);
        Decimal.setPrefSize(100,50);

        Octal.setLayoutX(400);
        Octal.setLayoutY(200);
        Octal.setPrefSize(100,50);

        Hexa.setLayoutX(400);
        Hexa.setLayoutY(400);
        Hexa.setPrefSize(100,50);

        Pane pane = new Pane();
        pane.setPrefSize(1200,700);
        pane.getChildren().add(Binary);
        pane.getChildren().add(Decimal);
        pane.getChildren().add(Octal);
        pane.getChildren().add(Hexa);

        Image background = new Image("file:C:\\Users\\HP\\Documents\\Projects\\Java\\NumberConversion\\src\\images\\hoe.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1200, 700, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        pane.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(root, 1200, 700);
        root.getChildren().add(pane);
        stage.setScene(scene);
        stage.show();

        Binary.setOnAction(actionEvent -> {
            Button decimal,octal,hexa;
            TextField textField;
            Stage stage1 = new Stage();
            StackPane Binary_page= new StackPane();
            Scene scene1 = new Scene(Binary_page,1200,700);

            Pane pane_binary = new Pane();
            Image background1 = new Image("C:\\Users\\HP\\Documents\\Projects\\Java\\NumberConversion\\src\\images\\binary.jpg");
            BackgroundSize backgroundSize1 = new BackgroundSize(1200, 700, true, true, true, false);
            BackgroundImage backgroundImage1 = new BackgroundImage(background1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize1);

            textField = new TextField();
            textField.setLayoutX(320);
            textField.setLayoutY(300);
            textField.setPrefSize(350,50);
            pane_binary.getChildren().add(textField);

            decimal = new Button("To Decimal");
            decimal.setLayoutX(280);
            decimal.setLayoutY(400);
            decimal.setPrefSize(100,50);
            pane_binary.getChildren().add(decimal);

            octal = new Button("To Octal");
            octal.setLayoutX(450);
            octal.setLayoutY(400);
            octal.setPrefSize(100,50);
            pane_binary.getChildren().add(octal);

            hexa = new Button("TO Hexa");
            hexa.setLayoutX(620);
            hexa.setLayoutY(400);
            hexa.setPrefSize(100,50);
            pane_binary.getChildren().add(hexa);

            pane_binary.setBackground(new Background(backgroundImage1));
            Binary_page.getChildren().add(pane_binary);
            stage1.setScene(scene1);

            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("[01]*")) {
                    textField.setText(oldValue);
                }
            });



            decimal.setOnAction(actionEvent1 -> {
                String binary = textField.getText();
                textField.clear();
                if (binary != null && !binary.isEmpty()) {
                    int decimal_result = Integer.parseInt(BinaryToDecimal(binary));
                    String result = String.valueOf(decimal_result);
                    textField.setText(result);
                }
            });



            stage1.show();

        });

        Decimal.setOnAction(actionEvent -> {

        });

        Octal.setOnAction(actionEvent -> {

        });

    }


    public static void main(String[] args) {

        launch();
    }
}

