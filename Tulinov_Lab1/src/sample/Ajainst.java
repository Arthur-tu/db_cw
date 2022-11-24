package sample;

public class Ajainst {
    private Integer profile_id;
    private Integer med_institut_id;

    public Ajainst(Integer profile_id, Integer med_institut_id) {
        this.profile_id = profile_id;
        this.med_institut_id = med_institut_id;
    }

    public Ajainst() {

    }

    public Integer getProfile_id() {
        return profile_id;
    }

    public Integer getMed_institut_id() {
        return med_institut_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }

    public void setMed_institut_id(Integer med_institut_id) {
        this.med_institut_id = med_institut_id;
    }
}
