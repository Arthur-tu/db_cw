package sample;

public class Worker {
    private Integer med_id;
    private String name;
    private String surname;
    private String partonynic;
    private String specilization;
    private String categoty;
    private String type;

    public void setIdMedical(Integer med_id) {
        this.med_id = med_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPartonynic(String partonynic) {
        this.partonynic = partonynic;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Worker() {

    }

    public Worker(Integer med_id, String name, String surname, String partonynic, String specilization, String categoty, String type) {
        this.med_id = med_id;
        this.name = name;
        this.surname = surname;
        this.partonynic = partonynic;
        this.specilization = specilization;
        this.categoty = categoty;
        this.type = type;
    }

    public Integer getMed_id() {
        return med_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPartonynic() {
        return partonynic;
    }

    public String getSpecilization() {
        return specilization;
    }

    public String getCategoty() {
        return categoty;
    }

    public String getType() {
        return type;
    }
}
