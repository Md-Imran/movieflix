package cine.emon.live.com.cinematic.model;

public class UpComingMovie {
    private String title;
    private String description;
    private String date;
    private String imagePath;

    public UpComingMovie() {
    }


    public UpComingMovie(String imagePath, String title, String date) {
        this.imagePath = imagePath;
        this.title = title;
        this.date = date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
