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
import sample.Q1Collection;
import sample.Q1Object;
import sample.Q2Collection;
import sample.Q2Object;

import java.io.IOException;

public class Query2FormController {
    @FXML
    private Button select_Med_Btn;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Q2Object,String> name_clm;
    @FXML
    private TableColumn<Q2Object,String> surname_clm;
    @FXML
    private TableColumn<Q2Object,String> patronymic_clm;
    @FXML
    private TableColumn<Q2Object,Integer> count_clm;
    @FXML
    private TableColumn<Q2Object,String> type_clm;
    @FXML
    private TableColumn<Q2Object,String> med_title_clm;
    @FXML
    private TableColumn<Q2Object,String> spec_clm;
    @FXML
    private Button execute1Btn;

    public static Q2Object q2;

    public static Q2Collection q2c = new Q2Collection();

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> goBack());

        select_Med_Btn.setOnAction(actionEvent -> select());

        execute1Btn.setOnAction(actionEvent -> doQ2());

    }

    private void doQ2() {
        spec_clm.setCellValueFactory(new PropertyValueFactory<Q2Object,String>("specialization"));
        med_title_clm.setCellValueFactory(new PropertyValueFactory<Q2Object,String>("med"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Q2Object, String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Q2Object, String>("surname"));
        patronymic_clm.setCellValueFactory(new PropertyValueFactory<Q2Object, String>("patronymic"));
        count_clm.setCellValueFactory(new PropertyValueFactory<Q2Object, Integer>("count"));
        type_clm.setCellValueFactory(new PropertyValueFactory<Q2Object, String>("type"));
        q2c.fillDate();
        table_1.setItems(q2c.getQ2s());
    }

    private void select() {
        openNewModalScene("/sample/fxml/SelectQ2.fxml", "Укажите специальность и мед учереждение");
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
