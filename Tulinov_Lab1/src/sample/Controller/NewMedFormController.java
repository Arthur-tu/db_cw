package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.MedicalInstitution;
import java.util.Set;

public class NewMedFormController {
    private static Set<String> meds;
    private static DBHandler dbHandler;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField Med_titleField;
    @FXML
    private TextField Med_tpurposeField;
    @FXML
    private TextField Med_typeField;
    @FXML
    private TextField Med_adressField;
    @FXML
    private Button goBackButton;
    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        meds = dbHandler.getMedsSet();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewMed());
    }

    private void TryAddNewMed() {
        if (!meds.contains(Med_titleField.getText().trim())) {
            AddNewMed();
            System.out.println("Медицинское учереждение добавлено");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такое медицинское учереждение уже есть");
        }
    }

    private void AddNewMed() {
        String title = Med_titleField.getText().trim();
        String purpose = Med_tpurposeField.getText().trim();
        String type = Med_typeField.getText().trim();
        String contact_data = Med_adressField.getText().trim();

        MedicalInstitutionsFormController controller = new MedicalInstitutionsFormController();
        meds.add(title);

        MedicalInstitution medicalInstitution = new MedicalInstitution (title, purpose, type, contact_data);
        dbHandler.signUpMed(medicalInstitution);

        MedicalInstitutionsFormController.medc.fillDate();
        try {
            controller.table_3.setItems(MedicalInstitutionsFormController.medc.getMeds());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        Med_titleField.setText("");
        Med_tpurposeField.setText("");
        Med_typeField.setText("");
        Med_adressField.setText("");
    }
    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
