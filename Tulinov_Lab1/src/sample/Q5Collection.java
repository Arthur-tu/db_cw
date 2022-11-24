package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller.Query4FormController;
import sample.Controller.Query5FormController;

import java.util.ArrayList;

public class Q5Collection {
    private ObservableList<Q5Object> q5s =  FXCollections.observableArrayList();

    public void add(Q5Object q5) {q5s.add(q5); }

    public void delete(Q5Object q5) {q5s.remove(q5);}

    public ObservableList<Q5Object> getQ5s() {
        return q5s;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        Query5FormController query5FormController = new Query5FormController();
        ArrayList<Q5Object> q5Objects2 = dbHandler.getListQ5s(
                new Q5Object(query5FormController.q5.getMed(),query5FormController.q5.getProf()));
        q5s.clear();
        q5s.addAll(q5Objects2);
    }
}
