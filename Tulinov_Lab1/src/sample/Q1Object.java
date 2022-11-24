package sample;

public class Q1Object {
    private String profile;
    private String med;
    private String name;
    private String surname;
    private String patronymic;
    private Integer count;

    public Q1Object(String profile, String med) {
        this.profile = profile;
        this.med = med;
    }

    public Q1Object() {

    }

    public String getProfile() {
        return profile;
    }

    public String getMed() {
        return med;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public Q1Object(String profile, String med, String name, String surname, String patronymic, Integer count) {
        this.profile = profile;
        this.med = med;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.count = count;
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

    public Integer getCount() {
        return count;
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

    public void setCount(Integer count) {
        this.count = count;
    }
}
