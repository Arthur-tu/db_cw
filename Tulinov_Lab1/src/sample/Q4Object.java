package sample;

import java.sql.Date;

public class Q4Object {
    private String med;
    private Date start_date;
    private Date end_date;
    private String name;
    private String surname;
    private String patronymic;

    public Q4Object(String med, Date start_date, Date end_date) {
        this.med = med;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Q4Object() {

    }

    public String getMed() {
        return med;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
