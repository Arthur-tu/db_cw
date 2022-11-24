package sample;

public class Profile {
    private String title;
    private String oldtitle;

    public Profile(String title) {
        this.title = title;
    }

    public Profile(String title, String oldTitle) {
        this.title = title;
        this.oldtitle = oldTitle;
    }

    public Profile() {

    }

    public String getTitle() {
        return title;
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
