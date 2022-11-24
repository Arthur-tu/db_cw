package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Q4Object;

import java.sql.Date;

public class SelectQ4Controller {
    @FXML
    private Button OkButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField MedField;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField startField;
    @FXML
    private TextField endField;

    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        OkButton.setOnAction(actionEvent -> TryQ4());
    }

    private void TryQ4() {
        String med = MedField.getText().trim();
        Date start_time = java.sql.Date.valueOf(startField.getText().trim());
        Date end_time = java.sql.Date.valueOf(endField.getText().trim());
        Query4FormController query4FormController = new Query4FormController();
        query4FormController.q4 = new Q4Object(med, start_time, end_time);
        goBack();
    }

    private void refreshFields() {
        MedField.setText("");
        startField.setText("");
        endField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

}
