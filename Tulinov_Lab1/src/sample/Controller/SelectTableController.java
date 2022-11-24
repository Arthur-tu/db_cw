package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class SelectTableController {

    @FXML
    private Button profButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button prof_to_med_Button;

    @FXML
    private Button medical_institutions_Button;

    @FXML
    private Button DepartamentButton;

    @FXML
    private Button WardButton;

    @FXML
    private Button WorrkerButton;

    @FXML
    private Button PatientButton;

    @FXML
    void initialize() {
        cancelButton.setOnAction(actionEvent -> goBack());

        PatientButton.setOnAction(actionEvent -> showPatientForm());

        WorrkerButton.setOnAction(actionEvent -> showWorkerForm());

        WardButton.setOnAction(actionEvent -> showWardForm());

        DepartamentButton.setOnAction(actionEvent -> showDepartamentForm());

        medical_institutions_Button.setOnAction(actionEvent -> showMedicalInstitutionsForm());

        profButton.setOnAction(actionEvent -> showProfForm());

        prof_to_med_Button.setOnAction(actionEvent -> showProfToMedForm());
    }

    private void showProfToMedForm() {
        openNewModalScene("/sample/fxml/AdjacentForm.fxml","Смежная таблица");
    }

    private void showProfForm() {
        openNewModalScene("/sample/fxml/ProfileForm.fxml","Таблица профилей");
    }

    private void showMedicalInstitutionsForm() {
        openNewModalScene("/sample/fxml/MedicalInstitutionsForm.fxml","Таблица медицинских учереждений");
    }

    private void showDepartamentForm() {
        openNewModalScene("/sample/fxml/DepartamentForm.fxml","Таблица отделений");
    }

    private void showWardForm() {
        openNewModalScene("/sample/fxml/WardForm.fxml","Таблица палат");
    }

    private void showWorkerForm() {
        openNewModalScene("/sample/fxml/WorkerForm.fxml","Таблица работников");
    }

    private void showPatientForm() {
        openNewModalScene("/sample/fxml/PatientForm.fxml","Таблица больных");
    }

    private void goBack() {
        cancelButton.getScene().getWindow().hide();
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
