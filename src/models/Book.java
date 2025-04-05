package src.models;

public class Book {
    private String id;
    private String title;
    private String author;

    private Boolean isAvailable;

    public Book(String id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;

        isAvailable = true;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Boolean getAvailability() { return isAvailable; }

    public void setAvailability(Boolean availability) { this.isAvailable = availability; }

    @Override
    public String toString()
    {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + "\n";
    }
}
