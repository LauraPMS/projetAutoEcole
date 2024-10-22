module sio.projetautoecole {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens sio.projetautoecole to javafx.fxml;
    exports sio.projetautoecole;
    exports sio.projetautoecole.controllers;
    opens sio.projetautoecole.controllers to javafx.fxml;
}