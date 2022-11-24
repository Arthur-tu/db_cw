package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Patient;
import java.sql.Date;

public class UpdatePatientController {
    public Button addButton;
    public Button cancelButton;
    public TextField idWardField;
    public TextField idWorkerField;
    public TextField start_timeField;
    public TextField end_timeField;
    public TextField healthField;
    public TextField temperatureField;
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
        Integer idWard = Integer.parseInt(idWardField.getText().trim());
        Integer idWorker = Integer.parseInt(idWorkerField.getText().trim());
        Date start_time = java.sql.Date.valueOf(start_timeField.getText().trim());
        Date end_time = java.sql.Date.valueOf(end_timeField.getText().trim());
        String health = healthField.getText().trim();
        Integer temperature = Integer.parseInt(temperatureField.getText().trim());
        PatientFormController patientFormController = new PatientFormController();

        Patient p = new Patient(idWard, idWorker, PatientFormController.p.getName(),
                PatientFormController.p.getSurname(), PatientFormController.p.getPartonynic(), start_time, end_time,
                health, temperature);
        dbHandler.updatePatient(p);

        PatientFormController.pc.fillDate();
        try {
            patientFormController.table_1.setItems(PatientFormController.pc.getPatients());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        idWardField.setText("");
        idWorkerField.setText("");
        start_timeField.setText("");
        end_timeField.setText("");
        healthField.setText("");
        temperatureField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
