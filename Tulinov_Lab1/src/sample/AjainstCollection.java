package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AjainstCollection {
    private ObservableList<Ajainst> ajainsts =  FXCollections.observableArrayList();

    public void add(Ajainst p) {ajainsts.add(p); }

    public void delete(Ajainst p) {ajainsts.remove(p);}

    public ObservableList<Ajainst> getAjainsts() {
        return ajainsts;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Ajainst> ajainsts1 = dbHandler.getListAjainst();
        ajainsts.clear();
        ajainsts.addAll(ajainsts1);
    }
}
