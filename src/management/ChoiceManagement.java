package management;

import dbUtil.SqlDataMode;
import login.Login;
import startUp.StartUp;

public class ChoiceManagement {
    public static void main(String[] args) {
        String trackerName ="Program";
        SqlDataMode dataMode = new SqlDataMode();
        if (dataMode.isNotStarUp(trackerName)){
            System.out.println("Skipped");
            Login login = new Login();
            login.loginLauncher(args);
        }
        else {

            dataMode.programTracker(trackerName);
            StartUp startUp = new StartUp();
            startUp.launcherStart(args);
            System.out.println("Program Run Success");
        }
    }
}
