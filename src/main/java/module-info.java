module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires transitive javafx.graphics;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;

    opens com.example to javafx.fxml;
    opens com.infinitytech.ecommerce to spring.core, spring.beans, spring.context;

    exports com.example;
    exports com.infinitytech.ecommerce;
}
