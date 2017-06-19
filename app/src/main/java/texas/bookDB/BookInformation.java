package texas.bookDB;

import org.litepal.crud.DataSupport;

/**
 * Created by Texas on 2017/6/19.
 */

public class BookInformation extends DataSupport{
    private int bookID;
    private String bookNAME;
    private String bookAuthor;
    private int bookPrice;
    private String path;
    private String addition;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookNAME() {
        return bookNAME;
    }

    public void setBookNAME(String bookNAME) {
        this.bookNAME = bookNAME;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }
}
