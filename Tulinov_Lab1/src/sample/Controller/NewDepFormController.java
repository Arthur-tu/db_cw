package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Departament;
import sample.Ward;

import java.util.Set;

public class NewDepFormController {
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField Med_Intst_IdField;
    @FXML
    private TextField titleField;
    @FXML
    private Button goBackButton;

    private static DBHandler dbHandler;
    private static Set<String> deps;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        deps = dbHandler.getDepsSet();
        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewWard());
    }

    private void TryAddNewWard() {
        if (!deps.contains(Med_Intst_IdField.getText().trim() + titleField.getText().trim())) {
            Integer idMed = Integer.parseInt(Med_Intst_IdField.getText().trim());
            String title = titleField.getText().trim();
            DepartamentFormController departamentFormController = new DepartamentFormController();

            Departament d = new Departament(idMed, title);
            dbHandler.signUpDepartament(d);

            DepartamentFormController.dc.fillDate();
            try {
                departamentFormController.table_5.setItems(DepartamentFormController.dc.getDepartaments());
            } catch (Exception e) {
                System.out.println();
            }
            deps.add(Med_Intst_IdField.getText().trim() + title);
            System.out.println("Отделение добавлено");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такое отделение уже есть");
        }

    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

    private void refreshFields() {
        Med_Intst_IdField.setText("");
        titleField.setText("");
    }
}
