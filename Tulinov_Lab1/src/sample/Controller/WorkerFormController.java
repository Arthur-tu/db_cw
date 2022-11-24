package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.*;

import java.io.IOException;

public class WorkerFormController {
    @FXML
    private Button addWorkerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_10;
    @FXML
    private TableColumn<Worker, Integer> id_med_clm;
    @FXML
    private TableColumn<Worker, String> worker_name_clm;
    @FXML
    private TableColumn<Worker, String> worker_surname_clm;
    @FXML
    private TableColumn<Worker, String> worker_pat_clm;
    @FXML
    private TableColumn<Worker, String> worker_spec_clm;
    @FXML
    private TableColumn<Worker, String> category_clm;
    @FXML
    private TableColumn<Worker, String> type_clm;
    @FXML
    private Button changeButton111;

    public static WorkerCollection workerCollection = new WorkerCollection();

    public static Worker w;

    @FXML
    void initialize() {
        id_med_clm.setCellValueFactory(new PropertyValueFactory<Worker,Integer>("med_id"));
        worker_name_clm.setCellValueFactory(new PropertyValueFactory<Worker,String>("name"));
        worker_surname_clm.setCellValueFactory(new PropertyValueFactory<Worker,String>("surname"));
        worker_pat_clm.setCellValueFactory(new PropertyValueFactory<Worker,String>("partonynic"));
        worker_spec_clm.setCellValueFactory(new PropertyValueFactory<Worker, String>("specilization"));
        category_clm.setCellValueFactory(new PropertyValueFactory<Worker,String>("categoty"));
        type_clm.setCellValueFactory(new PropertyValueFactory<Worker,String>("type"));

        workerCollection.fillDate();
        table_10.setItems(workerCollection.getWorkers());

        backButton.setOnAction(event-> goBack());

        addWorkerButton.setOnAction(actionEvent -> addNewWorker());

        changeButton111.setOnAction(actionEvent -> {
            w = (Worker) table_10.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateWorker.fxml","Изменение рабочего");
        });

        cancelButton.setOnAction(actionEvent -> deleteWorker());
    }

    private void deleteWorker() {
        Worker worker = (Worker) table_10.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteWorker(worker);
        WorkerFormController.workerCollection.fillDate();
        try {
            WorkerFormController workerFormController = new WorkerFormController();
            workerFormController.table_10.setItems(WorkerFormController.workerCollection.getWorkers());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void addNewWorker() {
        openNewModalScene("/sample/fxml/newWorkerForm.fxml","Добавление рабочего");
    }

    private void goBack() {
        backButton.getScene().getWindow().hide();
    }

    public void openNewModalScene(String window, String title) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
