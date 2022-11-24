package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectQueriesController {
    @FXML
    private Button QueryBtn1;
    @FXML
    private Button goBackBtn;
    @FXML
    private Button QueryBtn2;
    @FXML
    private Button QueryBtn3;
    @FXML
    private Button QueryBtn4;
    @FXML
    private Button QueryBtn5;

    @FXML
    void initialize() {
        QueryBtn1.setOnAction(actionEvent -> startQuery1());

        QueryBtn2.setOnAction(actionEvent -> startQuery2());

        QueryBtn3.setOnAction(actionEvent -> startQuery3());

        QueryBtn4.setOnAction(actionEvent -> startQuery4());

        QueryBtn5.setOnAction(actionEvent -> startQuery5());

        goBackBtn.setOnAction(actionEvent -> goBack());
    }

    private void startQuery5() {
        openNewModalScene("/sample/fxml/Query5Form.fxml","Запрос 5");
    }

    private void startQuery4() {
        openNewModalScene("/sample/fxml/Query4Form.fxml","Запрос 4");
    }

    private void startQuery3() {
        openNewModalScene("/sample/fxml/Query3Form.fxml","Запрос 3");
    }

    private void startQuery2() {
        openNewModalScene("/sample/fxml/Query2Form.fxml","Запрос 2");
    }

    private void startQuery1() {
        openNewModalScene("/sample/fxml/Query1Form.fxml","Запрос 1");
    }

    private void goBack() {
        goBackBtn.getScene().getWindow().hide();
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
