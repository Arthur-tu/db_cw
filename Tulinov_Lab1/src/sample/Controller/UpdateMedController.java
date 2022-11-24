package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.MedicalInstitution;

public class UpdateMedController {

    public Button addButton;
    public Button cancelButton;
    public TextField purposeField;
    public TextField typeField;
    public TextField adressField;
    public Button goBackButton;
    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> updatePatient());
    }

    private void updatePatient() {
        String purpose = purposeField.getText().trim();
        String type = typeField.getText().trim();
        String adress = adressField.getText().trim();
        MedicalInstitutionsFormController medicalInstitutionsFormController = new MedicalInstitutionsFormController();

        MedicalInstitution med = new MedicalInstitution(MedicalInstitutionsFormController.medicalInstitution.getTitle(),
                purpose, type, adress);
        dbHandler.updateMed(med);

        MedicalInstitutionsFormController.medc.fillDate();
        try {
            medicalInstitutionsFormController.table_3.setItems(MedicalInstitutionsFormController.medc.getMeds());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        purposeField.setText("");
        typeField.setText("");
        adressField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
