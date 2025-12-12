import java.util.*;
import java.io.*;

public class LibraryManagementSystem {
    public static ArrayList<MemberRegistration> memberRegistration = new ArrayList<>();
    public static ArrayList<LoanRecord> loanRecord = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int fileNum = 1;
    public static void main(String[] args) {
        int option;

        do {
            try {
                System.out.print("""
                        ---------------------
                        Library Management System
                        ---------------------
                        1. New Library Member Registration
                        2. Borrow / Access Resources
                        3. Manage Member Account (Credit / Fines)
                        4. View / Return Loans
                        5. Exits
                        
                        Select option >>>""");
                option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1:
                        memberRegistration();
                        break;
                    case 2:
                        borrowAccessResources();
                        break;
                    case 3:
                        manageMemberAccount();
                        break;
                    case 4:
                        viewReturnLoans();
                        break;
                    case 5:
                        System.out.println("Exit successfully.");
                        break;
                    default:
                        System.out.println("Invalid value, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                input.nextLine();
                option = 0;
            } catch (Exception e) {
                System.out.println("Unknown error, please try again.");
                input.nextLine();
                option = 0;
            }
        } while (option != 5);
    }

    public static void memberRegistration() {
        try {
            Random random = new Random();
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            String memberID = "TC" + random.nextInt(1000, 10000);
            System.out.println("Your Member ID: " + memberID);
            int point = 100;
            MemberRegistration member = new MemberRegistration(memberID, name, point);
            memberRegistration.add(member);
        } catch (Exception e) {
            System.out.println("Unknown error, please try again.");
        }
    }

    public static void borrowAccessResources() {
        try {
            System.out.print("Enter Member ID: ");
            String memberID = input.next();
            MemberRegistration member = findMemberID(memberID);

            if (member == null) {
                System.out.println("Invalid value, please try again.");
                return;
            }

            System.out.print("Choose for (1.Physical Book Borrowing / 2.Digital Resource Access): ");
            int choice = input.nextInt();
            String bookID;

            switch (choice) {
                case 1:
                    PhysicalBook physicalList;
                    int dueDate = 7;
                    System.out.println("""
                            ------------------------------------------------------------------------------------
                            |  ID  |            Title            |          Author          | Available Copies |
                            | 123A |      The Silent Patient     |      Alex Michaelides    |         4        |
                            | 234B |          Homo Deus          |      Yuval Noah Harari   |         2        |
                            | 345C |     The Midnight Library    |         Matt Haig        |         5        |
                            | 456D |          Educated           |       Tara Westover      |         3        |
                            | 567E |        Atomic Habits        |        James Clear       |         6        |
                            ------------------------------------------------------------------------------------
                            """);

                    while (true) {
                        System.out.print("Enter Book ID (enter 'end' for end): ");
                        bookID = input.next();
                        switch (bookID) {
                            case "123A": {
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                if (quantity > 4) {
                                    System.out.println("Invalid value in quantity, please try again");
                                } else {
                                    char shelfLocation = 'A';
                                    physicalList = new PhysicalBook(bookID, "The Silent Patient", "Alex Michaelides", quantity, dueDate, shelfLocation);
                                    loanRecord.add(physicalList);
                                }
                                break;
                            }

                            case "234B": {
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                if (quantity > 2) {
                                    System.out.println("Invalid value in quantity, please try again");
                                } else {
                                    char shelfLocation = 'B';
                                    physicalList = new PhysicalBook(bookID, "Homo Deus", "Yuval Noah Harari", quantity, dueDate, shelfLocation);
                                    loanRecord.add(physicalList);
                                }
                                break;
                            }

                            case "345C": {
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                if (quantity > 2) {
                                    System.out.println("Invalid value quantity, please try again");
                                } else {
                                    char shelfLocation = 'C';
                                    physicalList = new PhysicalBook(bookID, "The Midnight Library", "Matt Haig", quantity, dueDate, shelfLocation);
                                    loanRecord.add(physicalList);
                                }
                                break;
                            }

                            case "456D": {
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                if (quantity > 5) {
                                    System.out.println("Invalid value quantity, please try again");
                                } else {
                                    char shelfLocation = 'D';
                                    physicalList = new PhysicalBook(bookID, "Educated", "Tara Westover", quantity, dueDate, shelfLocation);
                                    loanRecord.add(physicalList);
                                }
                                break;
                            }

                            case "567E": {
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                if (quantity > 5) {
                                    System.out.println("Invalid value in quantity, please try again");
                                } else {
                                    char shelfLocation = 'E';
                                    physicalList = new PhysicalBook(bookID, "Atomic Habits", "James Clear", quantity, dueDate, shelfLocation);
                                    loanRecord.add(physicalList);
                                }
                                break;
                            }

                            case "end": {
                                return;
                            }

                            default: {
                                System.out.println("Invalid value in ID, please try again");
                                break;
                            }
                        }
                    }
                case 2:
                    DigitalAccess digitalList;
                    int quantity = 1;
                    System.out.println("""
                            ---------------------------------------------------------------------------------------------
                            |  ID  |            Title            |          Author          |        Access Link        |
                            | A123 |    To Kill a Mockingbird    |        Harper Lee        |  https://www.book1.com    |
                            | B234 |            1984             |      George Orwell       |  https://www.book2.com    |
                            | C345 |     Pride and Prejudice     |       Jane Austen        |  https://www.book3.com    |
                            | D456 |       The Great Gatsby      |    F. Scott Fitzgerald   |  https://www.book4.com    |
                            | E567 |        The Alchemist        |       Paulo Coelho       |  https://www.book5.com    |
                            ---------------------------------------------------------------------------------------------
                            """);
                    while (true) {
                        System.out.print("Enter Book ID (enter 'end' for end): ");
                        bookID = input.next();
                        switch (bookID) {
                            case "A123": {
                                System.out.print("How many days you want to borrow: ");
                                int accessDurationDays = input.nextInt();

                                if (accessDurationDays * 2 * 100 > member.getCreditPoint()) {
                                    System.out.println("Not enough points to pay, please top in.");
                                    manageMemberAccount();
                                    break;
                                } else {
                                    member.deductCreditPoint(accessDurationDays * 2 * 100);
                                }

                                digitalList = new DigitalAccess(bookID, "To Kill a Mockingbird", "Harper Lee", quantity, "https://www.book1.com ", accessDurationDays);
                                loanRecord.add(digitalList);
                                break;
                            }

                            case "B234": {
                                System.out.print("How many days you want to borrow: ");
                                int accessDurationDays = input.nextInt();

                                if (accessDurationDays * 2 * 100 > member.getCreditPoint()) {
                                    System.out.println("Not enough points to pay, please top in.");
                                    manageMemberAccount();
                                    break;
                                } else {
                                    member.deductCreditPoint(accessDurationDays * 2 * 100);
                                }

                                digitalList = new DigitalAccess(bookID, "1984 ", "George Orwell", quantity, "https://www.book2.com ", accessDurationDays);
                                loanRecord.add(digitalList);
                                break;
                            }

                            case "C345": {
                                System.out.print("How many days you want to borrow: ");
                                int accessDurationDays = input.nextInt();

                                if (accessDurationDays * 2 * 100 > member.getCreditPoint()) {
                                    System.out.println("Not enough points to pay, please top in.");
                                    manageMemberAccount();
                                    break;
                                } else {
                                    member.deductCreditPoint(accessDurationDays * 2 * 100);
                                }

                                digitalList = new DigitalAccess(bookID, "Pride and Prejudice", "Jane Austen", quantity, "https://www.book3.com ", accessDurationDays);
                                loanRecord.add(digitalList);
                                break;
                            }

                            case "D456": {
                                System.out.print("How many days you want to borrow: ");
                                int accessDurationDays = input.nextInt();

                                if (accessDurationDays * 2 * 100 > member.getCreditPoint()) {
                                    System.out.println("Not enough points to pay, please top in.");
                                    manageMemberAccount();
                                    break;
                                } else {
                                    member.deductCreditPoint(accessDurationDays * 2 * 100);
                                }

                                digitalList = new DigitalAccess(bookID, "The Great Gatsby", "F. Scott Fitzgerald", quantity, "https://www.book1.com ", accessDurationDays);
                                loanRecord.add(digitalList);
                                break;
                            }

                            case "E567": {
                                System.out.print("How many days you want to borrow: ");
                                int accessDurationDays = input.nextInt();

                                if (accessDurationDays * 2 * 100 > member.getCreditPoint()) {
                                    System.out.println("Not enough points to pay, please top in.");
                                    manageMemberAccount();
                                    break;
                                } else {
                                    member.deductCreditPoint(accessDurationDays * 2 * 100);
                                }

                                digitalList = new DigitalAccess(bookID, "The Alchemist", "Paulo Coelho", quantity, "https://www.book1.com ", accessDurationDays);
                                loanRecord.add(digitalList);
                                break;
                            }

                            case "end": {
                                return;
                            }

                            default: {
                                System.out.println("Invalid value in ID, please try again");
                                break;
                            }
                        }
                    }
                default:
                    System.out.println("Invalid value, please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a integer number.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Unknown error, please try again.");
        }
    }

    public static void manageMemberAccount() {
        try {
            System.out.print("Enter your member ID: ");
            String memberID = input.next();
            MemberRegistration member = findMemberID(memberID);

            if (member == null) {
                System.out.println("Invalid value, please try again.");
                return;
            }

            System.out.println("Your current credit point are: " + member.getCreditPoint());
            System.out.print("""
                    -----------------------------------------------
                    Select the amount you need to add
                    (RM0.50 will be deducted as a transaction fee)
                    (1) RM5
                    (2) RM10
                    (3) RM20
                    (4) RM50
                    -----------------------------------------------
                    Enter your option: """);
            int option = input.nextInt();
            double transactionFee = 0.50;
            double totalCost;

            switch (option) {
                case 1:
                    member.addCreditPoint(500);
                    totalCost = 5 + transactionFee;
                    System.out.println("Your cost are RM" + String.format("%.2f", totalCost));
                    break;

                case 2:
                    member.addCreditPoint(1000);
                    totalCost = 10 + transactionFee;
                    System.out.println("Your cost are RM" + String.format("%.2f", totalCost));
                    break;

                case 3:
                    member.addCreditPoint(2000);
                    totalCost = 20 + transactionFee;
                    System.out.println("Your cost are RM" + String.format("%.2f", totalCost));
                    break;

                case 4:
                    member.addCreditPoint(5000);
                    totalCost = 50 + transactionFee;
                    System.out.println("Your cost are RM" + String.format("%.2f", totalCost));
                    break;

                default:
                    System.out.println("Invalid value, please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter integer number.");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Unknown error, please try again.");
            input.nextLine();
        }
    }

    public static void viewReturnLoans() {
        MemberRegistration member;
        boolean hasPhysical = false;
        boolean hasDigital = false;
        boolean repeat;
        String memberID;

        do {
            repeat = false;
            System.out.print("Enter Member ID: ");
            memberID = input.next();
            member = findMemberID(memberID);

            if (member == null) {
                System.out.println("Invalid value, please try again.");
                repeat = true;
            }
        } while(repeat);

        if (loanRecord.isEmpty()) {
            System.out.println("There are no any record.");
            return;
        }
        else {
            for (LoanRecord loan : loanRecord) {
                if (loan instanceof PhysicalBook) {
                    hasPhysical = true;
                }
                if (loan instanceof DigitalAccess) {
                    hasDigital = true;
                }
            }

            if (hasPhysical) {
                System.out.println("Physical Loan:");
                for (LoanRecord loan : loanRecord) {
                    if (loan instanceof PhysicalBook) {
                        System.out.println("Record#" + (loanRecord.indexOf(loan) + 1) + loan);
                    }
                }
            }

            if (hasDigital) {
                System.out.println("Digital Access Loan:");
                for (LoanRecord loan : loanRecord) {
                    if (loan instanceof DigitalAccess) {
                        System.out.println("Record#" + (loanRecord.indexOf(loan) + 1) + loan);
                    }
                }
            }
        }

        int num;

        try {
            System.out.print("Enter the number of record you want to return/view: ");
            num = input.nextInt();

            if (num > 0 && num <= loanRecord.size()) {
                LoanRecord selectedLoan = loanRecord.get(num - 1);
                System.out.println("Processing for:\n" + selectedLoan);

                LoanRecord loan = loanRecord.get(num - 1);

                if (loan instanceof PhysicalBook) {
                    System.out.print("How many days did you borrow: ");
                    int day = input.nextInt();
                    if (day > ((PhysicalBook) loan).getDueDate()) {
                        double fines = day - ((PhysicalBook) loan).getDueDate() * 0.50;
                        System.out.print("Enter payment option(1.via credit points / 2.direct cash): ");
                        int option = input.nextInt();

                        switch (option) {
                            case 1: {
                                if (fines != 0) {
                                    if (fines * 100 > member.getCreditPoint()) {
                                        System.out.println("Not enough points to pay, please top in.");
                                        manageMemberAccount();
                                        break;
                                    }
                                    else {
                                        member.deductCreditPoint((int) fines * 100);
                                        loanRecord.remove(num - 1);
                                        System.out.println("Loan Processed.");
                                    }
                                    break;
                                }
                                else {
                                    loanRecord.remove(num - 1);
                                    System.out.println("Loan Processed.");
                                }
                                break;
                            }

                            case 2: {
                                System.out.println("Your fines are RM" + String.format("%.2f", fines));
                                member.addCreditPoint((int) fines);
                                System.out.println("You have added " + (int) fines + " points to your account.");
                                loanRecord.remove(num - 1);
                                System.out.println("Loan Processed.");
                                printReceipt(memberID, loan, fines);
                                fileNum++;
                                break;
                            }

                            default: {
                                System.out.println("Invalid value, please try again.");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("You have no fines need to pay.");
                        loanRecord.remove(num - 1);
                    }
                }
                if (loan instanceof DigitalAccess) {
                    System.out.println("Access Link: " + ((DigitalAccess) loan).getAccessLink() + "\nAccess Duration Days: " + ((DigitalAccess) loan).getAccessDurationDays());
                }
            }
            else {
                System.out.println("Invalid value, please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter integer number.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid value of index enter, please try again.");
        } catch (Exception ex) {
            System.out.println("Unknown error, please try again.");
        }
    }

    public static MemberRegistration findMemberID(String memberID) {
        for (MemberRegistration member : memberRegistration) {
            if (member.getMemberID().equalsIgnoreCase(memberID)) {
                return member;
            }
        }
        return null;
    }

    public static void printReceipt(String memberID, LoanRecord book, double fines) {
        try (FileWriter writer = new FileWriter("receipt" + fileNum + ".txt")) {
            writer.write("===== Library Receipt =====\n");
            writer.write("Member ID: " + memberID + "\n");
            writer.write("Book ID: " + book.getBookID() + "\n");
            writer.write("Title  : " + book.getBookTitle() + "\n");
            writer.write("Author : " + book.getBookAuthor() + "\n");
            writer.write("Quantity: " + book.getQuantity() + "\n");
            writer.write("Amount: " + fines + "\n");
            writer.write("---------------------------\n\n");

            System.out.println("Receipt saved to receipt" + fileNum + ".txt");

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}