package dashBoard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminDashBoardLauncher extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Pane pane;
        pane = (Pane) loader.load(getClass().getResource("/dashBoard/AdminDashBoard.fxml").openStream());
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Admin DashBoard");
        stage.setResizable(false);
        stage.show();
    }
    public void dashBoardLauncher() {
        launch();
    }
}
