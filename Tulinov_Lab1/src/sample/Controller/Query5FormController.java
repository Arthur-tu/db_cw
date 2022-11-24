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
import sample.Q5Collection;
import sample.Q5Object;
import java.io.IOException;


public class Query5FormController {
    @FXML
    private Button select_Med_Btn;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Q5Object, String> name_clm;
    @FXML
    private TableColumn<Q5Object, String> surname_clm;
    @FXML
    private TableColumn<Q5Object, String> patronymic_clm;
    @FXML
    private TableColumn<Q5Object, String> med_clm;
    @FXML
    private Button execute1Btn;

    public static Q5Object q5;

    public static Q5Collection q5c = new Q5Collection();

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> goBack());

        select_Med_Btn.setOnAction(actionEvent -> select());

        execute1Btn.setOnAction(actionEvent -> doQ5());
    }

    private void doQ5() {
        med_clm.setCellValueFactory(new PropertyValueFactory<Q5Object, String>("med"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Q5Object, String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Q5Object, String>("surname"));
        patronymic_clm.setCellValueFactory(new PropertyValueFactory<Q5Object, String>("patronymic"));

        q5c.fillDate();
        table_1.setItems(q5c.getQ5s());
    }

    private void select() {
        openNewModalScene("/sample/fxml/SelectQ5.fxml", "Укажите данные");
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
