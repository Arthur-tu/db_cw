package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Patient;
import sample.Ward;

import java.sql.Date;
import java.util.Set;

public class NewWardForm {
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField idDepartamentField;
    @FXML
    private TextField titleField;
    @FXML
    private Button goBackButton;

    private static DBHandler dbHandler;
    private static Set<String> wards;
    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        wards = dbHandler.getWardsSet();
        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewWard());
    }

    private void TryAddNewWard() {
        if (!wards.contains(idDepartamentField.getText().trim() + titleField.getText().trim())) {
            Integer idDep = Integer.parseInt(idDepartamentField.getText().trim());
            String title = titleField.getText().trim();
            WardFormController wc = new WardFormController();

            Ward w = new Ward(idDep, title);
            dbHandler.signUpWard(w);

            WardFormController.wc.fillDate();
            try {
                wc.table_2.setItems(PatientFormController.pc.getPatients());
            } catch (Exception e) {
                System.out.println();
            }
            wards.add(idDepartamentField.getText().trim() + title);
            System.out.println("Палата добавлена");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такая палата уже есть");
        }

    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

    private void refreshFields() {
        idDepartamentField.setText("");
        titleField.setText("");
    }
}
