package br.com.project.moonlight.database;

public class DataClass {
    private String imageURL;
    private String caption;
    private String description;
    private String value;
    private String date;

    public DataClass() {
        // Construtor vazio necessário para Firebase
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DataClass(String imageURL, String caption, String description, String value, String date) {
        this.imageURL = imageURL;
        this.caption = caption;
        this.description = description;
        this.value = value;
        this.date = date;
    }
}
