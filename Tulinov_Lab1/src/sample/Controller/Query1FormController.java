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
import sample.DepartamentCollection;
import sample.Q1Collection;
import sample.Q1Object;
import java.io.IOException;


public class Query1FormController {
    @FXML
    private Button select_Med_Btn;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Q1Object, String> name_clm;
    @FXML
    private TableColumn<Q1Object, String> surname_clm;
    @FXML
    private TableColumn<Q1Object, String> patronymic_clm;
    @FXML
    private TableColumn<Q1Object, Integer> count_clm;
    @FXML
    private TableColumn<Q1Object, String> profile_clm;
    @FXML
    private TableColumn<Q1Object, String> med_title_clm;
    @FXML
    private Button execute1Btn;

    public static Q1Object q1;

    public static Q1Collection q1c = new Q1Collection();

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> goBack());

        select_Med_Btn.setOnAction(actionEvent -> selectMedAndProfile());

        execute1Btn.setOnAction(actionEvent -> doQ1());

    }

    private void doQ1() {
        profile_clm.setCellValueFactory(new PropertyValueFactory<Q1Object,String>("profile"));
        med_title_clm.setCellValueFactory(new PropertyValueFactory<Q1Object,String>("med"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Q1Object, String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Q1Object, String>("surname"));
        patronymic_clm.setCellValueFactory(new PropertyValueFactory<Q1Object, String>("patronymic"));
        count_clm.setCellValueFactory(new PropertyValueFactory<Q1Object, Integer>("count"));

        q1c.fillDate();
        table_1.setItems(q1c.getQ1s());
    }

    private void selectMedAndProfile() {
        openNewModalScene("/sample/fxml/SelectQ1.fxml", "Укажите профиль и мед учереждение");
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
