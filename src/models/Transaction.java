package src.models;

import java.util.Date;

public class Transaction {
    
    private int transactionId;
    private String studentErp;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;


    public Transaction(int transactionId, String studentErp, String bookId, Date borrowDate, Date returnDate )
    {
        this.transactionId = transactionId;
        this.studentErp = studentErp;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() { return transactionId; }
    public String getStudentErp() { return studentErp; }
    public String getBookId() { return bookId; }
    public Date getBorrowDate() { return borrowDate; } 
    public Date getReturnDate() { return returnDate; }

    @Override
    public String toString()
    {
        return "Transaction ID: " + transactionId + ", Student ERP: " + studentErp + ", Book ID: " + bookId + ", Borrow Date: " + borrowDate + ", Return Date: " + returnDate + "\n";
    }

}
