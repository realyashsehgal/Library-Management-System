package src.models;

public class Book {
    private String id;
    private String title;
    private String author;

    private String availability;

    public Book(String id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getAvailability() { return availability; }

    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public String toString()
    {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + "\n";
    }
}
