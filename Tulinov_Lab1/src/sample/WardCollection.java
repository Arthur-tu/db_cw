package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class WardCollection {
    private ObservableList<Ward> wards =  FXCollections.observableArrayList();

    public void add(Ward w) {wards.add(w); }

    public void delete(Ward w) {wards.remove(w);}

    public ObservableList<Ward> getWards() {
        return wards;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Ward> wards2 = dbHandler.getListWards();
        wards.clear();
        wards.addAll(wards2);
    }
}
