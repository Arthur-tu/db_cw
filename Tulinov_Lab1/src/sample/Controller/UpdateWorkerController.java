package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Worker;


public class UpdateWorkerController {
    public Button changeButton;
    public Button cancelButton;
    public TextField Med_idField;
    public TextField SpecField;
    public TextField CategoryField;
    public TextField typeField;
    public Button goBackButton;

    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        changeButton.setOnAction(actionEvent -> updateWorker());
    }

    private void updateWorker() {
        Integer med_Id = Integer.parseInt(Med_idField.getText().trim());
        String specialization = SpecField.getText().trim();
        String categoty = CategoryField.getText().trim();
        String type = typeField.getText().trim();

        WorkerFormController workerFormController = new WorkerFormController();

        Worker w = new Worker(med_Id, WorkerFormController.w.getName(),  WorkerFormController.w.getSurname(),
                WorkerFormController.w.getPartonynic(), specialization, categoty, type);
        dbHandler.updateWorker(w);

        WorkerFormController.workerCollection.fillDate();
        try {
            workerFormController.table_10.setItems(WorkerFormController.workerCollection.getWorkers());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        Med_idField.setText("");
        SpecField.setText("");
        CategoryField.setText("");
        typeField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
