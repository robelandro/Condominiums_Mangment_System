package management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DashBoardLauncher extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Pane pane;
        pane = (Pane) loader.load(getClass().getResource("/management/ChoiceManagementAdmin.fxml").openStream());
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.setResizable(false);
        stage.show();
    }
    public void dashBoardLauncher() {
        launch();
    }
}
