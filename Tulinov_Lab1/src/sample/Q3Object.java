package sample;

import java.sql.Date;

public class Q3Object {
    private String med;
    private Date date;
    private String name;
    private String surname;
    private String patronymic;
    private String health;
    private Integer temperature;
    private String docname;
    private String docsurname;
    private String docpatronymic;


    public Q3Object(String med) {
        this.med = med;
    }

    public Q3Object() {

    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public Date getDate() {
        return date;
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

    public String getHealth() {
        return health;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getDocname() {
        return docname;
    }

    public String getDocsurname() {
        return docsurname;
    }

    public String getDocpatronymic() {
        return docpatronymic;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setHealth(String health) {
        this.health = health;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public void setDocsurname(String docsurname) {
        this.docsurname = docsurname;
    }

    public void setDocpatronymic(String docpatronymic) {
        this.docpatronymic = docpatronymic;
    }
}
