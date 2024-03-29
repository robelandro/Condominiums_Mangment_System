module CMS {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires com.jfoenix;
    requires fontawesomefx;
    requires org.apache.derby.tools;
    requires org.apache.derby.client;
    requires org.apache.derby.engine;
    requires org.apache.derby.server;
    requires org.apache.derby.commons;


    opens login;
    opens startUp;
    opens dbUtil;
    opens helper.payment;
    opens helper.people;
    opens helper.physical;
    opens dashBoard;
    opens helper.Info;
    opens helper.staf;
}