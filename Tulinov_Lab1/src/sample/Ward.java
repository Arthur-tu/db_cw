package sample;

public class Ward {
    private Integer departaments_id;
    private String title;

    public Ward(Integer departaments_id, String title) {
        this.departaments_id = departaments_id;
        this.title = title;
    }

    public Ward() {

    }

    public Integer getDepartaments_id() {
        return departaments_id;
    }

    public String getTitle() {
        return title;
    }

    public void setDepartaments_id(Integer departaments_id) {
        this.departaments_id = departaments_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
