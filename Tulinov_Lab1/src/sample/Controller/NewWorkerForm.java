package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Worker;
import java.util.Set;

public class NewWorkerForm {
    private static Set<String> workers;
    private static DBHandler dbHandler;
    @FXML
    private TextField Worker_nameField;
    @FXML
    private TextField Worker_surnameField;
    @FXML
    private TextField Worker_patronymicField;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField idWorker_MedField;
    @FXML
    private TextField Worker_specField;
    @FXML
    private TextField Worker_categoryField;
    @FXML
    private TextField Worker_typeField;
    @FXML
    private Button goBackButton;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        workers = dbHandler.getWorkersSet();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewWorker());
    }

    private void refreshFields() {
        idWorker_MedField.setText("");
        Worker_nameField.setText("");
        Worker_surnameField.setText("");
        Worker_patronymicField.setText("");
        Worker_specField.setText("");
        Worker_categoryField.setText("");
        Worker_typeField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

    private void TryAddNewWorker() {
        if (!workers.contains(Worker_nameField.getText().trim() + Worker_surnameField.getText().trim() +
                Worker_patronymicField.getText().trim())) {
            AddNewWorker();
            System.out.println("Рабочий добавлен");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такой рабочий уже есть");
        }
    }

    private void AddNewWorker() {
        Integer idWorker_Med = Integer.parseInt(idWorker_MedField.getText().trim());
        String name = Worker_nameField.getText().trim();
        String surname = Worker_surnameField.getText().trim();
        String partonynic = Worker_patronymicField.getText().trim();
        String fio = name + surname + partonynic;
        String specialization = Worker_specField.getText().trim();
        String category = Worker_categoryField.getText().trim();
        String type = Worker_typeField.getText().trim();
        WorkerFormController workerFormController = new WorkerFormController();
        workers.add(fio);

        Worker w = new Worker(idWorker_Med, name, surname, partonynic, specialization, category, type);
        dbHandler.signUpWorker(w);

        WorkerFormController.workerCollection.fillDate();
        try {
            workerFormController.table_10.setItems(WorkerFormController.workerCollection.getWorkers());
        } catch (Exception e) {
            System.out.println();
        }
    }
}
