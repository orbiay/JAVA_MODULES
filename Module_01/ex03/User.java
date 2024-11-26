import java.util.UUID;

class User {
    private int Identifier;
    private String Name;
    private int Balance;
    private TransactionsList listOfTransactions;
    public User(String Name,int Balance)
    {
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        setBalance(Balance);
        listOfTransactions = new TransactionsLinkedList();
        System.out.println("Parmeterized Constructor of User Class Called.");
    }
    public int getId() {
        return Identifier;
    }

    public void setTransaction(Transaction transaction)
    {
        if(transaction != null)
            listOfTransactions.addTransaction(transaction);
    }

    public int getSize()
    {
        return listOfTransactions.getSize();
    }
    public Transaction[] getTransactions()
    {
        return listOfTransactions.toArray();
    }
    public void deleteTransactionById(UUID id)
    {
        listOfTransactions.deleteTransactionById(id);
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
    public void setBalance(int balance) {
        if (balance < 0) {
            System.err.println("Balance must be a positive amount.");
            System.exit(-1);
        }
        this.Balance = balance;
    }
}