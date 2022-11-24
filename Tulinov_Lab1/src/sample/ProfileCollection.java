package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ProfileCollection {
    private ObservableList<Profile> profiles =  FXCollections.observableArrayList();

    public void add(Profile p) {profiles.add(p); }

    public void delete(Profile p) {profiles.remove(p);}

    public ObservableList<Profile> getProfiles() {
        return profiles;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Profile> profiles2 = dbHandler.getListProfiles();
        profiles.clear();
        profiles.addAll(profiles2);
    }
}
