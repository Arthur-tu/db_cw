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
import sample.MedicalInstitution;
import sample.MedicalInstitutionCollection;
import sample.Patient;

import java.io.IOException;

public class MedicalInstitutionsFormController {
    @FXML
    private Button addMedButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_3;
    @FXML
    private TableColumn<MedicalInstitution, String> med_title;
    @FXML
    private TableColumn<MedicalInstitution, String> med_purpose;
    @FXML
    private TableColumn<MedicalInstitution, String> med_type;
    @FXML
    private TableColumn<MedicalInstitution, String> med_contact_data;
    @FXML
    private Button changeButton5;

    public static MedicalInstitutionCollection medc = new MedicalInstitutionCollection();

    public static MedicalInstitution medicalInstitution;

    @FXML
    void initialize() {
        med_title.setCellValueFactory(new PropertyValueFactory<MedicalInstitution, String>("title"));
        med_purpose.setCellValueFactory(new PropertyValueFactory<MedicalInstitution, String>("purpose"));
        med_type.setCellValueFactory(new PropertyValueFactory<MedicalInstitution, String>("type"));
        med_contact_data.setCellValueFactory(new PropertyValueFactory<MedicalInstitution, String>("contact_data"));

        medc.fillDate();
        table_3.setItems(medc.getMeds());

        backButton.setOnAction(event-> goBack());

        addMedButton.setOnAction(actionEvent -> addNewMed());

        changeButton5.setOnAction(actionEvent -> {
            medicalInstitution = (MedicalInstitution) table_3.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateMed.fxml","Изменение медицинского учереждения");
        });

        cancelButton.setOnAction(actionEvent -> deleteMed());
    }

    private void deleteMed() {
        MedicalInstitution medicalInstitution = (MedicalInstitution) table_3.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteMed(medicalInstitution);
        MedicalInstitutionsFormController.medc.fillDate();
        try {
            MedicalInstitutionsFormController medicalInstitutionsFormController = new MedicalInstitutionsFormController();
            medicalInstitutionsFormController.table_3.setItems(MedicalInstitutionsFormController.medc.getMeds());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void addNewMed() {
        openNewModalScene("/sample/fxml/newMedForm.fxml","Добавление медицинского учереждения");
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
