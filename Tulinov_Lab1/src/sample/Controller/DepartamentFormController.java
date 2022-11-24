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

public class DepartamentFormController {
    @FXML
    private Button addDepButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_5;
    @FXML
    private TableColumn<Departament, Integer> dep_id_med_inst_clm;
    @FXML
    private TableColumn<Departament, String> dep_title_clm;
    @FXML
    private Button changeButton666;

    public static DepartamentCollection dc = new DepartamentCollection();

    public static Departament departament;

    @FXML
    void initialize() {
        dep_id_med_inst_clm.setCellValueFactory(new PropertyValueFactory<Departament,Integer>("id_med_institutions"));
        dep_title_clm.setCellValueFactory(new PropertyValueFactory<Departament,String>("title"));

        dc.fillDate();
        table_5.setItems(dc.getDepartaments());

        backButton.setOnAction(event-> goBack());

        addDepButton.setOnAction(actionEvent -> addNewDep());

        changeButton666.setOnAction(actionEvent -> {
            departament = (Departament) table_5.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateDepartament.fxml","Изменение отделения");
        });

        cancelButton.setOnAction(actionEvent -> deleteDepartament());
    }

    private void deleteDepartament() {
        Departament dep = (Departament) table_5.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteDepartament(dep);
        DepartamentFormController.dc.fillDate();
        try {
            DepartamentFormController departamentFormController = new DepartamentFormController();
            departamentFormController.table_5.setItems(DepartamentFormController.dc.getDepartaments());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void addNewDep() {
        openNewModalScene("/sample/fxml/newDepForm.fxml","Добавление отделение");
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
