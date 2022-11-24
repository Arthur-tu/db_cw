package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Departament;

public class UpdateDepartamentController {
    public Button addButton;
    public Button cancelButton;
    public TextField idMedField;
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
        Integer med_id = Integer.parseInt(idMedField.getText().trim());

        DepartamentFormController departamentFormController = new DepartamentFormController();

        Departament depart = new Departament(med_id, DepartamentFormController.departament.getTitle());
        dbHandler.updateDepartament(depart);
        System.out.println("Изменение прошло успешно");
        DepartamentFormController.dc.fillDate();
        try {
            departamentFormController.table_5.setItems(DepartamentFormController.dc.getDepartaments());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        idMedField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
