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
            if(dataMode.rememberName().equals("Admin")){
                AdminDashBoardLauncher adminDashBoardLauncher = new AdminDashBoardLauncher();
                adminDashBoardLauncher.dashBoardLauncher();
            }
            else if (dataMode.rememberName().equals("Staff")){
                StaffDashBoardLauncher adminDashBoardLauncher = new StaffDashBoardLauncher();
                adminDashBoardLauncher.dashBoardLauncher();
            }
            else if (dataMode.rememberName().equals("Broker")){
                BrokerDashBoardLauncher dashBoardLauncher = new BrokerDashBoardLauncher();
                dashBoardLauncher.dashBoardLauncher();
            }
            else {
                SecurityDashBoardLauncher dashBoardLauncher = new SecurityDashBoardLauncher();
                dashBoardLauncher.dashBoardLauncher();
            }
        }
        else {
            System.out.println("Skipped");
            Login login = new Login();
            login.loginLauncher();
        }
    }
}
