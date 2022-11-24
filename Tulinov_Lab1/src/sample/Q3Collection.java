package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller.Query3FormController;

import java.util.ArrayList;

public class Q3Collection {
    private ObservableList<Q3Object> q3s =  FXCollections.observableArrayList();

    public void add(Q3Object q3) {q3s.add(q3); }

    public void delete(Q3Object q3) {q3s.remove(q3);}

    public ObservableList<Q3Object> getQ3s() {
        return q3s;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        Query3FormController query3FormController = new Query3FormController();
        ArrayList<Q3Object> q3Objects2 = dbHandler.getListQ3s(
                new Q3Object(query3FormController.q3.getMed()));
        q3s.clear();
        q3s.addAll(q3Objects2);
    }
}
