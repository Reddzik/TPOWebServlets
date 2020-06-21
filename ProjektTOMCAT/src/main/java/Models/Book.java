package Models;

public class Book {
    private int id;
    private String title;
    private String authorName;
    private String authorLastName;


    public Book(int id, String title, String authorName, String authorLastName){
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

}
