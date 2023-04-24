package com.example.qlsv;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;

public class QuanLySinhVien extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuanLySinhVien.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1150, 475);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

