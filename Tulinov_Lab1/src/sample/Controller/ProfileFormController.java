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

public class ProfileFormController {
    @FXML
    private Button addPofileButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    public TableView table_4;
    @FXML
    private TableColumn<Profile, String> titleProfile_clm;
    @FXML
    private Button changeButton777;

    public static ProfileCollection profileCollection = new ProfileCollection();

    public static Profile profile;
    @FXML
    void initialize() {
        titleProfile_clm.setCellValueFactory(new PropertyValueFactory<Profile,String>("title"));

        profileCollection.fillDate();
        table_4.setItems(profileCollection.getProfiles());

        backButton.setOnAction(event-> goBack());

        addPofileButton.setOnAction(actionEvent -> addNewProfile());

        changeButton777.setOnAction(actionEvent -> {
            profile = (Profile) table_4.getSelectionModel().getSelectedItem();
            openNewModalScene("/sample/fxml/updateProfile.fxml","Изменение профиля");
        });

        cancelButton.setOnAction(actionEvent -> deleteProfile());
    }

    private void deleteProfile() {
        Profile profile = (Profile) table_4.getSelectionModel().getSelectedItem();
        DBHandler dbHandler = new DBHandler();
        dbHandler.deleteProfile(profile);
        ProfileFormController.profileCollection.fillDate();
        try {
            ProfileFormController profileFormController = new ProfileFormController();
            profileFormController.table_4.setItems(ProfileFormController.profileCollection.getProfiles());
        } catch (Exception e) {
            System.out.println();
        }
    }

    private void addNewProfile() {
        openNewModalScene("/sample/fxml/newProfileForm.fxml","Добавление больного");
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
