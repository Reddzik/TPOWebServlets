package Models;

public class Book {
    private int id;
    private String title;
    private String authorName;

    public Book(int id, String title, String authorName){
        this.id = id;
        this.title = title;
        this.authorName = authorName;
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

}
