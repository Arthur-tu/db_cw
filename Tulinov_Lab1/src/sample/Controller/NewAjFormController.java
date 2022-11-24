package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Ajainst;
import sample.DBHandler;
import sample.MedicalInstitution;

import java.util.Set;

public class NewAjFormController {
    public TextField prof_id_Field1;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField prof_id_Field;

    @FXML
    private Button goBackButton;

    private static Set<String> ajs;
    private static DBHandler dbHandler;


    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        ajs = dbHandler.getAjSet();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewAj());
    }

    private void TryAddNewAj() {
        if (!ajs.contains(prof_id_Field.getText().trim() + prof_id_Field1.getText().trim())) {
            AddNewAj();
            System.out.println("Запись добавлена");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такая запись уже есть");
        }
    }

    private void AddNewAj() {
        Integer prof_id = Integer.parseInt(prof_id_Field.getText().trim());
        Integer med_id  =  Integer.parseInt(prof_id_Field1.getText().trim());

        AdjacentFormController controller = new AdjacentFormController();
        ajs.add(prof_id.toString() + med_id.toString());

        Ajainst ajainst = new Ajainst (prof_id, med_id);
        dbHandler.signUpAjaist(ajainst);

        AdjacentFormController.ac.fillDate();
        try {
            controller.table_8.setItems(AdjacentFormController.ac.getAjainsts());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        prof_id_Field.setText("");
        prof_id_Field1.setText("");
    }
    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

}
