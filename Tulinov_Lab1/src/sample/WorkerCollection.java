package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class WorkerCollection {
    private ObservableList<Worker> workers =  FXCollections.observableArrayList();

    public void add(Worker w) {workers.add(w); }

    public void delete(Worker w) {workers.remove(w);}

    public ObservableList<Worker> getWorkers() {
        return workers;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Worker> workers1 = dbHandler.getListWorkers();
        workers.clear();
        workers.addAll(workers1);
    }
}
