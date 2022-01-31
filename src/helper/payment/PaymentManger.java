package helper.payment;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PaymentManger {

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

    @FXML
    void addPaymentPressed(ActionEvent event) {

    }

    @FXML
    void paidPressed(ActionEvent event) {

    }

    @FXML
    void printTablePressed(ActionEvent event) {

    }

    @FXML
    void receiptPrintPressed(ActionEvent event) {

    }

    @FXML
    void unpaidPressed(ActionEvent event) {

    }

}
