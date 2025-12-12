package Main;

public class Book {
    private int ID;
    private String Title;
    private String Author;
    private int copies;

    public Book( String Title, String Author, int copies) {
        this.Title = Title;
        this.Author = Author;
        this.copies = copies;
    }
    public Book( int ID, String Title, String Author, int copies) {
        this.ID = ID;
        this.Title = Title;
        this.Author = Author;
        this.copies = copies;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getTitle() {
        return Title;
    }
    public void  setTitle(String Title) {
        this.Title = Title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String Author) {
        this.Author = Author;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }
}
