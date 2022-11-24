package sample;

public class Q5Object {
    private String med;
    private String prof;
    private String name;
    private String surname;
    private String patronymic;

    public Q5Object(String med, String prof) {
        this.med = med;
        this.prof = prof;
    }

    public Q5Object() {

    }

    public String getMed() {
        return med;
    }

    public String getProf() {
        return prof;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
