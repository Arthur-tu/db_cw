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
import sample.Q2Object;
import sample.Q3Collection;
import sample.Q3Object;

import java.io.IOException;
import java.sql.Date;

public class Query3FormController {
    @FXML
    private Button select_Med_Btn;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Q3Object, String> name_clm;
    @FXML
    private TableColumn<Q3Object, String> surname_clm;
    @FXML
    private TableColumn<Q3Object, String> patronymic_clm;
    @FXML
    private TableColumn<Q3Object, Date> date_clm;
    @FXML
    private TableColumn<Q3Object, String> health_clm;
    @FXML
    private TableColumn<Q3Object, String> med_clm;
    @FXML
    private TableColumn<Q3Object, Integer> temperature_clm;
    @FXML
    private TableColumn<Q3Object, String> doc_name;
    @FXML
    private TableColumn<Q3Object, String> doc_surname;
    @FXML
    private TableColumn<Q3Object, String> doc_patr;
    @FXML
    private Button execute1Btn;

    public static Q3Object q3;

    public static Q3Collection q3c = new Q3Collection();

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> goBack());

        select_Med_Btn.setOnAction(actionEvent -> select());

        execute1Btn.setOnAction(actionEvent -> doQ3());

    }

    private void doQ3() {
        date_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, Date>("date"));
        health_clm.setCellValueFactory(new PropertyValueFactory<Q3Object,String>("health"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("surname"));
        patronymic_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("patronymic"));
        med_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("med"));
        temperature_clm.setCellValueFactory(new PropertyValueFactory<Q3Object, Integer>("temperature"));
        doc_name.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("docname"));
        doc_surname.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("docsurname"));
        doc_patr.setCellValueFactory(new PropertyValueFactory<Q3Object, String>("docpatronymic"));

        q3c.fillDate();
        table_1.setItems(q3c.getQ3s());
    }

    private void select() {
        openNewModalScene("/sample/fxml/SelectQ3.fxml", "Укажите данные");
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
