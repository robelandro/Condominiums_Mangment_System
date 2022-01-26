package management;

import dbUtil.SqlDataMode;
import javafx.application.Platform;
import login.Login;
import login.LoginController;
import startUp.StartUp;

import java.util.ServiceLoader;

public class ChoiceManagement {
    public static void main(String[] args) {
        String trackerName ="Program";
        SqlDataMode dataMode = new SqlDataMode();
        if (!dataMode.isStarUp(trackerName)){
            StartUp startUp = new StartUp();
            startUp.launcherStart(args);
            System.out.println("Program Run Success");
        }
        else if (dataMode.rememberMe(trackerName)){
            System.out.println("Remembered");
            DashBoardLauncher dashBoardLauncher = new DashBoardLauncher();
            dashBoardLauncher.dashBoardLauncher();
        }
        else {
            System.out.println("Skipped");
            Login login = new Login();
            login.loginLauncher();
        }
    }
}
