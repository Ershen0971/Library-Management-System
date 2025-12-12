public class DigitalAccess extends LoanRecord{
    private String accessLink;
    private int accessDurationDays;

    public DigitalAccess() {

    }

    public DigitalAccess(String bookID, String bookTitle, String bookAuthor, int quantity, String accessLink, int accessDurationDays) {
        super(bookID, bookTitle, bookAuthor, quantity);
        this.accessLink = accessLink;
        this.accessDurationDays = accessDurationDays;
    }

    public String getAccessLink() {
        return accessLink;
    }

    public void setAccessLink(String accessLink) {
        this.accessLink = accessLink;
    }

    public int getAccessDurationDays() {
        return accessDurationDays;
    }

    public void setAccessDurationDays(int accessDurationDays) {
        this.accessDurationDays = accessDurationDays;
    }

    public String toString() {
        return super.toString()
                + "\nAccess Link: " + accessLink
                + "\nAccess Duration Days: " + accessDurationDays + "\n";
    }
}
