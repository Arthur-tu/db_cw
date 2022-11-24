package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MedicalInstitutionCollection {
    private ObservableList<MedicalInstitution> meds =  FXCollections.observableArrayList();

    public void add(MedicalInstitution p) {meds.add(p); }

    public void delete(MedicalInstitution p) {meds.remove(p);}

    public ObservableList<MedicalInstitution> getMeds() {
        return meds;
    }

    public void fillDate() {
        DBHandler dbHandler = new DBHandler();
        ArrayList<MedicalInstitution> meds2 = dbHandler.getListMeds();
        meds.clear();
        meds.addAll(meds2);
    }
}
