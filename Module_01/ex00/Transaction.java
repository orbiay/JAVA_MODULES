import java.util.UUID;

public class Transaction {
    public enum Category {
        DEBITS,
        CREDITS
    }

    private UUID id;
    private User recipient;
    private User sender;
    private Category category;
    private int amount;

    public Transaction(User recipient, User sender, Category category, int amount) {
        this.id = UUID.randomUUID();
        setRecipient(recipient);
        setSender(sender);
        setCategory(category);
        setAmount(amount);
    }

    public UUID getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        if (recipient == null) {
            System.err.println("Error: unaccesptable arguments (recipent)");
            System.exit(-1);
        }
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        if (sender == null) 
        {
            System.err.println("Error: unaccesptable arguments (sender)");
            System.exit(-1);
        }
        this.sender = sender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) 
        {
            System.err.println("Error: unaccesptable arguments (Category)");
            System.exit(-1);
        }
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (category == Category.DEBITS && amount >= 0)
        {
            System.err.println("Error: unaccesptable arguments (Amount)");
            System.exit(-1);
        }
        else if (category == Category.CREDITS && amount <= 0) 
        {
            System.err.println("Error: unaccesptable arguments (Amount)");
            System.exit(-1);
        }
        this.amount = amount;
    }
}
