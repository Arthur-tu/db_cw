package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Patient;

import java.sql.Date;
import java.util.Set;

public class NewUserForm {
    private static Set<String> patients;
    private static DBHandler dbHandler;

    @FXML
    private Button addButton;
    @FXML
    private TextField idWardField;
    @FXML
    private TextField idWorkerField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField partonynicField;
    @FXML
    private TextField start_timeField;
    @FXML
    private TextField end_timeField;
    @FXML
    private TextField healthField;
    @FXML
    private TextField temperatureField;
    @FXML
    private Button goBackButton;
    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        patients = dbHandler.getPatirntsSet();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewPatient());
    }

    private void refreshFields() {
        idWardField.setText("");
        idWorkerField.setText("");
        nameField.setText("");
        surnameField.setText("");
        partonynicField.setText("");
        start_timeField.setText("");
        end_timeField.setText("");
        healthField.setText("");
        temperatureField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

    private void AddNewPatient() {
        Integer idWard = Integer.parseInt(idWardField.getText().trim());
        Integer idWorker = Integer.parseInt(idWorkerField.getText().trim());
        String name = nameField.getText().trim();
        String surname = surnameField.getText().trim();
        String partonynic = partonynicField.getText().trim();
        String fio = name + surname + partonynic;
        Date start_time = java.sql.Date.valueOf(start_timeField.getText().trim());
        Date end_time = java.sql.Date.valueOf(end_timeField.getText().trim());
        String health = healthField.getText().trim();
        Integer temperature = Integer.parseInt(temperatureField.getText().trim());
        PatientFormController patientFormController = new PatientFormController();
        patients.add(fio);

        Patient p = new Patient(idWard, idWorker, name, surname, partonynic, start_time, end_time, health, temperature);
        dbHandler.signUpPatient(p);

        PatientFormController.pc.fillDate();
        try {
            patientFormController.table_1.setItems(PatientFormController.pc.getPatients());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void TryAddNewPatient() {
        if (!patients.contains(nameField.getText().trim() + surnameField.getText().trim() +
                partonynicField.getText().trim())) {
            AddNewPatient();
            System.out.println("Больной добавлен");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такой больной уже есть");
        }
    }
}