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
import sample.Ward;
import sample.WardCollection;
import java.io.IOException;

public class WardFormController {
    public Button changeButton4;
    @FXML
    private Button addWardButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_2;
    @FXML
    private TableColumn<Ward, Integer> departament_id_clm;
    @FXML
    private TableColumn<Ward, String> title_clm;

    public static WardCollection wc = new WardCollection();

    public static Ward w;

    @FXML
    void initialize() {
        departament_id_clm.setCellValueFactory(new PropertyValueFactory<Ward,Integer>("departaments_id"));
        title_clm.setCellValueFactory(new PropertyValueFactory<Ward,String>("title"));

        wc.fillDate();
        table_2.setItems(wc.getWards());

        backButton.setOnAction(event-> goBack());

        addWardButton.setOnAction(actionEvent -> addNewWard());

        changeButton4.setOnAction(actionEvent -> {
            w = (Ward) table_2.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateWard.fxml","Изменение палаты");
        });

        cancelButton.setOnAction(actionEvent -> deleteWard());
    }

    private void goBack() {
        backButton.getScene().getWindow().hide();
    }

    private void addNewWard() {
        openNewModalScene("/sample/fxml/newWardForm.fxml","Добавление палаты");
    }

    private void deleteWard() {
        Ward ward = (Ward) table_2.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteWard(ward);
        WardFormController.wc.fillDate();
        try {
            WardFormController wardFormController = new WardFormController();
            wardFormController.table_2.setItems(WardFormController.wc.getWards());
        } catch (Exception e) {
            System.out.println();
        }
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
