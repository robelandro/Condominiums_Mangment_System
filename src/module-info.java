module Condominiums.Mangment.System {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.util;

    opens login;
    opens startUp;
}