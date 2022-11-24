package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DepartamentCollection {
    private ObservableList<Departament> departaments =  FXCollections.observableArrayList();

    public void add(Departament p) {departaments.add(p); }

    public void delete(Departament p) {departaments.remove(p);}

    public ObservableList<Departament> getDepartaments() {
        return departaments;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Departament> departaments1 = dbHandler.getListDepartaments();
        departaments.clear();
        departaments.addAll(departaments1);
    }
}
