package sample;

import java.sql.Date;

public class Patient {
    private Integer idWard;
    private Integer idWorker;
    private String name;
    private String surname;
    private String partonynic;
    private Date start_time;
    private Date end_time;
    private String health;
    private Integer temperature;

    public void setIdWard(Integer idWard) {
        this.idWard = idWard;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
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

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Patient() {

    }

    public Patient(Integer idWard, Integer idWorker, String name, String surname, String partonynic, Date start_time, Date end_time, String health, Integer temperature) {
        this.idWard = idWard;
        this.idWorker = idWorker;
        this.name = name;
        this.surname = surname;
        this.partonynic = partonynic;
        this.start_time = start_time;
        this.end_time = end_time;
        this.health = health;
        this.temperature = temperature;
    }

    public Integer getIdWard() {
        return idWard;
    }

    public Integer getIdWorker() {
        return idWorker;
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

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getHealth() {
        return health;
    }

    public Integer getTemperature() {
        return temperature;
    }
}
