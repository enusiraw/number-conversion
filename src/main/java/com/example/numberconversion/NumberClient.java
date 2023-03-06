package com.example.numberconversion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberClient extends Application {


    @Override
    public void start(Stage primaryStage) {


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();


        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        Button button1 = new Button("Binary");
        Button button2 = new Button("Decimal");
        Button button3 = new Button("Octal");
        Button button4 = new Button("HexaDecimal");


        button1.setPrefSize(80, 50);
        button2.setPrefSize(80, 50);
        button3.setPrefSize(80, 50);
        button4.setPrefSize(80, 50);

        double buttonWidth = button1.getPrefWidth();
        double buttonHeight = button1.getPrefHeight();

        double centerX = screenWidth / 2 - buttonWidth / 2;
        double centerY = screenHeight / 2 - buttonHeight / 2;

        button1.setLayoutX(centerX);
        button1.setLayoutY(centerY - 100);
        button2.setLayoutX(centerX + 100);
        button2.setLayoutY(centerY);
        button3.setLayoutX(centerX - 100);
        button3.setLayoutY(centerY);
        button4.setLayoutX(centerX);
        button4.setLayoutY(centerY + 100);

        gridPane.add(button1, 0, 0);
        gridPane.add(button2, 1, 0);
        gridPane.add(button3, 0, 1);
        gridPane.add(button4, 1, 1);

        Image background = new Image("file:C:\\Users\\HP\\Documents\\Projects\\Java\\NumberConversion\\src\\images\\hoe.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(screenWidth, screenHeight, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        Pane pane = new Pane();
        pane.setBackground(new Background(backgroundImage));
        pane.getChildren().add(gridPane);
        Scene scene = new Scene(pane, screenWidth, screenHeight );

        primaryStage.setTitle("Number conversion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
