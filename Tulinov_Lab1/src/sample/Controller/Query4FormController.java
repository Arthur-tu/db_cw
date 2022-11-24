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
import sample.Q4Collection;
import sample.Q4Object;

import java.io.IOException;
import java.sql.Date;

public class Query4FormController {
    @FXML
    private Button select_Med_Btn;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_1;
    @FXML
    private TableColumn<Q4Object, String> name_clm;
    @FXML
    private TableColumn<Q4Object, String> surname_clm;
    @FXML
    private TableColumn<Q4Object, String> patronymic_clm;
    @FXML
    private TableColumn<Q4Object, String> med_clm;
    @FXML
    private TableColumn<Q4Object, Date> date1_clm;
    @FXML
    private TableColumn<Q4Object, Date> date_clm;
    @FXML
    private Button execute1Btn;

    public static Q4Object q4;

    public static Q4Collection q4c = new Q4Collection();
    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> goBack());

        select_Med_Btn.setOnAction(actionEvent -> select());

        execute1Btn.setOnAction(actionEvent -> doQ4());
    }

    private void doQ4() {
        date_clm.setCellValueFactory(new PropertyValueFactory<Q4Object, Date>("start_date"));
        date1_clm.setCellValueFactory(new PropertyValueFactory<Q4Object,Date>("end_date"));
        med_clm.setCellValueFactory(new PropertyValueFactory<Q4Object, String>("med"));
        name_clm.setCellValueFactory(new PropertyValueFactory<Q4Object, String>("name"));
        surname_clm.setCellValueFactory(new PropertyValueFactory<Q4Object, String>("surname"));
        patronymic_clm.setCellValueFactory(new PropertyValueFactory<Q4Object, String>("patronymic"));

        q4c.fillDate();
        table_1.setItems(q4c.getQ4s());
    }

    private void select() {
        openNewModalScene("/sample/fxml/SelectQ4.fxml", "Укажите данные");
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
