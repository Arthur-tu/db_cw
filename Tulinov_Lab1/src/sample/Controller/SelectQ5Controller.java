package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Q5Object;

public class SelectQ5Controller {
    @FXML
    private Button OkButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField MedField;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField profField;

    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        OkButton.setOnAction(actionEvent -> TryQ5());
    }

    private void TryQ5() {
        String med = MedField.getText().trim();
        String prof = profField.getText().trim();
        Query5FormController query5FormController = new Query5FormController();
        query5FormController.q5 = new Q5Object(med, prof);
        goBack();
    }

    private void refreshFields() {
        MedField.setText("");
        profField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
