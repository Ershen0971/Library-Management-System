public abstract class LoanRecord {
    public String bookID;
    public String bookTitle;
    public String bookAuthor;
    public int quantity;

    public LoanRecord() {

    }

    public LoanRecord(String bookID, String bookTitle, String bookAuthor, int quantity) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "\nBook ID: " + bookID
               + "\nBook Title: " + bookTitle
               + "\nBook Author: " + bookAuthor
                + "\nQuantity: " + quantity;
    }
}