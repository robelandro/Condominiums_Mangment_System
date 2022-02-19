package helper.payment;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class PaymentStatus {

    @FXML
    private TextField resedentIdForSearch;

    @FXML
    private JFXButton searchForSearchP;

    @FXML
    private TextField dateForSearch;

    @FXML
    private TextField nameForSearch;

    @FXML
    private TextField purposeForSearch;

    @FXML
    private TextField yearForSearch;

    public static ObservableList<PaymentData> dataObservableList1;

    @FXML
    void cancelForSearchPressed(ActionEvent event) {

    }

    @FXML
    void searchForSearchPressed(ActionEvent event) {
        String [] strings ={"Name","ResidentId","PaymentPurpose","PaymentAmount","DateAndTime"};
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM PaymentTable WHERE Name = '"+nameForSearch.getText().trim()+"' AND ResidentId = '"+resedentIdForSearch.getText().trim()+"' AND PaymentPurpose ='"+purposeForSearch.getText().trim()+"' AND DateAndTime ='"+dateForSearch.getText().trim()+":"+yearForSearch.getText().trim()+"'";
        dataObservableList1 = FXCollections.observableArrayList();
        SqlDataMode dataMode = new SqlDataMode();
        String[][] strings1=dataMode.readTable(sql,strings);
        System.out.println(strings1.length);
        if(resedentIdForSearch.getText().trim().isEmpty() || yearForSearch.getText().trim().isEmpty()||dateForSearch.getText().trim().isEmpty() || nameForSearch.getText().trim().isEmpty() || purposeForSearch.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Filed");
            alert.setContentText("Please Enter Full Information");
            alert.show();
        }
        else if (strings1.length==0){
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Mismatch Database");
            alert1.setContentText(" We cant find any information with given input ");
            alert1.show();
        }
        else {
            for (String[] value : strings1) {
                Collections.addAll(arrayList, value);
                dataObservableList1.add(new PaymentData(arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4)));
                arrayList.clear();
            }
            Stage stage = (Stage) this.searchForSearchP.getScene().getWindow();
            stage.close();
        }
    }

}
