package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Ward;

public class UpdateWardController {
    public Button cancelButton;
    public TextField idWardField;
    public TextField idWorkerField;
    public Button goBackButton;

    private static DBHandler dbHandler;
    public Button changeButton;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        changeButton.setOnAction(actionEvent -> updatePatient());
    }
    private void updatePatient() {
        Integer idDep = Integer.parseInt(idWardField.getText().trim());

        WardFormController wardFormController = new WardFormController();

        Ward w = new Ward(idDep, WardFormController.w.getTitle());
        dbHandler.updateWard(w);

        WardFormController.wc.fillDate();
        try {
            wardFormController.table_2.setItems(WardFormController.wc.getWards());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        idWardField.setText("");
        idWorkerField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }


}
