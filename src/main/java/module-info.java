module com.phantomstormx._072java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.phantomstormx._072java to javafx.fxml;
    exports com.phantomstormx._072java;
}