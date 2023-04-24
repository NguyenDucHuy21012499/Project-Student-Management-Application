module com.example.qlsv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.qlsv to javafx.fxml;
    exports com.example.qlsv;
}