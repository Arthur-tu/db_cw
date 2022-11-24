package sample.Controller;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Profile;
import java.util.Set;

public class NewProfileFormController {
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField titleField;
    @FXML
    private Button goBackButton;

    private static Set<String> profiles;
    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();
        profiles = dbHandler.getProfilesSet();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> TryAddNewPProfile());
    }

    private void refreshFields() { titleField.setText(""); }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }

    private void TryAddNewPProfile() {
        if (!profiles.contains(titleField.getText().trim())) {
            AddNewProfile();
            System.out.println("Профиль добавлен");
        } else {
            Shake shakeLogin = new Shake(addButton);
            shakeLogin.playAnimation();
            System.out.println("Такой профиль уже есть");
        }
    }

    private void AddNewProfile() {

        String title = titleField.getText().trim();

        ProfileFormController profileFormController = new ProfileFormController();
        profiles.add(title);

        Profile profile = new Profile(title);
        dbHandler.signUpProfile(profile);

        ProfileFormController.profileCollection.fillDate();
        try {
            profileFormController.table_4.setItems(ProfileFormController.profileCollection.getProfiles());
        } catch (Exception e) {
            System.out.println();
        }
    }

}
