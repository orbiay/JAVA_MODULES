import java.util.UUID;
class User {
    private int Identifier;
    String Name;
    int Balance;
    private TransactionsList listOfTransactions;
    
    public User(String Name,int Balance)
    {
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        setBalance(Balance);
        listOfTransactions = new TransactionsLinkedList();
        System.out.println("Parmeterized Constructor of User Class Called.");
    }

    public int getSize()
    {
        return listOfTransactions.getSize();
    }

    public void setTransaction(Transaction transaction)
    {
        listOfTransactions.addTransaction(transaction);
    }
    public Transaction[] getTransactions()
    {
        return listOfTransactions.toArray();
    }
    public int getId() {
        return Identifier;
    }
    public void creditTransfer(int amount)
    {
        Balance -= amount;
    }
    public void debitTransfer(int amount)
    {
        Balance += amount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name)
    {
        if (name == null) {
            System.err.println("Error: unaccesptable arguments ");
            System.exit(-1);
        }
        this.Name = name;
    }

    public int getBalance() {
        return Balance;
    }
    public void deleteTransactionById(UUID id)
    {
        listOfTransactions.deleteTransactionById(id);
    }
    public void setBalance(int balance) {
        if (balance < 0) {
            System.out.println("Balance must be a positive amount.");
        }
        this.Balance = balance;
    }
}