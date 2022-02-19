package codeBackup;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import helper.people.ResidentMangerLoader;

import java.io.IOException;

public class codeBackUp {

    //public static boolean setIt = false;
    @FXML
    private Pane abovePane;

    @FXML
    private JFXButton addUser;

    @FXML
    private AnchorPane belowScroll;

    @FXML
    private JFXButton paymentManger;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label profileName;

    @FXML
    private JFXButton propertyManger;

    @FXML
    private JFXButton registerManger;

    @FXML
    private TextField search;

    @FXML
    private FontAwesomeIcon searchPressed;

    @FXML
    private JFXButton signOut;

    @FXML
    private JFXButton updateTabel;


    @FXML
    private JFXButton addResident;

    @FXML
    private JFXButton removeResident;



    @FXML
    public void addResidentP(ActionEvent event) {



    }

    @FXML
    public void removeResidentP(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));

        try {
            Node root2 = FXMLLoader.load(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
            belowScroll.getChildren().add(root2);
            loader.load();
            ResidentMangerLoader residentMangerLoader =loader.getRoot();
            residentMangerLoader.loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void infoP(ActionEvent event) {

    }

    @FXML
    void paymentMangerP(ActionEvent event) {

    }

    @FXML
    void propertyMangerP(ActionEvent event) {

    }

    @FXML
    public void registerMangerP() throws IOException {
        Node root = FXMLLoader.load(getClass().getResource("/codeBackup/residentContent.fxml"));
        abovePane.getChildren().add(root);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
        loader.load();
        ResidentMangerLoader residentTable=loader.getController();
        residentTable.loadDataTable();
        //setIt = true;
    }

    @FXML
    void signOutP(ActionEvent event) {

    }
    @FXML
    void addUser(ActionEvent event){

    }
    @FXML
    void updateTa() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));

        try {
            Node root2 = FXMLLoader.load(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
            belowScroll.getChildren().add(root2);
            loader.load();
            ResidentMangerLoader residentMangerLoader =loader.getController();
            residentMangerLoader.loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    /*
    *                 String [] naColumn ={"NumCount" , "ResidentId" , "FirstName" , "LastName" , "Address", "Age" , "Sex" , "PhoneNumber" , "BlockNumber", "HouseNumber", "RentStatus"};
                ArrayList<String> read = new ArrayList<String>();
                dataObservableList = FXCollections.observableArrayList();
                SqlDataMode mode = new SqlDataMode();
                String readed[][] = mode.readTable(searchA,naColumn);
                for(int i =0;i<readed.length;i++){
                    for (int j=0;j<readed[i].length;j++){
                        read.add(readed[i][j]);
                    }
                    for (int k =0;k<read.size();k++){
                        System.out.print(read.get(k)+" ");
                    }
                    System.out.println();
                    dataObservableList.add(new ResidentData(read.get(2),Integer.parseInt(read.get(1)),read.get(3),read.get(4),read.get(5),read.get(6),read.get(7),read.get(8),read.get(9),read.get(10),read.get(11)));
                }
                residentIDT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("residentId"));
                userId.setCellValueFactory(new PropertyValueFactory<ResidentData,Integer>("userId"));
                firstName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("firstName"));
                lastName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("lastName"));
                age.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("age"));
                address.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("address"));
                sex.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("sex"));
                phoneNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("phoneNumber"));
                block.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("blockNumber"));
                houseNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("houseNumber"));
                rentStatusT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("rentStatus"));

                tableView.setItems(dataObservableList);*/

    /*        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String readA ="SELECT * FROM PaymentTable";
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(readA);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                dataObservableList.add(new PaymentData(resultSet.getString("Name"),resultSet.getString("ResidentId"),resultSet.getString("PaymentPurpose"),resultSet.getString("PaymentAmount"),resultSet.getString("DateAndTime")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

}
