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
import sample.DBHandler;
import sample.Patient;
import sample.PatientCollection;
import java.io.IOException;
import java.sql.Date;

public class PatientFormController {
    @FXML
    private Button changeButton1;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Patient, Integer> ward_clm;
    @FXML
    private TableColumn<Patient, Integer> worker_clm;
    @FXML
    private TableColumn<Patient, String> name_clm;
    @FXML
    private TableColumn<Patient, String> surname_clm;
    @FXML
    private TableColumn<Patient, Date> start_clm;
    @FXML
    private TableColumn<Patient, String> pat_clm;
    @FXML
    private TableColumn<Patient, Date> end_clm;
    @FXML
    private TableColumn<Patient, String> health_clm;
    @FXML
    private TableColumn<Patient, Integer> temp_clm;
    @FXML
    private Button cancelButton;
    @FXML
    private Button addPatientButton;
    @FXML
    private Button backButton;

    public static PatientCollection pc = new PatientCollection();

    public static Patient p;

    @FXML
    void initialize() {
        ward_clm.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("idWard"));
        worker_clm.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("idWorker"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Patient,String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Patient,String>("surname"));
        pat_clm.setCellValueFactory(new PropertyValueFactory<Patient,String>("partonynic"));
        start_clm.setCellValueFactory(new PropertyValueFactory<Patient,Date>("start_time"));
        end_clm.setCellValueFactory(new PropertyValueFactory<Patient,Date>("end_time"));
        health_clm.setCellValueFactory(new PropertyValueFactory<Patient,String>("health"));
        temp_clm.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("temperature"));

        pc.fillDate();
        table_1.setItems(pc.getPatients());

        backButton.setOnAction(event-> goBack());

        addPatientButton.setOnAction(actionEvent -> addNewPatient());

        changeButton1.setOnAction(actionEvent -> {
            p = (Patient) table_1.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updatePatient.fxml","Изменение больного");
        });
        
        cancelButton.setOnAction(actionEvent -> deletePatient());
    }

    private void deletePatient() {
        Patient patient = (Patient) table_1.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deletePatient(patient);
        PatientFormController.pc.fillDate();
        try {
            PatientFormController patientFormController = new PatientFormController();
            patientFormController.table_1.setItems(PatientFormController.pc.getPatients());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void addNewPatient() {
        openNewModalScene("/sample/fxml/newUserForm.fxml","Добавление больного");
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

