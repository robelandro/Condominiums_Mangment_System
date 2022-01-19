module Condominiums.Mangment.System {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens login;
    opens startUp;
    opens dbUtil;
    opens helper;
    opens management;
}