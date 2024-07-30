import java.util.UUID;

public class LibraryItem {
    private String title;
    private String author;
    private UUID itemId = UUID.randomUUID();

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.itemId = UUID.randomUUID();
    }

    public LibraryItem() {
        this.title = title;
        this.author = author;
        this.itemId = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public UUID getItemId() {
        return itemId;
    }


}
