package sample;

public class Departament {
    private Integer id_med_institutions;
    private String title;

    private String oldtitle;

    public Departament(Integer id_med_institutions, String title) {
        this.id_med_institutions = id_med_institutions;
        this.title = title;
    }

    public Departament(Integer id_med_institutions, String title, String oldtitle) {
        this.oldtitle = oldtitle;
        this.id_med_institutions = id_med_institutions;
        this.title = title;

    }

    public Departament() {

    }

    public Departament(Integer med_id) {
    }

    public Integer getId_med_institutions() {
        return id_med_institutions;
    }

    public String getTitle() {
        return title;
    }

    public void setId_med_institutions(Integer id_med_institutions) {
        this.id_med_institutions = id_med_institutions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldtitle() {
        return oldtitle;
    }

    public void setOldtitle(String oldtitle) {
        this.oldtitle = oldtitle;
    }
}
