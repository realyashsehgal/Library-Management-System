package src.models;

public class Book {
    private String id;
    private String name;
    private String author;

    private Boolean isAvailable;

    public Book(String id, String name, String author)
    {
        this.id = id;
        this.name = name;
        this.author = author;

        isAvailable = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public Boolean getAvailability() { return isAvailable; }

    public void setAvailability(Boolean availability) { this.isAvailable = availability; }

    @Override
    public String toString()
    {
        return "ID: " + id + ", Name: " + name + ", Author: " + author + "\n";
    }
}
