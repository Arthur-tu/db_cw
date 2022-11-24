package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller.Query1FormController;

import java.util.ArrayList;

public class Q1Collection {
    private ObservableList<Q1Object> q1s =  FXCollections.observableArrayList();

    public void add(Q1Object q1) {q1s.add(q1); }

    public void delete(Q1Object q1) {q1s.remove(q1);}

    public ObservableList<Q1Object> getQ1s() {
        return q1s;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        Query1FormController query1FormController = new Query1FormController();
        ArrayList<Q1Object> q1Objects2 = dbHandler.getListQ1s(
                new Q1Object(query1FormController.q1.getProfile(), query1FormController.q1.getMed()));
        q1s.clear();
        q1s.addAll(q1Objects2);
    }
}
