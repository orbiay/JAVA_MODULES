class User {
    private int Identifier;
    private String Name;
    private int Balance;
    
    public User(int Identifier ,String Name,int Balance)
    {
        setId(Identifier);
        setName(Name);
        setBalance(Balance);
        System.out.println("Balance is "  +  this.Balance + " Name is " + this.Name);
        System.out.println("Parmeterized Constructor of User Class Called.");
    }
    public int getId() {
        return Identifier;
    }
    public void setId(int id) {
        Identifier = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name)
    {
        if (name == null) {
            System.err.println("Error: unaccesptable arguments (recipent)");
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