package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Q1Object;
import sample.Q2Object;

public class SelectQ2Controller {
    @FXML
    private Button OkButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField ProfField;
    @FXML
    private TextField MedField;
    @FXML
    private Button goBackButton;

    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        OkButton.setOnAction(actionEvent -> TryQ2());
    }

    private void TryQ2() {
        String specialization = ProfField.getText().trim();
        String med = MedField.getText().trim();
        Query2FormController query2FormController = new Query2FormController();
        String type = "Обслуживающий персонал";
        query2FormController.q2 = new Q2Object(specialization, med, type);
        goBack();
    }

    private void refreshFields() {
        ProfField.setText("");
        MedField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
