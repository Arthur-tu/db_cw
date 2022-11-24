package sample;

public class Q2Object {
    private String specialization;
    private String med;
    private String name;
    private String surname;
    private String patronymic;
    private String type;
    private Integer count;

    public Q2Object(String specialization, String med, String type) {
        this.specialization = specialization;
        this.med = med;
        this.type = "Обслуживающий персонал";
    }

    public Q2Object() {

    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getMed() {
        return med;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getType() {
        return type;
    }

    public Integer getCount() {
        return count;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
