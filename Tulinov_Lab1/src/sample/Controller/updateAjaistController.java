package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Ajainst;
import sample.DBHandler;

public class updateAjaistController {

    public Button addButton;
    public Button cancelButton;
    public TextField purposeField;
    public Button goBackButton;
    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> updateAj());
    }

    private void updateAj() {
        Integer profile_id = Integer.parseInt(purposeField.getText().trim());

        AdjacentFormController adjacentFormController = new AdjacentFormController();

        Ajainst ajainst = new Ajainst(profile_id,AdjacentFormController.ajainstt.getMed_institut_id());
        dbHandler.updateAj(ajainst);

        AdjacentFormController.ac.fillDate();
        try {
            adjacentFormController.table_8.setItems(AdjacentFormController.ac.getAjainsts());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        purposeField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

}
