package ru.vsu.cs.dplatov.vvp.task3.gnomesortapp;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.controller.Controller;
import ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.view.View;

import java.io.IOException;

public class GnomeSortApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View view = new View(stage);
        Controller controller = new Controller(view);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}