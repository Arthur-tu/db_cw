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

public class AdjacentFormController {
    @FXML
    public TableView table_8;
    @FXML
    private Button addAButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    private TableColumn<Ajainst, Integer> A_prof_clm;
    @FXML
    private TableColumn<Ajainst, Integer> A_med_inst_clm;
    @FXML
    private Button changeButton4;

    public TableView getTable_8() {
        return table_8;
    }

    public static AjainstCollection ac = new AjainstCollection();

    public static Ajainst ajainstt;

    @FXML
    void initialize() {
        A_prof_clm.setCellValueFactory(new PropertyValueFactory<Ajainst,Integer>("profile_id"));
        A_med_inst_clm.setCellValueFactory(new PropertyValueFactory<Ajainst,Integer>("med_institut_id"));

        ac.fillDate();
        table_8.setItems(ac.getAjainsts());

        backButton.setOnAction(event-> goBack());

        addAButton.setOnAction(actionEvent -> addNewAj());

        changeButton4.setOnAction(actionEvent -> {
            ajainstt = (Ajainst) table_8.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateAjaist.fxml","Изменение");
        });

        cancelButton.setOnAction(actionEvent -> deleteAjaist());
    }

    private void goBack() {
        backButton.getScene().getWindow().hide();
    }

    private void addNewAj() {
        openNewModalScene("/sample/fxml/newAjaistForm.fxml","Добавление");
    }

    private void deleteAjaist() {
        Ajainst ajainst = (Ajainst) table_8.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteAjainst(ajainst);
        AdjacentFormController.ac.fillDate();
        try {
            AdjacentFormController adjacentFormController = new AdjacentFormController();
            adjacentFormController.getTable_8().setItems(AdjacentFormController.ac.getAjainsts());
        } catch (Exception e) {
           e.printStackTrace();
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
