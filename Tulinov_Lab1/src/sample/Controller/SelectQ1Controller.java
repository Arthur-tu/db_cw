package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Q1Object;

public class SelectQ1Controller {
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

        OkButton.setOnAction(actionEvent -> TryQ1());
    }

    private void TryQ1() {
        String profile = ProfField.getText().trim();
        String med = MedField.getText().trim();
        Query1FormController query1FormController = new Query1FormController();
        query1FormController.q1 = new Q1Object(profile, med);
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
