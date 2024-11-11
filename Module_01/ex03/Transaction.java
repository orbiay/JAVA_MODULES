import java.util.UUID;

public class Transaction {
    public enum Category {
        DEBITS,
        CREDITS
    }
    private Transaction next;

    private String id;
    private User recipient;
    private User sender;
    private Category category;
    private int amount;

    public Transaction(User recipient, User sender, Category category, int amount) {
        this.id = UUID.randomUUID().toString(); 
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        next = null;
        setAmount(amount); 
    }

    public String getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Category getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
    public Transaction getNextTransaction() {
        return next;
    }
    public void setNextTransaction(Transaction next) {
        this.next = next;
    }


    public void setAmount(int amount) {
        if (category == Category.DEBITS && amount >= 0) {
            System.out.println("Debit must be a negative amount.");
            System.exit(-1);
        } else if (category == Category.CREDITS && amount <= 0) {
            System.out.println("Credits must be a positive amount.");
            System.exit(-1);
        }
            this.amount = amount;
    }

}
