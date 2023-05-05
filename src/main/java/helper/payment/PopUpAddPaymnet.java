package helper.payment;

import com.jfoenix.controls.JFXButton;
import dbUtil.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PopUpAddPaymnet {

    @FXML
    private JFXButton cancelPayment;

    @FXML
    private JFXButton completePayment;

    @FXML
    private TextField firstNameTxt;

    @FXML
    private TextField paymentAmountTxt;

    @FXML
    private TextField paymentPurposeTxt;

    @FXML
    private TextField residentIdTxt;
    Connection connection;

    @FXML
    void cancelPaymentPressed(ActionEvent event) {

    }

    @FXML
    void completePaymentPressed(ActionEvent event) {
        if (checkFor()){
            LocalDate localDate =LocalDate.now();
            String month = String.valueOf(localDate.getMonthValue());
            String year = String.valueOf(localDate.getYear());
            paymentNameAdd(residentIdTxt.getText().trim(),month+":"+year);
        }
        else {
            System.out.println("error");
        }
    }
    public boolean checkFor(){
        boolean purpose =true;
        boolean resident;
        boolean emtey = false;
        boolean lastAnswer = false;
        String sqlCheck = "SELECT * FROM Resident WHERE FirstName = '"+firstNameTxt.getText().trim()+"' AND ResidentId ='"+residentIdTxt.getText().trim()+"'";
        String sqlFromPayment = "SELECT * FROM PaymentTable WHERE Name = '"+firstNameTxt.getText().trim()+"' AND ResidentId ='"+residentIdTxt.getText().trim()+"'";
        Connection con;
        PreparedStatement preparedStatement2;
        PreparedStatement preparedStatement;
        ResultSet set ;
        ResultSet set1;
        try {
            con = DbConnection.getConnection();
            preparedStatement = con.prepareStatement(sqlCheck);
            preparedStatement2 = con.prepareStatement(sqlFromPayment);
            set1 =preparedStatement2.executeQuery();
            set = preparedStatement.executeQuery();
            while (set1.next()){
                LocalDate localDate =LocalDate.now();
                String month = String.valueOf(localDate.getMonthValue());
                String year = String.valueOf(localDate.getYear());
                if (set1.getString("PaymentPurpose").trim().equals(paymentPurposeTxt.getText().trim()) && (month+":"+year).equals(set1.getString("DateAndTime"))){
                    purpose=false;
                    System.out.println("exe");
                }

            }
            if (paymentPurposeTxt.getText().trim().isEmpty() || firstNameTxt.getText().trim().isEmpty() || paymentAmountTxt.getText().trim().isEmpty() || residentIdTxt.getText().trim().isEmpty()){
                Alert a =new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Empty");
                a.setContentText("Filed Is Empty!");
                a.show();
                emtey = true;
            }
            if (set.next()){
                resident=true;
            }
            else {
                resident = false;
            }
            if (purpose && resident && !emtey){
                lastAnswer = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            lastAnswer = false;
        }
        return lastAnswer;
    }
    public void paymentNameAdd(String residentId,String dateA){
        String paymentName ="INSERT INTO PAYMENTTABLE (NAME,RESIDENTID,PAYMENTPURPOSE,PAYMENTAMOUNT,DATEANDTIME) VALUES ('"+firstNameTxt.getText().trim()+"','"+residentId+"','"+paymentPurposeTxt.getText().trim()+"','"+paymentAmountTxt.getText().trim()+"','"+dateA+"')";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(paymentName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
