package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PatientCollection {
    private ObservableList<Patient> patients =  FXCollections.observableArrayList();

    public void add(Patient p) {patients.add(p); }

    public void delete(Patient p) {patients.remove(p);}

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<Patient> patients2 = dbHandler.getListPatirnts();
        patients.clear();
        patients.addAll(patients2);
    }
}
