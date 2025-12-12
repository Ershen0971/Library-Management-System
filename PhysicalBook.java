public class PhysicalBook extends LoanRecord {
    private int dueDate;
    private char shelfLocation;

    public PhysicalBook() {

    }

    public PhysicalBook(String bookID, String bookTitle, String bookAuthor, int quantity, int dueDate, char shelfLocation) {
        super(bookID, bookTitle, bookAuthor, quantity);
        this.dueDate = dueDate;
        this.shelfLocation = shelfLocation;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setShelfLocation(char shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public char getShelfLocation() {
        return shelfLocation;
    }

    public String toString() {
        return super.toString()
                + "\nDue Date: " + dueDate
                + "\nShelf Location: " + shelfLocation + "\n";
    }
}