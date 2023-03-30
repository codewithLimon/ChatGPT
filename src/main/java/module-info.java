module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;
    requires annotations;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}