package helper.payment;

import com.jfoenix.controls.JFXButton;
import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class PaymentManger implements Initializable {

    @FXML
    private JFXButton paymnetStatuse;

    @FXML
    private JFXButton addPayment;

    @FXML
    private TableColumn<PaymentData, String> dateAndTime;

    @FXML
    private TableColumn<PaymentData, String> nameTab;

    @FXML
    private JFXButton paid;

    @FXML
    private TableView<PaymentData> paymentTable;

    @FXML
    private TableColumn<PaymentData, String> paymentAmountTab;

    @FXML
    private TableColumn<PaymentData, String> paymentPurposeTab;

    @FXML
    private JFXButton printTable;

    @FXML
    private JFXButton receiptPrint;

    @FXML
    private TableColumn<PaymentData, String> residentIdTab;

    @FXML
    private FontAwesomeIcon searchPayment;

    @FXML
    private TextField searchPaymentText;

    @FXML
    private JFXButton unpaid;

    public ObservableList<PaymentData> dataObservableList;

    //payment Stautus

    //payment status

    @FXML
    void addPaymentPressed(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane pane;
        pane = (Pane) loader.load(getClass().getResource("/helper/payment/PopUpAddPaymnet.fxml").openStream());
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Add Payment");
        stage.setResizable(false);
        stage.showAndWait();
        loadData();
    }

    @FXML
    void paidPressed(ActionEvent event) {
        loadData();
    }

    @FXML
    void printTablePressed(ActionEvent event) {

    }

    @FXML
    void receiptPrintPressed(ActionEvent event) {

    }

    @FXML
    void unpaidPressed(ActionEvent event) {
        boolean name = false;
        dataObservableList = FXCollections.observableArrayList();
        String residentRead ="SELECT FirstName,ResidentId FROM Resident";
        String paymentRead ="SELECT DISTINCT Name,ResidentId FROM PaymentTable";
        Connection con;
        PreparedStatement preparedStatement2;
        PreparedStatement preparedStatement;
        ResultSet set ;
        ResultSet set1;
        try {
            con = DbConnection.getConnection();
            preparedStatement = con.prepareStatement(residentRead);
            preparedStatement2 = con.prepareStatement(paymentRead,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            set = preparedStatement.executeQuery();
            set1 = preparedStatement2.executeQuery();
            while (set.next()){
                System.out.print(set.getString("FirstName")+" ");
                while (set1.next()){
                    //System.out.println(set1.getString("Name"));
                    //System.out.println(set.getString("FirstName"));
                    if (set.getString("FirstName").equals(set1.getString("Name"))) {
                        name = true;
                        set1.beforeFirst();
                        break;
                    } else {
                        name = false;
                    }
                }
                if (!name){
                    //System.out.println("prwess");
                    dataObservableList.add(new PaymentData(set.getString("FirstName"),set.getString("ResidentId"),null,null,null));
                }
                else {
                    System.out.println("go");
                }
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableColumn(dataObservableList);
        //loadData();
    }
    public void loadData(){
        dataObservableList = FXCollections.observableArrayList();
        String naColumn [] ={"Name","ResidentId","PaymentPurpose","PaymentAmount","DateAndTime"};
        String readA ="SELECT * FROM PaymentTable";
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode sqlDataMode = new SqlDataMode();
        String readN [][] = sqlDataMode.readTable(readA,naColumn);
        for (String[] strings : readN) {
            //System.out.print(readN[i][j]+" ");
            read.addAll(Arrays.asList(strings));
            //System.out.println();
            //System.out.println(read.get(0)+" "+read.get(1)+" "+read.get(2)+" "+read.get(3)+" "+read.get(4));
            dataObservableList.add(new PaymentData(read.get(0), read.get(1), read.get(2), read.get(3), read.get(4)));
            read.clear();
        }
        tableColumn(dataObservableList);
    }
    @FXML
    void paymentStatusPressed(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane pane;
        pane = (Pane) loader.load(getClass().getResource("/helper/payment/paymentStatus.fxml").openStream());
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Search For Payment Status");
        stage.setResizable(false);
        stage.showAndWait();
        tableColumn(PaymentStatus.dataObservableList1);
    }
    public void tableColumn(ObservableList<PaymentData> dataObservableList1){

        nameTab.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("name"));
        residentIdTab.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("residentId"));
        paymentPurposeTab.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("paymentPurpose"));
        paymentAmountTab.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("paymentAmount"));
        dateAndTime.setCellValueFactory(new PropertyValueFactory<PaymentData,String>("dateAndTime"));

        paymentTable.setItems(dataObservableList1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        searchPayment.setOnMousePressed(mouseEvent -> {
            if (searchPaymentText.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Search");
                alert.setHeaderText("Search Filed Can not Be Empty");
                alert.setContentText("Please Enter At List One Character");
                alert.show();
            }
            else {
                String searchA ="SELECT * FROM PaymentTable WHERE Name LIKE '%"+searchPaymentText.getText().trim()+"%'";
                String [] naColumn ={"Name" , "ResidentId" , "PaymentPurpose" ,"PaymentAmount", "DateAndTime" };
                ArrayList<String> read = new ArrayList<String>();
                dataObservableList = FXCollections.observableArrayList();
                SqlDataMode mode = new SqlDataMode();
                String readed[][] = mode.readTable(searchA,naColumn);
                for (String[] strings : readed) {
                    Collections.addAll(read, strings);
                    dataObservableList.add(new PaymentData(read.get(0),read.get(1),read.get(2),read.get(3),read.get(4)));
                    read.clear();
                }
                tableColumn(dataObservableList);
            }
        });
    }
}
