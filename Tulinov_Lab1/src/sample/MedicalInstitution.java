package sample;

import java.sql.Date;

public class MedicalInstitution {
    private String title;
    private String purpose;
    private String type;
    private String contact_data;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContact_data(String contact_data) {
        this.contact_data = contact_data;
    }

    public MedicalInstitution() {

    }

    public MedicalInstitution(String title, String purpose, String type, String contact_data) {
        this.title = title;
        this.purpose = purpose;
        this.type = type;
        this.contact_data = contact_data;
    }

    public String getTitle() {
        return title;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getType() {
        return type;
    }

    public String getContact_data() {
        return contact_data;
    }
}
