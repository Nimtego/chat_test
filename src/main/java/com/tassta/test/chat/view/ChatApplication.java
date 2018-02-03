package com.tassta.test.chat.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.paint.Color.TRANSPARENT;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class ChatApplication extends Application {
    private double xOffset;
    private double yOffset;
    private Stage primaryStage;
    private AnchorPane anchorPane;


    public static void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
        initRootLayout();
    }


    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ChatApplication.class.getResource("/chat.fxml"));
            anchorPane = loader.load();
            ((MainWindowController) loader.getController()).setApplication(this);
            Scene scene = new Scene(anchorPane);

            movementWindowWithoutFrame(scene);
            scene.setFill(TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void movementWindowWithoutFrame(Scene scene) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


}