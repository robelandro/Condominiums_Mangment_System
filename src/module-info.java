module Condominiums.Mangment.System {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires com.jfoenix;
    requires fontawesomefx;


    opens login;
    opens startUp;
    opens dbUtil;
    opens helper.payment;
    opens helper.people;
    opens helper.physical;
    opens dashBoard;
    opens codeBackup;
}