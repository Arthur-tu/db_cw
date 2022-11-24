package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Q3Object;

public class SelectQ3Controller {
    @FXML
    private Button OkButton;
    @FXML
    private Button cancelButton;
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

        OkButton.setOnAction(actionEvent -> TryQ3());
    }

    private void TryQ3() {
        String med = MedField.getText().trim();
        Query3FormController query3FormController = new Query3FormController();
        query3FormController.q3 = new Q3Object(med);
        goBack();
    }

    private void refreshFields() {
        MedField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
