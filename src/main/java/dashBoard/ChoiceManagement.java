package dashBoard;

import dbUtil.SqlDataMode;
import login.Login;
import startUp.StartUp;

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
            AdminDashBoardLauncher adminDashBoardLauncher = new AdminDashBoardLauncher();
            adminDashBoardLauncher.dashBoardLauncher();
        }
        else {
            System.out.println("Skipped");
            Login login = new Login();
            login.loginLauncher();
        }
    }
}
