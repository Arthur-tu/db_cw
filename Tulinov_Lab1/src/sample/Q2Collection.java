package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller.Query2FormController;

import java.util.ArrayList;

public class Q2Collection {
    private ObservableList<Q2Object> q2s =  FXCollections.observableArrayList();

    public void add(Q2Object q2) {q2s.add(q2); }

    public void delete(Q2Object q2) {q2s.remove(q2);}

    public ObservableList<Q2Object> getQ2s() {
        return q2s;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        Query2FormController query2FormController = new Query2FormController();
        ArrayList<Q2Object> q2Objects2 = dbHandler.getListQ2s(
                new Q2Object(query2FormController.q2.getSpecialization(), query2FormController.q2.getMed(),
                        query2FormController.q2.getType()));
        q2s.clear();
        q2s.addAll(q2Objects2);
    }
}
