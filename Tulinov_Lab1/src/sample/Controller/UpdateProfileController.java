package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DBHandler;
import sample.Profile;

public class UpdateProfileController {

    public Button addButton;
    public Button cancelButton;
    public TextField prof_titleField;
    public Button goBackButton;

    private static DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        goBackButton.setOnAction(event -> goBack());

        cancelButton.setOnAction(actionEvent -> refreshFields());

        addButton.setOnAction(actionEvent -> updatePatient());
    }

    private void updatePatient() {
        String title = prof_titleField.getText().trim();
        ProfileFormController profileFormController = new ProfileFormController();

        Profile profile = new Profile(title, ProfileFormController.profile.getTitle());
        dbHandler.updateProfile(profile);

        ProfileFormController.profileCollection.fillDate();
        try {
            profileFormController.table_4.setItems(ProfileFormController.profileCollection.getProfiles());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void refreshFields() {
        prof_titleField.setText("");
    }

    private void goBack() {
        goBackButton.getScene().getWindow().hide();
    }
}
