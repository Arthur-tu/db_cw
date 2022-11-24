package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller.Query3FormController;
import sample.Controller.Query4FormController;

import java.util.ArrayList;

public class Q4Collection {
    private ObservableList<Q4Object> q4s =  FXCollections.observableArrayList();

    public void add(Q4Object q4) {q4s.add(q4); }

    public void delete(Q4Object q4) {q4s.remove(q4);}

    public ObservableList<Q4Object> getQ4s() {
        return q4s;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        Query4FormController query4FormController = new Query4FormController();
        ArrayList<Q4Object> q4Objects2 = dbHandler.getListQ4s(
                new Q4Object(query4FormController.q4.getMed(),query4FormController.q4.getStart_date(),
                        query4FormController.q4.getEnd_date()));
        q4s.clear();
        q4s.addAll(q4Objects2);
    }
}
